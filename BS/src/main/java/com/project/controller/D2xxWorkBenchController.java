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

    private final Logger logger = LoggerFactory.getLogger(com.project.controller.D2xxWorkBenchController.class);


    @RequestMapping(value = "D2xxDeviceData", method = RequestMethod.POST)
    public ResponseResult getD2xxDeviceData(String sessionId, @RequestBody auth input) {

        ResponseResult result = new ResponseResult();
        try {
            //orderAndSession -- orderId, sessionId   ;
            //orderId = sessionId its pkId
            List<String> orderAndSession = machDeviceWiseSessionService.getSessionIdAndUpdate(input); //get sessionId and logic inside is ready for updating
            String orderId = orderAndSession.get(0);
            sessionId = orderAndSession.get(1);

            if (sessionId != null && !sessionId.equals("")) {

                List<LineValue> valueList = new ArrayList<>();
                //prepare api domain  V18
                forapi V18obj = new forapi();
                params V18parameter = new params();
                V18parameter.setDevice("Machining_V18_G");
                V18parameter.setVariable("DataToDataBaseRunningStatus.Status");
                V18parameter.setType("2");
                V18parameter.setCount("1");
                V18parameter.setLength("1");

                V18obj.setParams(V18parameter);
                V18obj.setCommand("variable.read");
                String SZV18MCycle = machWorkBenchService.getApiData(sessionId, V18obj);
                LineValue V18 = new LineValue();
                V18.setName("V18");
                if (SZV18MCycle == null || SZV18MCycle.equals("[1]")) {
                    V18.setValue(1);
                } else {

                    String res1V18 = SZV18MCycle.replace("[", "");
                    String res2V18 = res1V18.replace("]", "");
                    V18.setValue(Integer.valueOf(res2V18).intValue());

                }
                valueList.add(V18);
                //prepare api domain V20
                forapi V20obj = new forapi();
                params V20parameter = new params();
                V20parameter.setDevice("Machining_V20_G");
                V20parameter.setVariable("DataToDataBaseRunningStatus.Status");
                V20parameter.setType("2");
                V20parameter.setCount("1");
                V20parameter.setLength("1");

                V20obj.setParams(V20parameter);
                V20obj.setCommand("variable.read");
                String SZV20MCycle = machWorkBenchService.getApiData(sessionId, V20obj);
                LineValue V20 = new LineValue();
                V20.setName("V20");
                if (SZV20MCycle == null || SZV20MCycle.equals("[1]")) {
                    V20.setValue(1);
                } else {


                    String res1V20 = SZV20MCycle.replace("[", "");
                    String res2V20 = res1V20.replace("]", "");
                    V20.setValue(Integer.valueOf(res2V20).intValue());


                }
                valueList.add(V20);


                //prepare api domain V15
                forapi V15obj = new forapi();
                params V15parameter = new params();
                V15parameter.setDevice("Machining_V15_G");
                V15parameter.setVariable("DataToDataBaseRunningStatus.Status");
                V15parameter.setType("2");
                V15parameter.setCount("1");
                V15parameter.setLength("1");

                V15obj.setParams(V15parameter);
                V15obj.setCommand("variable.read");
                String SZV15MCycle = machWorkBenchService.getApiData(sessionId, V15obj);
                LineValue V15 = new LineValue();
                V15.setName("V15");
                if (SZV15MCycle == null || SZV15MCycle.equals("[1]")) {
                    V15.setValue(1);
                } else {

                    String res1V15 = SZV15MCycle.replace("[", "");
                    String res2V15 = res1V15.replace("]", "");
                    V15.setValue(Integer.valueOf(res2V15).intValue());


                }
                valueList.add(V15);


                //prepare api domain V17
                forapi V17obj = new forapi();
                params V17parameter = new params();
                V17parameter.setDevice("Machining_V17_G");
                V17parameter.setVariable("DataToDataBaseRunningStatus.Status");
                V17parameter.setType("2");
                V17parameter.setCount("1");
                V17parameter.setLength("1");

                V17obj.setParams(V17parameter);
                V17obj.setCommand("variable.read");
                String SZV17MCycle = machWorkBenchService.getApiData(sessionId, V17obj);
                LineValue V17 = new LineValue();
                V17.setName("V17");
                if (SZV17MCycle == null || SZV17MCycle.equals("[1]")) {
                    V17.setValue(1);
                } else {

                    String res1V17 = SZV17MCycle.replace("[", "");
                    String res2V17 = res1V17.replace("]", "");
                    V17.setValue(Integer.valueOf(res2V17).intValue());


                }
                valueList.add(V17);
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
            logger.error("Exception____D2xxDeviceData:" + e);
            result.setMessage("error");
            result.setSuccess(false);
            return result;
        }
    }


    @RequestMapping(value = "D2xxDeviceDataWithCycle", method = RequestMethod.POST)
    public ResponseResult getD2xxDeviceDataWithCycle(String sessionId, @RequestBody auth input) {

        ResponseResult result = new ResponseResult();
        try {
            //orderAndSession -- orderId, sessionId   ;
            //orderId = sessionId its pkId
            List<String> orderAndSession = machDeviceWiseSessionService.getSessionIdAndUpdate(input); //get sessionId and logic inside is ready for updating
            String orderId = orderAndSession.get(0);
            sessionId = orderAndSession.get(1);
            if (sessionId != null && !sessionId.equals("")) {
                List<LineValue> valueList = new ArrayList<>();
                //prepare api domain V18
                forapi V18obj = new forapi();
                params V18parameter = new params();
                V18parameter.setDevice("Machining_V18_G");
                V18parameter.setVariable("responseToWeb");
                V18parameter.setType("3");
                V18parameter.setCount("3");
                V18parameter.setLength("-1");
                V18obj.setParams(V18parameter);
                V18obj.setCommand("variable.read");
                String SZV18MCycle = machWorkBenchService.getApiData(sessionId, V18obj);//GET data from api
                String res1V18 = SZV18MCycle.replace("[", "");
                String res2V18 = res1V18.replace("]", "");
                String[] datalist02 = res2V18.split(",");     // parse data

                LineValue V18State = new LineValue();
                V18State.setName("V18State");
                V18State.setValue(Integer.valueOf(datalist02[0]));

                LineValue V18CycleTime = new LineValue();
                V18CycleTime.setName("CycleTime");
                V18CycleTime.setValue(Integer.valueOf(datalist02[1]));

                LineValue V18StandBy = new LineValue();
                V18StandBy.setName("V18StandBy");
                V18StandBy.setValue(Integer.valueOf(datalist02[2]));

                valueList.add(V18State);
                valueList.add(V18CycleTime);
                valueList.add(V18StandBy);

                //prepare api domain  V20
                forapi V20obj = new forapi();
                params V20parameter = new params();
                V20parameter.setDevice("Machining_V20_G");
                V20parameter.setVariable("responseToWeb");
                V20parameter.setType("3");
                V20parameter.setCount("3");
                V20parameter.setLength("-1");

                V20obj.setParams(V20parameter);
                V20obj.setCommand("variable.read");
                String SZV20MCycle = machWorkBenchService.getApiData(sessionId, V20obj);//GET data from api

                String res1V20 = SZV20MCycle.replace("[", "");
                String res2V20 = res1V20.replace("]", "");
                String[] datalist03 = res2V20.split(",");     // parse data

                LineValue V20State = new LineValue();
                V20State.setName("V20State");
                V20State.setValue(Integer.valueOf(datalist03[0]));

                LineValue V20CycleTime = new LineValue();
                V20CycleTime.setName("CycleTime");
                V20CycleTime.setValue(Integer.valueOf(datalist03[1]));

                LineValue V20StandBy = new LineValue();
                V20StandBy.setName("V20StandBy");
                V20StandBy.setValue(Integer.valueOf(datalist03[2]));

                valueList.add(V20State);
                valueList.add(V20CycleTime);
                valueList.add(V20StandBy);


                //prepare api domain  V15
                forapi V15obj = new forapi();
                params V15parameter = new params();
                V15parameter.setDevice("Machining_V15_G");
                V15parameter.setVariable("responseToWeb");
                V15parameter.setType("3");
                V15parameter.setCount("3");
                V15parameter.setLength("-1");

                V15obj.setParams(V15parameter);
                V15obj.setCommand("variable.read");
                String SZV15MCycle = machWorkBenchService.getApiData(sessionId, V15obj);//GET data from api

                String res1V15 = SZV15MCycle.replace("[", "");
                String res2V15 = res1V15.replace("]", "");
                String[] datalist31 = res2V15.split(",");     // parse data

                LineValue V15State = new LineValue();
                V15State.setName("V15State");
                V15State.setValue(Integer.valueOf(datalist31[0]));

                LineValue V15CycleTime = new LineValue();
                V15CycleTime.setName("CycleTime");
                V15CycleTime.setValue(Integer.valueOf(datalist31[1]));

                LineValue V15StandBy = new LineValue();
                V15StandBy.setName("V15StandBy");
                V15StandBy.setValue(Integer.valueOf(datalist31[2]));

                valueList.add(V15State);
                valueList.add(V15CycleTime);
                valueList.add(V15StandBy);

                //prepare api domain  V17
                forapi V17obj = new forapi();
                params V17parameter = new params();
                V17parameter.setDevice("Machining_V17_G");
                V17parameter.setVariable("responseToWeb");
                V17parameter.setType("3");
                V17parameter.setCount("3");
                V17parameter.setLength("-1");

                V17obj.setParams(V17parameter);
                V17obj.setCommand("variable.read");
                String SZV17MCycle = machWorkBenchService.getApiData(sessionId, V17obj);//GET data from api

                String res1V17 = SZV17MCycle.replace("[", "");
                String res2V17 = res1V17.replace("]", "");
                String[] datalist32 = res2V17.split(",");     // parse data

                LineValue V17State = new LineValue();
                V17State.setName("V17State");
                V17State.setValue(Integer.valueOf(datalist32[0]));

                LineValue V17CycleTime = new LineValue();
                V17CycleTime.setName("CycleTime");
                V17CycleTime.setValue(Integer.valueOf(datalist32[1]));

                LineValue V17StandBy = new LineValue();
                V17StandBy.setName("V17StandBy");
                V17StandBy.setValue(Integer.valueOf(datalist32[2]));
                valueList.add(V17State);
                valueList.add(V17CycleTime);
                valueList.add(V17StandBy);
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
            logger.error("Exception____D2xxDeviceData:" + e);
            result.setMessage("error");
            result.setSuccess(false);
            return result;
        }

    }


    @RequestMapping(value = "D2xxDeviceDataAirDetection", method = RequestMethod.POST)
    public ResponseResult getD2xxDeviceDataAirDetection(String sessionId, @RequestBody auth input) {

        ResponseResult result = new ResponseResult();
        try {
            //orderAndSession -- orderId, sessionId   ;
            //orderId = sessionId its pkId
            List<String> orderAndSession = machDeviceWiseSessionService.getSessionIdAndUpdate(input); //get sessionId and logic inside is ready for updating

            String orderId = orderAndSession.get(0);
            sessionId = orderAndSession.get(1);


            if (sessionId != null && !sessionId.equals("")) {

                List<LineValue> valueList = new ArrayList<>();

                //prepare api domain  V18
                forapi V18obj = new forapi();
                params V18parameter = new params();
                V18parameter.setDevice("Machining_V18_G");
                V18parameter.setVariable("AirDetection");
                V18parameter.setType("11");
                V18parameter.setCount("1");
                V18parameter.setLength("-1");

                V18obj.setParams(V18parameter);
                V18obj.setCommand("variable.read");
                String V18AirDetectionResult = machWorkBenchService.getApiData(sessionId, V18obj);//GET data from api
                String res1V18 = V18AirDetectionResult.replace("[", "");
                String res2V18 = res1V18.replace("]", "");

                LineValue V18AirDetection = new LineValue();
                V18AirDetection.setName("V18AirDetection");
                V18AirDetection.setValue(Integer.valueOf(res2V18.trim()));

                valueList.add(V18AirDetection);

                //prepare api domain  V20
                forapi V20obj = new forapi();
                params V20parameter = new params();
                V20parameter.setDevice("Machining_V20_G");
                V20parameter.setVariable("AirDetection");
                V20parameter.setType("11");
                V20parameter.setCount("1");
                V20parameter.setLength("-1");

                V20obj.setParams(V20parameter);
                V20obj.setCommand("variable.read");
                String V20AirDetectionResult = machWorkBenchService.getApiData(sessionId, V20obj);//GET data from api


                String res1V20 = V20AirDetectionResult.replace("[", "");
                String res2V20 = res1V20.replace("]", "");

                LineValue V20AirDetection = new LineValue();
                V20AirDetection.setName("V20AirDetection");
                V20AirDetection.setValue(Integer.valueOf(res2V20.trim()));

                valueList.add(V20AirDetection);

                //prepare api domain  V15
                forapi V15obj = new forapi();
                params V15parameter = new params();
                V15parameter.setDevice("Machining_V15_G");
                V15parameter.setVariable("AirDetection");
                V15parameter.setType("11");
                V15parameter.setCount("1");
                V15parameter.setLength("-1");

                V15obj.setParams(V15parameter);
                V15obj.setCommand("variable.read");
                String V15AirDetectionResult = machWorkBenchService.getApiData(sessionId, V15obj);//GET data from api

                String res1V15 = V15AirDetectionResult.replace("[", "");
                String res2V15 = res1V15.replace("]", "");

                LineValue V15AirDetection = new LineValue();
                V15AirDetection.setName("V15AirDetection");
                V15AirDetection.setValue(Integer.valueOf(res2V15.trim()));

                valueList.add(V15AirDetection);

                //prepare api domain  V17
                forapi V17obj = new forapi();
                params V17parameter = new params();
                V17parameter.setDevice("Machining_V17_G");
                V17parameter.setVariable("AirDetection");
                V17parameter.setType("11");
                V17parameter.setCount("1");
                V17parameter.setLength("-1");

                V17obj.setParams(V17parameter);
                V17obj.setCommand("variable.read");
                String V17AirDetectionResult = machWorkBenchService.getApiData(sessionId, V17obj);//GET data from api

                String res1V17 = V17AirDetectionResult.replace("[", "");
                String res2V17 = res1V17.replace("]", "");

                LineValue V17AirDetection = new LineValue();
                V17AirDetection.setName("V17AirDetection");
                V17AirDetection.setValue(Integer.valueOf(res2V17.trim()));
                valueList.add(V17AirDetection);

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
