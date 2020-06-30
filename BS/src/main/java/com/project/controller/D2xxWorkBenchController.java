package com.project.controller;

import com.casting.domain.entity.DeviceWiseSession;
import com.project.domain.entity.G38Value;
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
@RequestMapping(value = "D2xxWorkBench")
public class D2xxWorkBenchController {


    @Autowired
    private MachWorkBenchService machWorkBenchService;

    @Autowired
    private MachDeviceWiseSessionService machDeviceWiseSessionService;

    private final Logger logger = LoggerFactory.getLogger(com.project.controller.C1xxWorkBenchController.class);


    @RequestMapping(value = "C1xxDeviceData", method = RequestMethod.POST)
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
                //prepare api domain  V02
                forapi V02obj = new forapi();
                params V02parameter = new params();
                V02parameter.setDevice("Machining_V02_G");
                V02parameter.setVariable("DataToDataBaseRunningStatus.Status");
                V02parameter.setType("2");
                V02parameter.setCount("1");
                V02parameter.setLength("1");

                V02obj.setParams(V02parameter);
                V02obj.setCommand("variable.read");
                String SZV02MCycle = machWorkBenchService.getApiData(sessionId, V02obj);
                LineValue V02 = new LineValue();
                V02.setName("V02");
                if (SZV02MCycle == null || SZV02MCycle.equals("[1]")) {
                    V02.setValue(1);
                } else {

                    String res1v02 = SZV02MCycle.replace("[", "");
                    String res2v02 = res1v02.replace("]", "");
                    V02.setValue(Integer.valueOf(res2v02).intValue());

                }
                valueList.add(V02);
                //prepare api domain V03
                forapi V03obj = new forapi();
                params V03parameter = new params();
                V03parameter.setDevice("Machining_V03_G");
                V03parameter.setVariable("DataToDataBaseRunningStatus.Status");
                V03parameter.setType("2");
                V03parameter.setCount("1");
                V03parameter.setLength("1");

                V03obj.setParams(V03parameter);
                V03obj.setCommand("variable.read");
                String SZV03MCycle = machWorkBenchService.getApiData(sessionId, V03obj);
                LineValue V03 = new LineValue();
                V03.setName("V03");
                if (SZV03MCycle == null || SZV03MCycle.equals("[1]")) {
                    V03.setValue(1);
                } else {


                    String res1V03 = SZV03MCycle.replace("[", "");
                    String res2V03 = res1V03.replace("]", "");
                    V03.setValue(Integer.valueOf(res2V03).intValue());


                }
                valueList.add(V03);


                //prepare api domain V31
                forapi V31obj = new forapi();
                params V31parameter = new params();
                V31parameter.setDevice("Machining_V31_G");
                V31parameter.setVariable("DataToDataBaseRunningStatus.Status");
                V31parameter.setType("2");
                V31parameter.setCount("1");
                V31parameter.setLength("1");

                V31obj.setParams(V31parameter);
                V31obj.setCommand("variable.read");
                String SZV31MCycle = machWorkBenchService.getApiData(sessionId, V31obj);
                LineValue V31 = new LineValue();
                V31.setName("V31");
                if (SZV31MCycle == null || SZV31MCycle.equals("[1]")) {
                    V31.setValue(1);
                } else {

                    String res1V31 = SZV31MCycle.replace("[", "");
                    String res2V31 = res1V31.replace("]", "");
                    V31.setValue(Integer.valueOf(res2V31).intValue());


                }
                valueList.add(V31);


                //prepare api domain V32
                forapi V32obj = new forapi();
                params V32parameter = new params();
                V32parameter.setDevice("Machining_V32_G");
                V32parameter.setVariable("DataToDataBaseRunningStatus.Status");
                V32parameter.setType("2");
                V32parameter.setCount("1");
                V32parameter.setLength("1");

                V32obj.setParams(V32parameter);
                V32obj.setCommand("variable.read");
                String SZV32MCycle = machWorkBenchService.getApiData(sessionId, V32obj);
                LineValue V32 = new LineValue();
                V32.setName("V32");
                if (SZV32MCycle == null || SZV32MCycle.equals("[1]")) {
                    V32.setValue(1);
                } else {

                    String res1V32 = SZV32MCycle.replace("[", "");
                    String res2V32 = res1V32.replace("]", "");
                    V32.setValue(Integer.valueOf(res2V32).intValue());


                }
                valueList.add(V32);
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


