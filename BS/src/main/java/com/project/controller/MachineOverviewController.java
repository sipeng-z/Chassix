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
    private LineDeviceService lineDeviceService;


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
        for(String lineName : lines){

            PageData pageData4line = new PageData();
            pageData4line.put("lineName",lineName);
            List<LineDeviceOutput> lineDevices = lineDeviceService.list(false,pageData4line);  //get device name from line name

            for(LineDevice lineDevice : lineDevices){
                lineDeviceNames.add(lineName+lineDevice.getName());   //push all device names into the String List
            }
        }

        //loop for  Oee data of each device from the list
        // device1  shift1 shift2 shift3
        //device2 shift1 shift2 shift3
        //...
        for(String lineDeviceName : lineDeviceNames ){
            MachineOverviewValue machineOverviewValue = new MachineOverviewValue();
            for(int j=0;j<3;j++){

                if (j==0){
                    record = shift1;
                }else if (j==1){
                    record = shift2;
                }else {
                    record = shift3;
                }
                // loop for shift => record

                Double a =  generalOEEDataService.getOeeA(DateString,record[0],record[1],"",lineDeviceName);

                Double p = 0.0;   // calculation difference between cnc and assy machine;


                Double q = 0.0;

                if(lineDeviceName.contains("ASSY")){
                    p  =generalOEEDataService.getOeePAssy(DateString,record[0],record[1],"",lineDeviceName);
                }else {
                    p  =generalOEEDataService.getOeeP(DateString,record[0],record[1],"",lineDeviceName);
                }

                if(lineDeviceName.contains("ASSY")){
                    q = generalOEEDataService.getOeeQAssy(DateString,record[0],record[1],"",lineDeviceName);   //quality for ASSY machine

                }else {
                    q = generalOEEDataService.getOeeQ(DateString,record[0],record[1],"",lineDeviceName);   //quality according  to

                }

                Double oee =new BigDecimal((Double)  a*p*q*100).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();

                if(oee>100.0){
                    oee = 100.0;   //max value avoid sync delay
                }

                machineOverviewValue.setName(lineDeviceName);
                if(j==0){
                    machineOverviewValue.setShift1OEE(oee.toString());

                }
                if(j==1){
                    machineOverviewValue.setShift2OEE(oee.toString());

                }
                if(j==2){
                    machineOverviewValue.setShift3OEE(oee.toString());

                }

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



