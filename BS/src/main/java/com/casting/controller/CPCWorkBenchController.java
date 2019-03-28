package com.casting.controller;



import com.casting.domain.entity.DeviceWiseSession;
import com.casting.service.CPCWorkBenchService;
import com.casting.domain.entity.CPCValue;
import com.casting.service.CastingDeviceWiseSessionService;
import com.domain.model.PageData;
import com.project.domain.workbench.auth;
import com.project.domain.workbench.forapi;
import com.project.domain.workbench.params;
import com.response.ResponseResult;
import com.utils.CommonConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * for CPC Real time data getting; from device wise  in Telit
 */
@RestController
@RequestMapping(value = "CPCWorkBench")
public class CPCWorkBenchController {

    @Autowired
    private CPCWorkBenchService cpcWorkBenchService;

    @Autowired
    private CastingDeviceWiseSessionService castingDeviceWiseSessionService;

    private final Logger logger = LoggerFactory.getLogger(CPCWorkBenchController.class);


    /**
     * for more series CPC
     * @param sessionId
     * @param input
     * @param device
     * @return
     */
    @RequestMapping(value = "CPCDeviceDataWithCycle",method = RequestMethod.POST)
    public ResponseResult getCPCDeviceDataWithCycle(String sessionId,@RequestBody auth input,String device){

        //for different CPCs ;
        ResponseResult result = new ResponseResult();
        try {
          //orderAndSession -- orderId, sessionId
           List<String>  orderAndSession = castingDeviceWiseSessionService.getSessionIdAndUpdate(input); //get sessionId and logic inside is ready for updating

            String  orderId = orderAndSession.get(0);
            sessionId = orderAndSession.get(1);

            // sessionId already
            if(sessionId!=null&&!sessionId.equals("")){
                List<CPCValue> valueList = new ArrayList<>();
                //prepare api domain  CPC
                forapi CPCobj = new forapi();
                params CPCparameter = new params();

                String DeviceName ="Casting_CPC";
                DeviceName+="_";
                DeviceName+=device;
                DeviceName+="_G";                     //FULL CPC NAME IN TELIT IS Casting_CPC_DeviceName_G
                if(device!=null&&!device.equals("")){
                    CPCparameter.setDevice(DeviceName);
                }else {
                    result.setMessage("Null device name.");
                    result.setSuccess(false);
                    return result;
                }
                CPCparameter.setVariable("DataToWeb");
                CPCparameter.setType("3");
                CPCparameter.setCount("4");
                CPCparameter.setLength("-1");
                CPCobj.setParams(CPCparameter);
                CPCobj.setCommand("variable.read");
                String SZCPCMCycle =   cpcWorkBenchService.getApiData(sessionId,CPCobj);//GET data from api

                String res1CPC = SZCPCMCycle.replace("[","");
                String res2CPC = res1CPC.replace("]","");
                String[] dataList = res2CPC.split(",");     // parse data

                CPCValue CPCState = new CPCValue();
                CPCState.setName("CPCState");
                CPCState.setValue(Integer.valueOf(dataList[0]).toString());

                CPCValue CPCCycleTime = new CPCValue();
                CPCCycleTime.setName("CycleTime");
                CPCCycleTime.setValue(Integer.valueOf(dataList[1]).toString());


                CPCValue CPCStandBy = new CPCValue();
                CPCStandBy.setName("CPCStandBy");
                CPCStandBy.setValue(Integer.valueOf(dataList[2]).toString());

                CPCValue CPCPosition = new CPCValue();
                CPCPosition.setName("CPCPosition");
                CPCPosition.setValue(Integer.valueOf(dataList[3]).toString());            //0 close 1 open 3 moving

                valueList.add(CPCState);
                valueList.add(CPCCycleTime);
                valueList.add(CPCStandBy);
                valueList.add(CPCPosition);

                //update the last activity refresh
                Date realTimeAfterRequest = new Date();
                DeviceWiseSession deviceWiseSession = new DeviceWiseSession();
                deviceWiseSession.setOrderid(orderId);
                deviceWiseSession.setSessionid(sessionId);
                deviceWiseSession.setLastActivityTime(realTimeAfterRequest);
                Boolean updateFlag = castingDeviceWiseSessionService.update(deviceWiseSession); //call service.super.update


                result.setSuccess(true);
                result.setMessage(sessionId);
                result.setData(valueList);
                return result;

            }
            result.setSuccess(false);
            result.setMessage("SESSION ID ERROR/ LOGIC INSIDE ERROR");
            return result;

        }catch (Exception e){
            logger.error("Exception____CPCDeviceData:"+e);
            result.setMessage("error");
            result.setSuccess(false);
            return result;
        }

    }




}
