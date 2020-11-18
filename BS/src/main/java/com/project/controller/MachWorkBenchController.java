package com.project.controller;


import com.casting.domain.entity.CPCValue;
import com.casting.domain.entity.DeviceWiseSession;
import com.project.domain.entity.LineValue;
import com.project.domain.workbench.auth;
import com.project.domain.workbench.forapi;
import com.project.domain.workbench.params;
import com.project.service.MachDeviceWiseSessionService;
import com.project.service.MachWorkBenchService;
import com.response.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * for Mach Real time data getting; from device wise  in Telit
 */
@RestController
@RequestMapping(value = "MachWorkBench")
public class MachWorkBenchController {

    @Autowired
    private MachWorkBenchService machWorkBenchService;

    @Autowired
    private MachDeviceWiseSessionService machDeviceWiseSessionService;

    private final Logger logger = LoggerFactory.getLogger(MachWorkBenchController.class);


    /**
     * for more series CPC
     * @param sessionId
     * @param input
     * @param device
     * @return
     */
    @RequestMapping(value = "MachDeviceDataWithCycle",method = RequestMethod.POST)
    public ResponseResult getCPCDeviceDataWithCycle(String sessionId, @RequestBody auth input, String device){

        //for different CPCs ;
        ResponseResult result = new ResponseResult();
        try {
            //orderAndSession -- orderId, sessionId
            List<String> orderAndSession = machDeviceWiseSessionService.getSessionIdAndUpdate(input); //get sessionId and logic inside is ready for updating

            String  orderId = orderAndSession.get(0);
            sessionId = orderAndSession.get(1);

            // sessionId already
            if(sessionId!=null&&!sessionId.equals("")){
                List<LineValue> valueList = new ArrayList<>();
                //prepare api domain  Machine
                forapi machObj = new forapi();
                params machParameter = new params();

                String DeviceName ="Machining";
                DeviceName+="_";
                DeviceName+=device;
                DeviceName+="_G";                     //FULL CPC NAME IN TELIT IS Casting_CPC_DeviceName_G
                if(device!=null&&!device.equals("")){
                    machParameter.setDevice(DeviceName);
                }else {
                    result.setMessage("Null device name.");
                    result.setSuccess(false);
                    return result;
                }
                machParameter.setVariable("responseToWeb");
                machParameter.setType("3");
                machParameter.setCount("1");
                machParameter.setLength("-1");
                machObj.setParams(machParameter);
                machObj.setCommand("variable.read");
                LineValue machState = new LineValue();
                String SZMachMCycle =   machWorkBenchService.getApiData(sessionId,machObj);//GET data from api
                if (SZMachMCycle != null) {
                    String res1Mach = SZMachMCycle.replace("[", "");
                    String res2Mach = res1Mach.replace("]", "");
                    String[] dataList = res2Mach.split(",");     // parse data


                    machState.setName("MachState");
                    machState.setValue(Integer.valueOf(dataList[0]));
                }else{
                    machState.setName("MachState");
                    machState.setValue(-1);
                }
                /*
                LineValue  machCycleTime = new LineValue ();
                machCycleTime.setName("CycleTime");
                machCycleTime.setValue(Integer.valueOf(dataList[1]));


                LineValue  machStandBy = new LineValue ();
                machStandBy.setName("MachStandBy");
                machStandBy.setValue(Integer.valueOf(dataList[2]));       */  //0 close 1 open 3 moving

                valueList.add(machState);
//                valueList.add(machCycleTime);
//                valueList.add(machStandBy);

                //update the last activity refresh
                Date realTimeAfterRequest = new Date();
                DeviceWiseSession deviceWiseSession = new DeviceWiseSession();
                deviceWiseSession.setOrderid(orderId);
                deviceWiseSession.setSessionid(sessionId);
                deviceWiseSession.setLastActivityTime(realTimeAfterRequest);
                Boolean updateFlag = machDeviceWiseSessionService.update(deviceWiseSession); //call service.super.update


                result.setSuccess(true);
                result.setMessage(sessionId);
                result.setData(valueList);
                return result;

            }
            result.setSuccess(false);
            result.setMessage("SESSION ID ERROR/ LOGIC INSIDE ERROR");
            return result;

        }catch (Exception e){
            logger.error("Exception____MachDeviceData:"+e);
            result.setMessage("error");
            result.setSuccess(false);
            return result;
        }

    }
}
