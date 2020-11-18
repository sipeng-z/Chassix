package com.project.controller;

import com.casting.domain.entity.DeviceWiseSession;
import com.core.controller.GenericController;
import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.model.AppConsts;
import com.project.domain.entity.*;
import com.project.domain.model.input.GeneralOEEDataInput;
import com.project.domain.model.output.GeneralOEEDataOutput;
import com.project.domain.model.output.LineDeviceOutput;
import com.project.domain.workbench.auth;
import com.project.domain.workbench.forapi;
import com.project.domain.workbench.params;
import com.project.service.*;
import com.response.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping(value = "MachineOverview")
public class MachineOverviewController extends GenericController<GeneralOEEDataInput, GeneralOEEDataOutput> {

    private final Logger logger = LoggerFactory.getLogger(MachineOverviewController.class);

    @Autowired
    private GeneralOEEDataService generalOEEDataService;

    @Autowired
    private EMP2ASSYOEEDataService emp2ASSYOEEDataService;

    @Autowired
    private EMP2ASSYPQDataService emp2ASSYPQDataService;

    @Autowired
    private GeneralPQDataService generalPQDataService;

    @Autowired
    private LineDeviceService lineDeviceService;

    @Autowired
    private ConversionToolService conversionToolService;

    @Autowired
    private MachineOverviewService machineOverviewService;

    @Autowired
    private MachDeviceWiseSessionService machDeviceWiseSessionService;

    @Override
    protected void OnActionExecuting() {
        generalOEEDataService.SetWorkContext(this.WorkContext);
    }

    protected AbstractService<GeneralOEEDataInput,GeneralOEEDataOutput> getService() {
        return generalOEEDataService;
    }

