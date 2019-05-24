package com.project.controller;

import com.core.controller.GenericController;
import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.model.AppConsts;
import com.project.domain.entity.*;
import com.project.domain.model.input.GeneralOEEDataInput;
import com.project.domain.model.output.GeneralOEEDataOutput;
import com.project.domain.model.output.LineDeviceOutput;
import com.project.service.GeneralOEEDataService;
import com.project.service.LineDeviceService;
import com.response.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Override
    protected void OnActionExecuting() {
        generalOEEDataService.SetWorkContext(this.WorkContext);
    }


    protected AbstractService<GeneralOEEDataInput,GeneralOEEDataOutput> getService() {
        return generalOEEDataService;
    }


    /**
     * get device oee by dateString and shift number
     * return
     * @param
     * @param
     * @param
     * @return
     * @throws Exception
     */

    @RequestMapping(value = "allDevicesOEE",method = RequestMethod.GET)
    public ResponseResult getLineOee(String DateString) throws Exception{
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

                Double oee = a*p*q*100;

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








}



