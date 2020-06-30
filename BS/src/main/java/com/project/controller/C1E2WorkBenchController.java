package com.project.controller;

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

@RestController
@RequestMapping(value = "C1E2WorkBench")
public class C1E2WorkBenchController {
    @Autowired
    private MachWorkBenchService machWorkBenchService;

    @Autowired
    private MachDeviceWiseSessionService machDeviceWiseSessionService;

    private final Logger logger = LoggerFactory.getLogger(com.project.controller.C1E2WorkBenchController.class);


    @RequestMapping(value = "C1E2DeviceData", method = RequestMethod.POST)
    public ResponseResult getC1xxDeviceData(String sessionId, @RequestBody auth input) {

        ResponseResult result = new ResponseResult();
        try {
            //orderAndSession -- orderId, sessionId   ;
            //orderId = sessionId its pkId
            List<String> orderAndSession = machDeviceWiseSessionService.getSessionIdAndUpdate(input); //get sessionId and logic inside is ready for updating
            String orderId = orderAndSession.get(0);
            sessionId = orderAndSession.get(1);

            if (sessionId != null && !sessionId.equals("")) {

                List<LineValue> valueList = new ArrayList<>();
                //prepare api domain  V16
                forapi V16obj = new forapi();
                params V16parameter = new params();
                V16parameter.setDevice("Machining_V16_G");
                V16parameter.setVariable("DataToDataBaseRunningStatus.Status");
                V16parameter.setType("2");
                V16parameter.setCount("1");
                V16parameter.setLength("1");

                V16obj.setParams(V16parameter);
                V16obj.setCommand("variable.read");
                String SZV16MCycle = machWorkBenchService.getApiData(sessionId, V16obj);
                LineValue V16 = new LineValue();
                V16.setName("V16");
                if (SZV16MCycle == null || SZV16MCycle.equals("[1]")) {
                    V16.setValue(1);
                } else {

                    String res1v16 = SZV16MCycle.replace("[", "");
                    String res2v16 = res1v16.replace("]", "");
                    V16.setValue(Integer.valueOf(res2v16).intValue());

                }
                valueList.add(V16);
                //prepare api domain V28
                forapi V28obj = new forapi();
                params V28parameter = new params();
                V28parameter.setDevice("Machining_V28_G");
                V28parameter.setVariable("DataToDataBaseRunningStatus.Status");
                V28parameter.setType("2");
                V28parameter.setCount("1");
                V28parameter.setLength("1");

                V28obj.setParams(V28parameter);
                V28obj.setCommand("variable.read");
                String SZV28MCycle = machWorkBenchService.getApiData(sessionId, V28obj);
                LineValue V28 = new LineValue();
                V28.setName("V28");
                if (SZV28MCycle == null || SZV28MCycle.equals("[1]")) {
                    V28.setValue(1);
                } else {


                    String res1V28 = SZV28MCycle.replace("[", "");
                    String res2V28 = res1V28.replace("]", "");
                    V28.setValue(Integer.valueOf(res2V28).intValue());


                }
                valueList.add(V28);


                //prepare api domain V27
                forapi V27obj = new forapi();
                params V27parameter = new params();
                V27parameter.setDevice("Machining_V27_G");
                V27parameter.setVariable("DataToDataBaseRunningStatus.Status");
                V27parameter.setType("2");
                V27parameter.setCount("1");
                V27parameter.setLength("1");

                V27obj.setParams(V27parameter);
                V27obj.setCommand("variable.read");
                String SZV27MCycle = machWorkBenchService.getApiData(sessionId, V27obj);
                LineValue V27 = new LineValue();
                V27.setName("V27");
                if (SZV27MCycle == null || SZV27MCycle.equals("[1]")) {
                    V27.setValue(1);
                } else {

                    String res1V27 = SZV27MCycle.replace("[", "");
                    String res2V27 = res1V27.replace("]", "");
                    V27.setValue(Integer.valueOf(res2V27).intValue());


                }
                valueList.add(V27);
                
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
        } catch (Exception e) {
            logger.error("Exception____C1xxDeviceData:" + e);
            result.setMessage("error");
            result.setSuccess(false);
            return result;
        }
    }


    @RequestMapping(value = "C1E2DeviceDataWithCycle", method = RequestMethod.POST)
    public ResponseResult getC1xxDeviceDataWithCycle(String sessionId, @RequestBody auth input) {

        ResponseResult result = new ResponseResult();
        try {
            //orderAndSession -- orderId, sessionId   ;
            //orderId = sessionId its pkId
            List<String> orderAndSession = machDeviceWiseSessionService.getSessionIdAndUpdate(input); //get sessionId and logic inside is ready for updating
            String orderId = orderAndSession.get(0);
            sessionId = orderAndSession.get(1);
            if (sessionId != null && !sessionId.equals("")) {
                List<LineValue> valueList = new ArrayList<>();
                //prepare api domain V16
                forapi V16obj = new forapi();
                params V16parameter = new params();
                V16parameter.setDevice("Machining_V16_G");
                V16parameter.setVariable("responseToWeb");
                V16parameter.setType("3");
                V16parameter.setCount("3");
                V16parameter.setLength("-1");
                V16obj.setParams(V16parameter);
                V16obj.setCommand("variable.read");
                String SZV16MCycle = machWorkBenchService.getApiData(sessionId, V16obj);//GET data from api
                String res1V16 = SZV16MCycle.replace("[", "");
                String res2V16 = res1V16.replace("]", "");
                String[] datalist16 = res2V16.split(",");     // parse data

                LineValue V16State = new LineValue();
                V16State.setName("V16State");
                V16State.setValue(Integer.valueOf(datalist16[0]));

                LineValue V16CycleTime = new LineValue();
                V16CycleTime.setName("CycleTime");
                V16CycleTime.setValue(Integer.valueOf(datalist16[1]));

                LineValue V16StandBy = new LineValue();
                V16StandBy.setName("V16StandBy");
                V16StandBy.setValue(Integer.valueOf(datalist16[2]));

                valueList.add(V16State);
                valueList.add(V16CycleTime);
                valueList.add(V16StandBy);

                //prepare api domain  V28
                forapi V28obj = new forapi();
                params V28parameter = new params();
                V28parameter.setDevice("Machining_V28_G");
                V28parameter.setVariable("responseToWeb");
                V28parameter.setType("3");
                V28parameter.setCount("3");
                V28parameter.setLength("-1");

                V28obj.setParams(V28parameter);
                V28obj.setCommand("variable.read");
                String SZV28MCycle = machWorkBenchService.getApiData(sessionId, V28obj);//GET data from api

                String res1V28 = SZV28MCycle.replace("[", "");
                String res2V28 = res1V28.replace("]", "");
                String[] datalist28 = res2V28.split(",");     // parse data

                LineValue V28State = new LineValue();
                V28State.setName("V28State");
                V28State.setValue(Integer.valueOf(datalist28[0]));

                LineValue V28CycleTime = new LineValue();
                V28CycleTime.setName("CycleTime");
                V28CycleTime.setValue(Integer.valueOf(datalist28[1]));

                LineValue V28StandBy = new LineValue();
                V28StandBy.setName("V28StandBy");
                V28StandBy.setValue(Integer.valueOf(datalist28[2]));

                valueList.add(V28State);
                valueList.add(V28CycleTime);
                valueList.add(V28StandBy);


                //prepare api domain  V27
                forapi V27obj = new forapi();
                params V27parameter = new params();
                V27parameter.setDevice("Machining_V27_G");
                V27parameter.setVariable("responseToWeb");
                V27parameter.setType("3");
                V27parameter.setCount("3");
                V27parameter.setLength("-1");

                V27obj.setParams(V27parameter);
                V27obj.setCommand("variable.read");
                String SZV27MCycle = machWorkBenchService.getApiData(sessionId, V27obj);//GET data from api

                String res1V27 = SZV27MCycle.replace("[", "");
                String res2V27 = res1V27.replace("]", "");
                String[] datalist27 = res2V27.split(",");     // parse data

                LineValue V27State = new LineValue();
                V27State.setName("V27State");
                V27State.setValue(Integer.valueOf(datalist27[0]));

                LineValue V27CycleTime = new LineValue();
                V27CycleTime.setName("CycleTime");
                V27CycleTime.setValue(Integer.valueOf(datalist27[1]));

                LineValue V27StandBy = new LineValue();
                V27StandBy.setName("V27StandBy");
                V27StandBy.setValue(Integer.valueOf(datalist27[2]));

                valueList.add(V27State);
                valueList.add(V27CycleTime);
                valueList.add(V27StandBy);
                
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

        } catch (Exception e) {
            logger.error("Exception____C1xxDeviceData:" + e);
            result.setMessage("error");
            result.setSuccess(false);
            return result;
        }

    }


    @RequestMapping(value = "C1E2DeviceDataAirDetection", method = RequestMethod.POST)
    public ResponseResult getC1xxDeviceDataAirDetection(String sessionId, @RequestBody auth input) {

        ResponseResult result = new ResponseResult();
        try {
            //orderAndSession -- orderId, sessionId   ;
            //orderId = sessionId its pkId
            List<String> orderAndSession = machDeviceWiseSessionService.getSessionIdAndUpdate(input); //get sessionId and logic inside is ready for updating

            String orderId = orderAndSession.get(0);
            sessionId = orderAndSession.get(1);


            if (sessionId != null && !sessionId.equals("")) {

                List<LineValue> valueList = new ArrayList<>();

                //prepare api domain  V16
                forapi V16obj = new forapi();
                params V16parameter = new params();
                V16parameter.setDevice("Machining_V16_G");
                V16parameter.setVariable("AirDetection");
                V16parameter.setType("11");
                V16parameter.setCount("1");
                V16parameter.setLength("-1");

                V16obj.setParams(V16parameter);
                V16obj.setCommand("variable.read");
                String V16AirDetectionResult = machWorkBenchService.getApiData(sessionId, V16obj);//GET data from api
                String res1V16 = V16AirDetectionResult.replace("[", "");
                String res2V16 = res1V16.replace("]", "");

                LineValue V16AirDetection = new LineValue();
                V16AirDetection.setName("V16AirDetection");
                V16AirDetection.setValue(Integer.valueOf(res2V16.trim()));

                valueList.add(V16AirDetection);

                //prepare api domain  V28
                forapi V28obj = new forapi();
                params V28parameter = new params();
                V28parameter.setDevice("Machining_V28_G");
                V28parameter.setVariable("AirDetection");
                V28parameter.setType("11");
                V28parameter.setCount("1");
                V28parameter.setLength("-1");

                V28obj.setParams(V28parameter);
                V28obj.setCommand("variable.read");
                String V28AirDetectionResult = machWorkBenchService.getApiData(sessionId, V28obj);//GET data from api


                String res1V28 = V28AirDetectionResult.replace("[", "");
                String res2V28 = res1V28.replace("]", "");

                LineValue V28AirDetection = new LineValue();
                V28AirDetection.setName("V28AirDetection");
                V28AirDetection.setValue(Integer.valueOf(res2V28.trim()));

                valueList.add(V28AirDetection);

                //prepare api domain  V27
                forapi V27obj = new forapi();
                params V27parameter = new params();
                V27parameter.setDevice("Machining_V27_G");
                V27parameter.setVariable("AirDetection");
                V27parameter.setType("11");
                V27parameter.setCount("1");
                V27parameter.setLength("-1");

                V27obj.setParams(V27parameter);
                V27obj.setCommand("variable.read");
                String V27AirDetectionResult = machWorkBenchService.getApiData(sessionId, V27obj);//GET data from api

                String res1V27 = V27AirDetectionResult.replace("[", "");
                String res2V27 = res1V27.replace("]", "");

                LineValue V27AirDetection = new LineValue();
                V27AirDetection.setName("V27AirDetection");
                V27AirDetection.setValue(Integer.valueOf(res2V27.trim()));

                valueList.add(V27AirDetection);

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

        } catch (Exception e) {
            logger.error("Exception____LineDeviceData:" + e);
            result.setMessage("error");
            result.setSuccess(false);
            return result;
        }
    }
}