    @RequestMapping(value = "C1xxDeviceDataWithCycle", method = RequestMethod.POST)
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
                //prepare api domain V02
                forapi V02obj = new forapi();
                params V02parameter = new params();
                V02parameter.setDevice("Machining_V02_G");
                V02parameter.setVariable("responseToWeb");
                V02parameter.setType("3");
                V02parameter.setCount("3");
                V02parameter.setLength("-1");
                V02obj.setParams(V02parameter);
                V02obj.setCommand("variable.read");
                String SZV02MCycle = machWorkBenchService.getApiData(sessionId, V02obj);//GET data from api
                String res1V02 = SZV02MCycle.replace("[", "");
                String res2V02 = res1V02.replace("]", "");
                String[] datalist02 = res2V02.split(",");     // parse data

                LineValue V02State = new LineValue();
                V02State.setName("V02State");
                V02State.setValue(Integer.valueOf(datalist02[0]));

                LineValue V02CycleTime = new LineValue();
                V02CycleTime.setName("CycleTime");
                V02CycleTime.setValue(Integer.valueOf(datalist02[1]));

                LineValue V02StandBy = new LineValue();
                V02StandBy.setName("V02StandBy");
                V02StandBy.setValue(Integer.valueOf(datalist02[2]));

                valueList.add(V02State);
                valueList.add(V02CycleTime);
                valueList.add(V02StandBy);

                //prepare api domain  V03
                forapi V03obj = new forapi();
                params V03parameter = new params();
                V03parameter.setDevice("Machining_V03_G");
                V03parameter.setVariable("responseToWeb");
                V03parameter.setType("3");
                V03parameter.setCount("3");
                V03parameter.setLength("-1");

                V03obj.setParams(V03parameter);
                V03obj.setCommand("variable.read");
                String SZV03MCycle = machWorkBenchService.getApiData(sessionId, V03obj);//GET data from api

                String res1V03 = SZV03MCycle.replace("[", "");
                String res2V03 = res1V03.replace("]", "");
                String[] datalist03 = res2V03.split(",");     // parse data

                LineValue V03State = new LineValue();
                V03State.setName("V03State");
                V03State.setValue(Integer.valueOf(datalist03[0]));

                LineValue V03CycleTime = new LineValue();
                V03CycleTime.setName("CycleTime");
                V03CycleTime.setValue(Integer.valueOf(datalist03[1]));

                LineValue V03StandBy = new LineValue();
                V03StandBy.setName("V03StandBy");
                V03StandBy.setValue(Integer.valueOf(datalist03[2]));

                valueList.add(V03State);
                valueList.add(V03CycleTime);
                valueList.add(V03StandBy);


                //prepare api domain  V31
                forapi V31obj = new forapi();
                params V31parameter = new params();
                V31parameter.setDevice("Machining_V31_G");
                V31parameter.setVariable("responseToWeb");
                V31parameter.setType("3");
                V31parameter.setCount("3");
                V31parameter.setLength("-1");

                V31obj.setParams(V31parameter);
                V31obj.setCommand("variable.read");
                String SZV31MCycle = machWorkBenchService.getApiData(sessionId, V31obj);//GET data from api

                String res1V31 = SZV31MCycle.replace("[", "");
                String res2V31 = res1V31.replace("]", "");
                String[] datalist31 = res2V31.split(",");     // parse data

                LineValue V31State = new LineValue();
                V31State.setName("V31State");
                V31State.setValue(Integer.valueOf(datalist31[0]));

                LineValue V31CycleTime = new LineValue();
                V31CycleTime.setName("CycleTime");
                V31CycleTime.setValue(Integer.valueOf(datalist31[1]));

                LineValue V31StandBy = new LineValue();
                V31StandBy.setName("V31StandBy");
                V31StandBy.setValue(Integer.valueOf(datalist31[2]));

                valueList.add(V31State);
                valueList.add(V31CycleTime);
                valueList.add(V31StandBy);

                //prepare api domain  V32
                forapi V32obj = new forapi();
                params V32parameter = new params();
                V32parameter.setDevice("Machining_V32_G");
                V32parameter.setVariable("responseToWeb");
                V32parameter.setType("3");
                V32parameter.setCount("3");
                V32parameter.setLength("-1");

                V32obj.setParams(V32parameter);
                V32obj.setCommand("variable.read");
                String SZV32MCycle = machWorkBenchService.getApiData(sessionId, V32obj);//GET data from api