    /**
     * get all devices oee by dateString and shift number
     * return
     * @param
     * @param
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "allDevicesOEE",method = RequestMethod.GET)
    public ResponseResult getAllDeviceOee(String DateString) throws Exception{
        ResponseResult result = new ResponseResult();
        List<MachineOverviewValue> outList = new ArrayList<>();
        String[] lines = AppConsts.monitoringLines;

        Integer[]  record= null;
        Integer[] shift1= new Integer[]{1,32};
        Integer[] shift2= new Integer[]{33,64};
        Integer[] shift3= new Integer[]{65,96};


        List<String> lineDeviceNames = new ArrayList<>();
        List<LineDeviceOutput> lineDevices = new ArrayList<>();
        for(String lineName : lines){

            PageData pageData4line = new PageData();
            pageData4line.put("lineName",lineName);
            lineDevices = lineDeviceService.list(false,pageData4line);//get device name from line name
            if (lineDevices.size() == 0){
                lineDeviceNames.add(lineName);
            }
            for(LineDevice lineDevice : lineDevices){
                lineDeviceNames.add(lineName+" "+lineDevice.getName());   //push all device names into the String List
            }

        }


        //loop for  Oee data of each device from the list
        // device1  shift1 shift2 shift3
        //device2 shift1 shift2 shift3
        //...
        for(String lineDeviceName1 : lineDeviceNames ){
            String lineDeviceName = lineDeviceName1.replaceAll(" ", "");
            MachineOverviewValue machineOverviewValue = new MachineOverviewValue();
            if (lineDeviceName.contains("G38")) {
                for (int j = 0; j < 3; j++) {
                    if (j == 0) {
                        record = shift1;
                    } else if (j == 1) {
                        record = shift2;
                    } else {
                        record = shift3;
                    }
                    int qt;
                    if (lineDeviceName.contains("ASSY")) {
                        qt = generalOEEDataService.getTargetQuantityAssy(DateString, record[0], record[1], "", lineDeviceName).getQuantity().intValue();
                    } else {
                        qt = generalOEEDataService.getQuantitySum(DateString,record[0],record[1],"", lineDeviceName);
                    }
                    // loop for shift => record

                    Double a = generalOEEDataService.getOeeA(DateString, record[0], record[1], "", lineDeviceName);

                    Double p = 0.0;   // calculation difference between cnc and assy machine;


                    Double q = 0.0;

                    if (lineDeviceName.contains("ASSY")) {
                        p = generalOEEDataService.getOeePAssy(DateString, record[0], record[1], "", lineDeviceName);
                    } else {
                        p = generalOEEDataService.getOeeP(DateString, record[0], record[1], "", lineDeviceName);
                    }

                    if (lineDeviceName.contains("ASSY")) {
                        q = generalOEEDataService.getOeeQAssy(DateString, record[0], record[1], "", lineDeviceName);   //quality for ASSY machine

                    } else {
                        q = generalOEEDataService.getOeeQ(DateString, record[0], record[1], "", lineDeviceName);   //quality according  to

                    }

                    Double oee = new BigDecimal((Double) a * p * q * 100).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();

                    if (oee > 100.0) {
                        oee = 100.0;   //max value avoid sync delay
                    }

                    machineOverviewValue.setName(lineDeviceName1);
                    if (j == 0) {
                        machineOverviewValue.setShift1OEE(oee.toString());
                        machineOverviewValue.setShift1QT(qt);
                    }
                    if (j == 1) {
                        machineOverviewValue.setShift2OEE(oee.toString());
                        machineOverviewValue.setShift2QT(qt);

                    }
                    if (j == 2) {
                        machineOverviewValue.setShift3OEE(oee.toString());
                        machineOverviewValue.setShift3QT(qt);

                    }
                }
//                if (lineDeviceName.contains("ASSY")){
//                    List<Integer> cycleTimeList = generalPQDataService.cycleTimeAverageASSY(DateString,"",lineDeviceName);
//                    Integer AverageSum = 0; //sum of latest 6 value;
//                    for (int i = 0; i < 6; i++) {
//                        AverageSum += cycleTimeList.get(i);  //for the normal latest 6 cycle time sum , divided by  / 6
//                    }
//                    Integer resultAverage = AverageSum / 6;
//                    if (resultAverage!=null){
//                        machineOverviewValue.setCycleTime(resultAverage.toString());
//                    }
//                    else{
//                        machineOverviewValue.setCycleTime("0");
//                    }
//                }else{
//                    List<Integer> cycleTime =generalPQDataService.cycleTimeAverage(DateString,"",lineDeviceName);
//                    Integer AverageSum = 0; //sum of latest 6 value;
//                    for (int i = 0; i < 6; i++) {
//                        AverageSum += cycleTime.get(i);  //for the normal latest 6 cycle time sum , divided by  / 6
//                    }
//                    Integer resultAverage = AverageSum / 6;
//                    if (resultAverage!=null){
//                        machineOverviewValue.setCycleTime(resultAverage.toString());
//                    }
//                    else{
//                        machineOverviewValue.setCycleTime("0");
//                    }
                    /*List<Integer> cycleTimeList = generalPQDataService.cycleTimeAverage(DateString, "", lineDeviceName);
                    Integer AverageSum = 0; //sum of latest 6 value;
                    for (int i = 0; i < 6; i++) {
                        AverageSum += cycleTimeList.get(i);  //for the normal latest 6 cycle time sum , divided by  / 6
                    }
                    Integer resultAverage = AverageSum / 6;
                    machineOverviewValue.setCycleTime(resultAverage.toString());*/

                }

            /* else if (lineDeviceName.contains("EMP2ASSY")){
                for (int j = 0; j < 3; j++) {
                    if (j == 0) {
                        record = shift1;
                    } else if (j == 1) {
                        record = shift2;
                    } else {
                        record = shift3;
                    }
                    int qt = 0;
                    if (lineDeviceName.contains("ASSY")) {
                        qt = emp2ASSYOEEDataService.getTargetQuantityAssy(DateString, record[0], record[1], "", lineDeviceName).getQuantity().intValue();
                    }
                    // loop for shift => record
                    Double a = emp2ASSYOEEDataService.getOeeA(DateString, record[0], record[1], "", lineDeviceName);
                    Double p = 0.0;   // calculation difference between cnc and assy machine;
                    Double q = 0.0;

                    if (lineDeviceName.contains("ASSY")) {
                        p = emp2ASSYOEEDataService.getOeePAssy(DateString, record[0], record[1], "", lineDeviceName);
                    }
                    if (lineDeviceName.contains("ASSY")) {
                        q = emp2ASSYOEEDataService.getOeeQAssy(DateString, record[0], record[1], "", lineDeviceName);   //quality for ASSY machine
                    }
                    Double oee = new BigDecimal((Double) a * p * q * 100).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
                    if (oee > 100.0) {
                        oee = 100.0;   //max value avoid sync delay
                    }
                    machineOverviewValue.setName(lineDeviceName1);
                    if (j == 0) {
                        machineOverviewValue.setShift1OEE(oee.toString());
                        machineOverviewValue.setShift1QT(qt);
                    }
                    if (j == 1) {
                        machineOverviewValue.setShift2OEE(oee.toString());
                        machineOverviewValue.setShift2QT(qt);

                    }
                    if (j == 2) {
                        machineOverviewValue.setShift3OEE(oee.toString());
                        machineOverviewValue.setShift3QT(qt);

                    }
                }
                if (lineDeviceName.contains("ASSY")){
                    List<Integer> cycleTimeList = emp2ASSYPQDataService.cycleTimeAverageASSY(DateString,"",lineDeviceName);
                    Integer AverageSum = 0; //sum of latest 6 value;
                    for (int i = 0; i < 6; i++) {
                        AverageSum += cycleTimeList.get(i);  //for the normal latest 6 cycle time sum , divided by  / 6
                    }
                    Integer resultAverage = AverageSum / 6;
                    machineOverviewValue.setCycleTime(resultAverage.toString());

                }else{
                    machineOverviewValue.setCycleTime("0");
                }
            }*/
            else{
                machineOverviewValue.setName(lineDeviceName1);
            }
            outList.add(machineOverviewValue); // push data into the list
        }
        System.out.println(outList);

        result.setData(outList);
        result.setCode(200);
        result.setSuccess(true);
        result.setMessage("devices oee data ");
        return result;
    }
    @RequestMapping(value = "allDevicesOEE1",method = RequestMethod.GET)
    public ResponseResult getAllDeviceOee1(String DateString) throws Exception{
        ResponseResult result = new ResponseResult();
        List<MachineOverviewValue> outList = new ArrayList<>();
        String[] lines = AppConsts.monitoringLines1;

        Integer[]  record= null;
        Integer[] shift1= new Integer[]{1,32};
        Integer[] shift2= new Integer[]{33,64};
        Integer[] shift3= new Integer[]{65,96};


        List<String> lineDeviceNames = new ArrayList<>();
        List<LineDeviceOutput> lineDevices = new ArrayList<>();
        for(String lineName : lines){

            PageData pageData4line = new PageData();
            pageData4line.put("lineName",lineName);
            lineDevices = lineDeviceService.list(false,pageData4line);//get device name from line name
            if (lineDevices.size() == 0){
                lineDeviceNames.add(lineName);
            }
            for(LineDevice lineDevice : lineDevices){
                lineDeviceNames.add(lineName+" "+lineDevice.getName());   //push all device names into the String List
            }
        }


        //loop for  Oee data of each device from the list
        // device1  shift1 shift2 shift3
        //device2 shift1 shift2 shift3
        //...
        for(String lineDeviceName1 : lineDeviceNames ){
            String lineDeviceName = lineDeviceName1.replaceAll(" ", "");
            MachineOverviewValue machineOverviewValue = new MachineOverviewValue();
            if (lineDeviceName.contains("G38")) {
                for (int j = 0; j < 3; j++) {
                    if (j == 0) {
                        record = shift1;
                    } else if (j == 1) {
                        record = shift2;
                    } else {
                        record = shift3;
                    }
                    // loop for shift => record
                    int qt;
                    if (lineDeviceName.contains("ASSY")) {
                        qt = generalOEEDataService.getTargetQuantityAssy(DateString, record[0], record[1], "", lineDeviceName).getQuantity().intValue();
                    } else {
                        qt = generalOEEDataService.getQuantitySum(DateString,record[0],record[1],"", lineDeviceName);
                    }

                    Double a = generalOEEDataService.getOeeA(DateString, record[0], record[1], "", lineDeviceName);

                    Double p = 0.0;   // calculation difference between cnc and assy machine;


                    Double q = 0.0;

                    if (lineDeviceName.contains("ASSY")) {
                        p = generalOEEDataService.getOeePAssy(DateString, record[0], record[1], "", lineDeviceName);
                    } else {
                        p = generalOEEDataService.getOeeP(DateString, record[0], record[1], "", lineDeviceName);
                    }

                    if (lineDeviceName.contains("ASSY")) {
                        q = generalOEEDataService.getOeeQAssy(DateString, record[0], record[1], "", lineDeviceName);   //quality for ASSY machine

                    } else {
                        q = generalOEEDataService.getOeeQ(DateString, record[0], record[1], "", lineDeviceName);   //quality according  to

                    }

                    Double oee = new BigDecimal((Double) a * p * q * 100).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();

                    if (oee > 100.0) {
                        oee = 100.0;   //max value avoid sync delay
                    }

                    machineOverviewValue.setName(lineDeviceName1);
                    if (j == 0) {
                        machineOverviewValue.setShift1OEE(oee.toString());
                        machineOverviewValue.setShift1QT(qt);
                    }
                    if (j == 1) {
                        machineOverviewValue.setShift2OEE(oee.toString());
                        machineOverviewValue.setShift2QT(qt);
                    }
                    if (j == 2) {
                        machineOverviewValue.setShift3OEE(oee.toString());
                        machineOverviewValue.setShift3QT(qt);
                    }
                }
            }else{
                machineOverviewValue.setName(lineDeviceName1);
            }
            outList.add(machineOverviewValue); // push data into the list
        }

        result.setData(outList);
        result.setCode(200);
        result.setSuccess(true);
        result.setMessage("devices oee data ");
        return result;
    }

    /**
     * get all devices air detection by real time
     * @param input
     * @return
     */
    @RequestMapping(value = "allDeviceAirDetection",method = RequestMethod.POST)
    public ResponseResult getAllDeviceAirDetection(@RequestBody auth input){

        ResponseResult result = new ResponseResult();

        try {

            List<String>  orderAndSession = machDeviceWiseSessionService.getSessionIdAndUpdate(input); //get sessionId and logic inside is ready for updating
            String  orderId = orderAndSession.get(0);
            String  sessionId = orderAndSession.get(1);
            if(sessionId!=null||!sessionId.equals("")){

                String[] lines = AppConsts.monitoringLines;            //configuration about the monitoring lines
                List<String> deviceNames = new ArrayList<>();
                for(String lineName : lines){
                    PageData pageData4line = new PageData();
                    pageData4line.put("lineName",lineName);
                    List<LineDeviceOutput> lineDevices = lineDeviceService.list(false,pageData4line);  //get device name from line name
                    for(LineDevice lineDevice : lineDevices){
                        deviceNames.add(lineDevice.getName());   //push all device names into the String List
                    }
                }

                List<MachValue> machValues = new ArrayList<>();
                for(String deviceName : deviceNames){
                    if(deviceName.contains("ASSY")||deviceName.contains("Assy")){
                        continue;
                    }

                    MachValue machValue =  machineOverviewService.getAirDetection(orderId,sessionId,deviceName);
                    machValues.add(machValue);
                }

                result.setData(machValues);
                result.setMessage("Air detection monitoring for all devices.");
                result.setSuccess(true);
            }else {
                result.setSuccess(false);
                result.setMessage("SessionId error");
            }

            return result;

        }catch (Exception e){
            logger.error("Exception____Air detection for all:"+e);
            result.setMessage("error");
            result.setSuccess(false);
            return result;
        }

    }

    /**
     * get all devices running status by real time
     * @param input
     * @return
     */
    @RequestMapping(value = "allDeviceStatus",method = RequestMethod.POST)
    public ResponseResult getAllDeviceStatus(@RequestBody auth input){

        ResponseResult result = new ResponseResult();

        try {

            List<String>  orderAndSession = machDeviceWiseSessionService.getSessionIdAndUpdate(input); //get sessionId and logic inside is ready for updating
            String  orderId = orderAndSession.get(0);
            String  sessionId = orderAndSession.get(1);
            if(sessionId!=null||!sessionId.equals("")){

                String[] lines = AppConsts.monitoringLines;            //configuration about the monitoring lines
                List<String> deviceNames = new ArrayList<>();
                List<MachValue> machValues = new ArrayList<>();
                for(String lineName : lines){
                    PageData pageData4line = new PageData();
                    pageData4line.put("lineName",lineName);
                    List<LineDeviceOutput> lineDevices = lineDeviceService.list(false,pageData4line);  //get device name from line name
                    for(LineDevice lineDevice : lineDevices){
                        MachValue machValue = new MachValue();
                        String deviceName = lineDevice.getName();
                        String path = lineDevice.getPath();

                        if (deviceName.contains("ASSY")||deviceName.contains("Assy")){
                            machValue =  machineOverviewService.getStatusAssy(orderId,sessionId,lineName,deviceName,path);  //push all device names into the String List
                        }else {
                            machValue =  machineOverviewService.getStatus(orderId,sessionId,lineName,deviceName);  //push all device names into the String List
                        }
                          machValues.add(machValue); // add it into out lists
                    }

                }

                result.setData(machValues);
                result.setMessage("Status monitoring for all devices.");
                result.setSuccess(true);
            }else {
                result.setSuccess(false);
                result.setMessage("SessionId error");
            }

            return result;

        }catch (Exception e){
            logger.error("Exception____Status for all:"+e);
            result.setMessage("error");
            result.setSuccess(false);
            return result;
        }

    }
}