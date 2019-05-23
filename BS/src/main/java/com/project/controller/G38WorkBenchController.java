package com.project.controller;

import com.casting.domain.entity.DeviceWiseSession;
import com.project.domain.entity.G38Value;
import com.project.domain.workbench.auth;
import com.project.domain.workbench.forapi;
import com.project.domain.workbench.params;

import com.project.service.MachDeviceWiseSessionService;
import com.project.service.MachWorkBenchService;
import com.response.ResponseResult;
import com.utils.CommonConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "G38WorkBench")
public class G38WorkBenchController  {

    @Autowired
    private MachWorkBenchService machWorkBenchService;

    @Autowired
    private MachDeviceWiseSessionService machDeviceWiseSessionService;

    private final Logger logger = LoggerFactory.getLogger(G38WorkBenchController.class);


    @RequestMapping(value = "G38DeviceData",method = RequestMethod.POST)
    public ResponseResult getG38DeviceData(String sessionId,@RequestBody auth input){

        ResponseResult result = new ResponseResult();
        try {


            //orderAndSession -- orderId, sessionId
            List<String>  orderAndSession = machDeviceWiseSessionService.getSessionIdAndUpdate(input); //get sessionId and logic inside is ready for updating

            String  orderId = orderAndSession.get(0);
            sessionId = orderAndSession.get(1);


            if(sessionId!=null&&!sessionId.equals("")){

        List<G38Value> valueList = new ArrayList<>();


                //prepare api domain  V21
                forapi V21obj = new forapi();
                params V21parameter = new params();
                V21parameter.setDevice("SZ_V21_G");
                V21parameter.setVariable("DataToDataBaseRunningStatus.Status");
                V21parameter.setType("2");
                V21parameter.setCount("1");
                V21parameter.setLength("1");

                V21obj.setParams(V21parameter);
                V21obj.setCommand("variable.read");
                String SZV21MCycle =   machWorkBenchService.getApiData(sessionId,V21obj);
                G38Value V21 = new G38Value();
                V21.setName("V21");
                if (SZV21MCycle==null||SZV21MCycle.equals("[1]")){
                    V21.setValue(1);
                }else {

                    String res1v21 = SZV21MCycle.replace("[","");
                    String res2v21 = res1v21.replace("]","");
                    V21.setValue( Integer.valueOf(res2v21).intValue());

                }
                valueList.add(V21);


                //prepare api domain V22
                forapi V22obj = new forapi();
                params V22parameter = new params();
                V22parameter.setDevice("SZ_V22_G");
                V22parameter.setVariable("DataToDataBaseRunningStatus.Status");
                V22parameter.setType("2");
                V22parameter.setCount("1");
                V22parameter.setLength("1");

                V22obj.setParams(V22parameter);
                V22obj.setCommand("variable.read");
                String SZV22MCycle =   machWorkBenchService.getApiData(sessionId,V22obj);
                G38Value V22 = new G38Value();
                V22.setName("V22");
                if (SZV22MCycle==null||SZV22MCycle.equals("[1]")){
                    V22.setValue(1);
                }else {


                    String res1v22 = SZV22MCycle.replace("[","");
                    String res2v22 = res1v22.replace("]","");
                    V22.setValue( Integer.valueOf(res2v22).intValue());


                }
                valueList.add(V22);



                //prepare api domain V23
        forapi V23obj = new forapi();
        params V23parameter = new params();
                V23parameter.setDevice("SZ_V23_G");
                V23parameter.setVariable("DataToDataBaseRunningStatus.Status");
                V23parameter.setType("2");
                V23parameter.setCount("1");
                V23parameter.setLength("1");

                V23obj.setParams(V23parameter);
                V23obj.setCommand("variable.read");
              String SZV23MCycle =   machWorkBenchService.getApiData(sessionId,V23obj);
                G38Value V23 = new G38Value();
                V23.setName("V23");
                if (SZV23MCycle==null||SZV23MCycle.equals("[1]")){
                    V23.setValue(1);
                }else {

                    String res1v23 = SZV23MCycle.replace("[","");
                    String res2v23 = res1v23.replace("]","");
                    V23.setValue( Integer.valueOf(res2v23).intValue());


                }
                valueList.add(V23);



                //prepare api domain Assy
                forapi Assyobj = new forapi();
                params Assyparameter = new params();
                Assyparameter.setDevice("SZ_ASSY09_G");
                Assyparameter.setVariable("Assy_09_Status");
                Assyparameter.setType("2");
                Assyparameter.setCount("1");
                Assyparameter.setLength("-1");

                Assyobj.setParams(Assyparameter);
                Assyobj.setCommand("variable.read");
                String Assystatus =   machWorkBenchService.getApiData(sessionId,Assyobj);
                G38Value Assy = new G38Value();
                Assy.setName("Assy");
                if (Assystatus==null||!Assystatus.equals("[1]")){
                    Assy.setValue(0);
                }else {
                    Assy.setValue(1);
                }
                valueList.add(Assy);



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
            logger.error("Exception____G38DeviceData:"+e);
            result.setMessage("error");
            result.setSuccess(false);
            return result;
        }

    }




    @RequestMapping(value = "G38DeviceDataWithCycle",method = RequestMethod.POST)
    public ResponseResult getG38DeviceDataWithCycle(String sessionId,@RequestBody auth input){

        ResponseResult result = new ResponseResult();
        try {

            //orderAndSession -- orderId, sessionId
            List<String>  orderAndSession = machDeviceWiseSessionService.getSessionIdAndUpdate(input); //get sessionId and logic inside is ready for updating

            String  orderId = orderAndSession.get(0);
            sessionId = orderAndSession.get(1);


            if(sessionId!=null&&!sessionId.equals("")){

                List<G38Value> valueList = new ArrayList<>();

                //prepare api domain  V21
                forapi V21obj = new forapi();
                params V21parameter = new params();
                V21parameter.setDevice("SZ_V21_G");
                V21parameter.setVariable("responseToWeb");
                V21parameter.setType("3");
                V21parameter.setCount("3");
                V21parameter.setLength("-1");

                V21obj.setParams(V21parameter);
                V21obj.setCommand("variable.read");
                String SZV21MCycle =   machWorkBenchService.getApiData(sessionId,V21obj);//GET data from api

                String res1v21 = SZV21MCycle.replace("[","");
                String res2v21 = res1v21.replace("]","");
                String[] datalist21 = res2v21.split(",");     // parse data

                G38Value V21State = new G38Value();
                V21State.setName("V21State");
                V21State.setValue(Integer.valueOf(datalist21[0]));

                G38Value V21CycleTime = new G38Value();
                V21CycleTime.setName("CycleTime");
                V21CycleTime.setValue(Integer.valueOf(datalist21[1]));


                G38Value V21StandBy = new G38Value();
                V21StandBy.setName("V21StandBy");
                V21StandBy.setValue(Integer.valueOf(datalist21[2]));


                valueList.add(V21State);
                valueList.add(V21CycleTime);
                valueList.add(V21StandBy);



                //prepare api domain  V22
                forapi V22obj = new forapi();
                params V22parameter = new params();
                V22parameter.setDevice("SZ_V22_G");
                V22parameter.setVariable("responseToWeb");
                V22parameter.setType("3");
                V22parameter.setCount("3");
                V22parameter.setLength("-1");

                V22obj.setParams(V22parameter);
                V22obj.setCommand("variable.read");
                String SZV22MCycle =   machWorkBenchService.getApiData(sessionId,V22obj);//GET data from api

                String res1V22 = SZV22MCycle.replace("[","");
                String res2V22 = res1V22.replace("]","");
                String[] datalist22 = res2V22.split(",");     // parse data

                G38Value V22State = new G38Value();
                V22State.setName("V22State");
                V22State.setValue(Integer.valueOf(datalist22[0]));

                G38Value V22CycleTime = new G38Value();
                V22CycleTime.setName("CycleTime");
                V22CycleTime.setValue(Integer.valueOf(datalist22[1]));


                G38Value V22StandBy = new G38Value();
                V22StandBy.setName("V22StandBy");
                V22StandBy.setValue(Integer.valueOf(datalist22[2]));


                valueList.add(V22State);
                valueList.add(V22CycleTime);
                valueList.add(V22StandBy);


                //prepare api domain  V23
                forapi V23obj = new forapi();
                params V23parameter = new params();
                V23parameter.setDevice("SZ_V23_G");
                V23parameter.setVariable("responseToWeb");
                V23parameter.setType("3");
                V23parameter.setCount("3");
                V23parameter.setLength("-1");

                V23obj.setParams(V23parameter);
                V23obj.setCommand("variable.read");
                String SZV23MCycle =   machWorkBenchService.getApiData(sessionId,V23obj);//GET data from api

                String res1V23 = SZV23MCycle.replace("[","");
                String res2V23 = res1V23.replace("]","");
                String[] datalist23 = res2V23.split(",");     // parse data

                G38Value V23State = new G38Value();
                V23State.setName("V23State");
                V23State.setValue(Integer.valueOf(datalist23[0]));

                G38Value V23CycleTime = new G38Value();
                V23CycleTime.setName("CycleTime");
                V23CycleTime.setValue(Integer.valueOf(datalist23[1]));


                G38Value V23StandBy = new G38Value();
                V23StandBy.setName("V23StandBy");
                V23StandBy.setValue(Integer.valueOf(datalist23[2]));


                valueList.add(V23State);
                valueList.add(V23CycleTime);
                valueList.add(V23StandBy);




                //prepare api domain Assy
                forapi Assyobj = new forapi();
                params Assyparameter = new params();
                Assyparameter.setDevice("SZ_ASSY09_G");
                Assyparameter.setVariable("Assy_09_Status");
                Assyparameter.setType("2");
                Assyparameter.setCount("1");
                Assyparameter.setLength("-1");

                Assyobj.setParams(Assyparameter);
                Assyobj.setCommand("variable.read");
                String Assystatus =   machWorkBenchService.getApiData(sessionId,Assyobj);
                G38Value Assy = new G38Value();
                Assy.setName("Assy");
                if (Assystatus==null||!Assystatus.equals("[1]")){
                    Assy.setValue(0);
                }else {
                    Assy.setValue(1);
                }
                valueList.add(Assy);




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
            logger.error("Exception____G38DeviceData:"+e);
            result.setMessage("error");
            result.setSuccess(false);
            return result;
        }

    }



    @RequestMapping(value = "G38DeviceDataAirDetection",method = RequestMethod.POST)
    public ResponseResult getG38DeviceDataAirDetection(String sessionId,@RequestBody auth input){

        ResponseResult result = new ResponseResult();
        try {

            //orderAndSession -- orderId, sessionId
            List<String>  orderAndSession = machDeviceWiseSessionService.getSessionIdAndUpdate(input); //get sessionId and logic inside is ready for updating

            String  orderId = orderAndSession.get(0);
            sessionId = orderAndSession.get(1);


            if(sessionId!=null&&!sessionId.equals("")){
 
                List<G38Value> valueList = new ArrayList<>();

                //prepare api domain  V21
                forapi V21obj = new forapi();
                params V21parameter = new params();
                V21parameter.setDevice("SZ_V21_G");
                V21parameter.setVariable("AirDetection");
                V21parameter.setType("1");
                V21parameter.setCount("1");
                V21parameter.setLength("-1");

                V21obj.setParams(V21parameter);
                V21obj.setCommand("variable.read");
                String V21AirDetectionResult =   machWorkBenchService.getApiData(sessionId,V21obj);//GET data from api
              String res1V21 =   V21AirDetectionResult.replace("[","");
              String res2V21 =   res1V21.replace("]","");

                G38Value V21AirDetection = new G38Value();
                V21AirDetection.setName("V21AirDetection");
                V21AirDetection.setValue(Integer.valueOf(res2V21.trim()));

                valueList.add(V21AirDetection);




                //prepare api domain  V22
                forapi V22obj = new forapi();
                params V22parameter = new params();
                V22parameter.setDevice("SZ_V22_G");
                V22parameter.setVariable("AirDetection");
                V22parameter.setType("1");
                V22parameter.setCount("1");
                V22parameter.setLength("-1");

                V22obj.setParams(V22parameter);
                V22obj.setCommand("variable.read");
                String V22AirDetectionResult =   machWorkBenchService.getApiData(sessionId,V22obj);//GET data from api


                String res1V22 =   V22AirDetectionResult.replace("[","");
                String res2V22 =   res1V22.replace("]","");

                G38Value V22AirDetection = new G38Value();
                V22AirDetection.setName("V22AirDetection");
                V22AirDetection.setValue(Integer.valueOf(res2V22.trim()));

                valueList.add(V22AirDetection);



                //prepare api domain  V23
                forapi V23obj = new forapi();
                params V23parameter = new params();
                V23parameter.setDevice("SZ_V23_G");
                V23parameter.setVariable("AirDetection");
                V23parameter.setType("1");
                V23parameter.setCount("1");
                V23parameter.setLength("-1");

                V23obj.setParams(V23parameter);
                V23obj.setCommand("variable.read");
                String V23AirDetectionResult =   machWorkBenchService.getApiData(sessionId,V23obj);//GET data from api

                String res1V23 =   V23AirDetectionResult.replace("[","");
                String res2V23 =   res1V23.replace("]","");

                G38Value V23AirDetection = new G38Value();
                V23AirDetection.setName("V23AirDetection");
                V23AirDetection.setValue(Integer.valueOf(res2V23.trim()));

                valueList.add(V23AirDetection);





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
            logger.error("Exception____G38DeviceData:"+e);
            result.setMessage("error");
            result.setSuccess(false);
            return result;
        }

    }



}