                String res1V32 = SZV32MCycle.replace("[", "");
                String res2V32 = res1V32.replace("]", "");
                String[] datalist32 = res2V32.split(",");     // parse data

                LineValue V32State = new LineValue();
                V32State.setName("V32State");
                V32State.setValue(Integer.valueOf(datalist32[0]));

                LineValue V32CycleTime = new LineValue();
                V32CycleTime.setName("CycleTime");
                V32CycleTime.setValue(Integer.valueOf(datalist32[1]));

                LineValue V32StandBy = new LineValue();
                V32StandBy.setName("V32StandBy");
                V32StandBy.setValue(Integer.valueOf(datalist32[2]));
                valueList.add(V32State);
                valueList.add(V32CycleTime);
                valueList.add(V32StandBy);
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


    @RequestMapping(value = "C1xxDeviceDataAirDetection", method = RequestMethod.POST)
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

                //prepare api domain  V02
                forapi V02obj = new forapi();
                params V02parameter = new params();
                V02parameter.setDevice("Machining_V02_G");
                V02parameter.setVariable("AirDetection");
                V02parameter.setType("11");
                V02parameter.setCount("1");
                V02parameter.setLength("-1");

                V02obj.setParams(V02parameter);
                V02obj.setCommand("variable.read");
                String V02AirDetectionResult = machWorkBenchService.getApiData(sessionId, V02obj);//GET data from api
                String res1V02 = V02AirDetectionResult.replace("[", "");
                String res2V02 = res1V02.replace("]", "");

                LineValue V02AirDetection = new LineValue();
                V02AirDetection.setName("V02AirDetection");
                V02AirDetection.setValue(Integer.valueOf(res2V02.trim()));

                valueList.add(V02AirDetection);

                //prepare api domain  V03
                forapi V03obj = new forapi();
                params V03parameter = new params();
                V03parameter.setDevice("Machining_V03_G");
                V03parameter.setVariable("AirDetection");
                V03parameter.setType("11");
                V03parameter.setCount("1");
                V03parameter.setLength("-1");

                V03obj.setParams(V03parameter);
                V03obj.setCommand("variable.read");
                String V03AirDetectionResult = machWorkBenchService.getApiData(sessionId, V03obj);//GET data from api


                String res1V03 = V03AirDetectionResult.replace("[", "");
                String res2V03 = res1V03.replace("]", "");

                LineValue V03AirDetection = new LineValue();
                V03AirDetection.setName("V03AirDetection");
                V03AirDetection.setValue(Integer.valueOf(res2V03.trim()));

                valueList.add(V03AirDetection);

                //prepare api domain  V31
                forapi V31obj = new forapi();
                params V31parameter = new params();
                V31parameter.setDevice("Machining_V31_G");
                V31parameter.setVariable("AirDetection");
                V31parameter.setType("11");
                V31parameter.setCount("1");
                V31parameter.setLength("-1");

                V31obj.setParams(V31parameter);
                V31obj.setCommand("variable.read");
                String V31AirDetectionResult = machWorkBenchService.getApiData(sessionId, V31obj);//GET data from api

                String res1V31 = V31AirDetectionResult.replace("[", "");
                String res2V31 = res1V31.replace("]", "");

                LineValue V31AirDetection = new LineValue();
                V31AirDetection.setName("V31AirDetection");
                V31AirDetection.setValue(Integer.valueOf(res2V31.trim()));

                valueList.add(V31AirDetection);

                //prepare api domain  V32
                forapi V32obj = new forapi();
                params V32parameter = new params();
                V32parameter.setDevice("Machining_V32_G");
                V32parameter.setVariable("AirDetection");
                V32parameter.setType("11");
                V32parameter.setCount("1");
                V32parameter.setLength("-1");

                V32obj.setParams(V32parameter);
                V32obj.setCommand("variable.read");
                String V32AirDetectionResult = machWorkBenchService.getApiData(sessionId, V32obj);//GET data from api

                String res1V32 = V32AirDetectionResult.replace("[", "");
                String res2V32 = res1V32.replace("]", "");

                LineValue V32AirDetection = new LineValue();
                V32AirDetection.setName("V32AirDetection");
                V32AirDetection.setValue(Integer.valueOf(res2V32.trim()));
                valueList.add(V32AirDetection);

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
