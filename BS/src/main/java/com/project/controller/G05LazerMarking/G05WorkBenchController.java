package com.project.controller.G05LazerMarking;

import com.casting.domain.entity.DeviceWiseSession;
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
@RequestMapping(value = "G05WorkBench")
public class G05WorkBenchController {

    @Autowired
    private MachWorkBenchService machWorkBenchService;


    @Autowired
    private MachDeviceWiseSessionService machDeviceWiseSessionService;

    private final Logger logger = LoggerFactory.getLogger(G05WorkBenchController.class);


    /**
     * Telit
     *        Read
     * @param sessionId
     * @param input
     * @return
     */

    @RequestMapping(value = "G05DeviceData",method = RequestMethod.POST)
    public ResponseResult getG05DeviceData(String sessionId,@RequestBody auth input){

        ResponseResult result = new ResponseResult();
        try {

            //orderAndSession -- orderId, sessionId
            List<String>  orderAndSession = machDeviceWiseSessionService.getSessionIdAndUpdate(input); //get sessionId and logic inside is ready for updating

            String  orderId = orderAndSession.get(0);
            sessionId = orderAndSession.get(1);


            if(sessionId!=null&&!sessionId.equals("")){

                List<MachValue> valueList = new ArrayList<>();

                //prepare api domain  V21
                forapi G05Object = new forapi();
                params G05parameter = new params();
                G05parameter.setDevice("G05_Laser_G");
                G05parameter.setVariable("DeviceStatus");
                G05parameter.setType("1");
                G05parameter.setCount("7");
                G05parameter.setLength("-1");

                G05Object.setParams(G05parameter);
                G05Object.setCommand("variable.read");
                String TelitResult =   machWorkBenchService.getApiData(sessionId,G05Object);//GET data from api

                String res1 = TelitResult.replace("[","");
                String res2 = res1.replace("]","");
                String[] G05DataList = res2.split(",");     // parse data

                MachValue  machValueStatus = new MachValue();
                machValueStatus.setName("Status");
                machValueStatus.setValue(Integer.valueOf(G05DataList[0]));

                MachValue  machValueEmergency = new MachValue();
                machValueEmergency.setName("Emergency");
                machValueEmergency.setValue(Integer.valueOf(G05DataList[1]));

                MachValue  machValueLightCurtain = new MachValue();
                machValueLightCurtain.setName("LightCurtain");
                machValueLightCurtain.setValue(Integer.valueOf(G05DataList[2]));

                MachValue  machValueBarCodeReadingStatus = new MachValue();
                machValueBarCodeReadingStatus.setName("BarCodeReadingStatus");
                machValueBarCodeReadingStatus.setValue(Integer.valueOf(G05DataList[3]));


                MachValue  machValueUniqueness = new MachValue();
                machValueUniqueness.setName("Uniqueness");
                machValueUniqueness.setValue(Integer.valueOf(G05DataList[4]));


                MachValue  machValueLabelPosition = new MachValue();
                machValueLabelPosition.setName("LabelPosition");
                machValueLabelPosition.setValue(Integer.valueOf(G05DataList[5]));

                MachValue  machValueNetwork = new MachValue();
                machValueNetwork.setName("Network");
                machValueNetwork.setValue(Integer.valueOf(G05DataList[6]));


                valueList.add(machValueStatus);
                valueList.add(machValueEmergency);
                valueList.add(machValueLightCurtain);
                valueList.add(machValueBarCodeReadingStatus);
                valueList.add(machValueUniqueness);
                valueList.add(machValueLabelPosition);
                valueList.add(machValueNetwork);





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
            result.setMessage("sessionId error");
            return result;

        }catch (Exception e){
            logger.error("Exception____G05DeviceData:"+e);
            result.setMessage("error");
            result.setSuccess(false);
            return result;
        }

    }

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
