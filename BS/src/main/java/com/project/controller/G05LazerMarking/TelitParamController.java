package com.project.controller.G05LazerMarking;


import com.casting.domain.entity.DeviceWiseSession;
import com.casting.service.CPCWorkBenchService;
import com.casting.service.CastingDeviceWiseSessionService;
import com.project.domain.entity.MachValue;
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

@RestController
@RequestMapping(value = "TelitWrite")
public class TelitParamController {





    @Autowired
    private MachWorkBenchService machWorkBenchService;

    @Autowired
    private MachDeviceWiseSessionService machDeviceWiseSessionService;

    private final Logger logger = LoggerFactory.getLogger(G05WorkBenchController.class);




    /**
     * Telit
     *        Write
     * @param
     * @param  input - auth {username,password}
     * @return
     */
    @RequestMapping(value = "DeviceDataModify",method = RequestMethod.POST)
    public ResponseResult ModifyG05DeviceData(@RequestBody auth input,String button){

        ResponseResult result = new ResponseResult();
        try {

            //orderAndSession -- orderId, sessionId
            List<String>  orderAndSession = machDeviceWiseSessionService.getSessionIdAndUpdate(input); //get sessionId and logic inside is ready for updating

            String  orderId = orderAndSession.get(0);
            String sessionId = orderAndSession.get(1);


            if(sessionId!=null&&!sessionId.equals("")){

                List<MachValue> valueList = new ArrayList<>();

                //prepare api domain  V21
                forapi G05Object = new forapi();
                params G05parameter = new params();
                G05parameter.setDevice("G05_Laser_G");


                if(button.equals("0")){
                    G05parameter.setVariable("ACK_Unicity");
                }else if(button.equals("1")){
                    G05parameter.setVariable("ACK_Readable");
                }

                G05parameter.setType("1");
                G05parameter.setCount("1");
                G05parameter.setLength("-1");
                G05parameter.setData("1");


                G05Object.setParams(G05parameter);
                G05Object.setCommand("variable.write");
                String TelitResult =   machWorkBenchService.getApiData(sessionId,G05Object);//request data from api


                //update the last activity refresh
                Date realTimeAfterRequest = new Date();
                DeviceWiseSession deviceWiseSession = new DeviceWiseSession();
                deviceWiseSession.setOrderid(orderId);
                deviceWiseSession.setSessionid(sessionId);
                deviceWiseSession.setLastActivityTime(realTimeAfterRequest);
                Boolean updateFlag = machDeviceWiseSessionService.update(deviceWiseSession); //call service.super.update

                result.setSuccess(true);
                result.setMessage(sessionId);
                result.setData(TelitResult);
                return result;



            }

            result.setSuccess(false);
            result.setMessage("sessionId error");
            return result;

        }catch (Exception e){
            logger.error("Exception____G05DeviceData:"+e);
            result.setMessage("error");
            result.setSuccess(false);
            return result;
        }

    }






}
