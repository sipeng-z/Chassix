package com.project.service;


import com.casting.domain.entity.DeviceWiseSession;
import com.project.domain.entity.MachValue;
import com.project.domain.workbench.forapi;
import com.project.domain.workbench.params;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *  For independence Telit API calling
 */
@Service
public class MachineOverviewService  {


    @Autowired
    private MachWorkBenchService machWorkBenchService;

    @Autowired
    private MachDeviceWiseSessionService machDeviceWiseSessionService;


    /**
     * get air detection result from telit api
     * @param sessionId
     * @param deviceName
     * @return
     * @throws Exception
     */
    public MachValue getAirDetection(String orderId,String sessionId,String deviceName) throws Exception{
        MachValue machValue = new MachValue();

        forapi forApiObj = new forapi();
        params parameter = new params();
        String deviceNameG = "Machining_"+deviceName+"_G";
        parameter.setDevice(deviceNameG);
        parameter.setVariable("AirDetection");
        parameter.setType("1");
        parameter.setCount("1");
        parameter.setLength("-1");

        forApiObj.setParams(parameter);
        forApiObj.setCommand("variable.read");
        String AirDetectionResult =   machWorkBenchService.getApiData(sessionId,forApiObj);//GET data from api
        String res1 =   AirDetectionResult.replace("[","");
        String res2 =   res1.replace("]","");

        machValue.setName(deviceName);
        machValue.setValue(Integer.valueOf(res2.trim()));


        //update the last activity refresh
        Date realTimeAfterRequest = new Date();
        DeviceWiseSession deviceWiseSession = new DeviceWiseSession();
        deviceWiseSession.setOrderid(orderId);
        deviceWiseSession.setSessionid(sessionId);
        deviceWiseSession.setLastActivityTime(realTimeAfterRequest);
        Boolean updateFlag = machDeviceWiseSessionService.update(deviceWiseSession); //call service.super.update

        return machValue;
    }





    /**
     * get status result from telit api
     * @param sessionId
     * @param deviceName
     * @return
     * @throws Exception
     */
    public MachValue getStatus(String orderId,String sessionId,String lineName,String deviceName) throws Exception{
        MachValue machValue = new MachValue();

        forapi forApiObj = new forapi();
        params parameter = new params();
        String deviceNameG = "Machining_"+deviceName+"_G";

        parameter.setDevice(deviceNameG);
        parameter.setVariable("responseToWeb");
        parameter.setType("3");
        parameter.setCount("3");
        parameter.setLength("-1");

        forApiObj.setParams(parameter);
        forApiObj.setCommand("variable.read");
        String resultGroup = machWorkBenchService.getApiData(sessionId,forApiObj);//GET data from telit api

        String res1 = resultGroup.replace("[","");
        String res2 = res1.replace("]","");
        String[] originDataList = res2.split(",");     // parse data

        machValue.setName(lineName+deviceName);
        machValue.setValue(Integer.valueOf(originDataList[0]));


        //update the last activity refresh
        Date realTimeAfterRequest = new Date();
        DeviceWiseSession deviceWiseSession = new DeviceWiseSession();
        deviceWiseSession.setOrderid(orderId);
        deviceWiseSession.setSessionid(sessionId);
        deviceWiseSession.setLastActivityTime(realTimeAfterRequest);
        Boolean updateFlag = machDeviceWiseSessionService.update(deviceWiseSession); //call service.super.update

        return machValue;
    }



    /** No ASSY Number in ASSY name (storage in the path column)  ,cause need to use the line name to judge ASSY machines
     * get status result from telit api
     * @param sessionId
     * @param deviceName
     * @return
     * @throws Exception
     */
    public MachValue getStatusAssy(String orderId,String sessionId,String lineName,String deviceName,String path) throws Exception{
        MachValue machValue = new MachValue();

        forapi forApiObj = new forapi();
        params parameter = new params();
        String deviceNameG = "SZ_"+deviceName+path+"_G";
        String variable = "SZ_"+deviceName+"_"+path+"_Status";   // properties in telit

        parameter.setDevice(deviceNameG);
        parameter.setVariable(variable);
        parameter.setType("2");
        parameter.setCount("1");
        parameter.setLength("-1");

        forApiObj.setParams(parameter);
        forApiObj.setCommand("variable.read");
        String AssyStatus =   machWorkBenchService.getApiData(sessionId,forApiObj);//GET data from telit api

        machValue.setName(lineName+deviceName);
        if (AssyStatus==null||!AssyStatus.equals("[1]")){
            machValue.setValue(0);
        }else {
            machValue.setValue(1);
        }


        //update the last activity refresh
        Date realTimeAfterRequest = new Date();
        DeviceWiseSession deviceWiseSession = new DeviceWiseSession();
        deviceWiseSession.setOrderid(orderId);
        deviceWiseSession.setSessionid(sessionId);
        deviceWiseSession.setLastActivityTime(realTimeAfterRequest);
        Boolean updateFlag = machDeviceWiseSessionService.update(deviceWiseSession); //call service.super.update

        return machValue;
    }






}
