package com.project.service;

import com.casting.domain.entity.DeviceWiseSession;
import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.project.domain.workbench.auth;
import com.utils.MapperName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class MachDeviceWiseSessionService extends AbstractService <DeviceWiseSession,DeviceWiseSession> {



    private String mapperName = MapperName.Name.DeviceWiseSessionName;


    @Override
    public String getMapperName() {
        return mapperName;
    }




    @Override
    public String getGUID(){
        return UUID.randomUUID().toString();
    }


    @Override
    public boolean add(DeviceWiseSession input)throws  Exception{
        return super.add(input);
    }


    @Autowired
    private  MachWorkBenchService machWorkBenchService;


    /**
     * logic of oee data edit
     */
    @Override
    public boolean update(DeviceWiseSession input) throws Exception{

        return super.update(input);
    }






    /**
     *  session id list
     * @param isPager
     * @param pageData
     * @return
     * @throws Exception
     */
    @Override

    public List<DeviceWiseSession> list(boolean isPager, PageData pageData) throws Exception {

        StringBuilder sb = new StringBuilder();

        if(pageData.containsKey("state")){
            sb.append("AND state = "+pageData.getMap().get("state"));
        }

        sb.append(new PageData().where(pageData));
        if (isPager) {
            return super.pageList(pageData, mapperName + "list", sb.toString());
        }
        PageData sqlModel = new PageData();
        sqlModel.put("retrieveSql", sb.toString());
        return (List<DeviceWiseSession>) daoImp.findForListSql(getMapperName()+"list",sqlModel);
    }


    /**
     * public function for get sessionId and update activity time
     * @return
     */
    public List<String> getSessionIdAndUpdate(auth input) throws Exception{

        List<String> resultList = new ArrayList<>();

        String sessionId= "";
        String orderId = "";
        PageData pageData = new PageData();
        List<DeviceWiseSession> sessions = this.list(false,pageData);


        if(sessions.size()==0){
            //first login to get seesionId;
            String username = input.getUsername();
            String password = input.getPassword();
            orderId = this.getGUID(); //default orderID
            sessionId = machWorkBenchService.getApiLogin(username,password); //Telit return result , orderId results

            Date realTime = new Date();
            DeviceWiseSession deviceWiseSession = new DeviceWiseSession();


            deviceWiseSession.setOrderid(orderId);
            deviceWiseSession.setSessionid(sessionId);
            deviceWiseSession.setLastActivityTime(realTime);  //put first request time
            Boolean insertFlag = this.add(deviceWiseSession);

            resultList.add(orderId);
            resultList.add(sessionId);

        }else {

            DeviceWiseSession deviceWiseSessionFromList = sessions.get(0);
            Date requestTime = new Date();
            Date recordTime = deviceWiseSessionFromList.getLastActivityTime();

            Long delta = (requestTime.getTime()-recordTime.getTime())/(1000*60);    //ms --> 60000 ms per min
            Integer deltaInt = delta.intValue();

            if(deltaInt>=10){                                       // sessionId from Telit life cycle is over 10 mins
                String username = input.getUsername();
                String password = input.getPassword();

                sessionId = machWorkBenchService.getApiLogin(username,password);
                orderId = sessions.get(0).getOrderid();  // results

                //login, update storage
                Date loginTime = new Date();
                DeviceWiseSession loginDetail = new DeviceWiseSession();
                loginDetail.setOrderid(sessions.get(0).getOrderid());  //give pk id;
                loginDetail.setSessionid(sessionId);
                loginDetail.setLastActivityTime(loginTime);
                Boolean updateFlag = this.update(loginDetail); //call service.super.update



                resultList.add(orderId);
                resultList.add(sessionId);

            }else {
                orderId = sessions.get(0).getOrderid();
                sessionId = sessions.get(0).getSessionid(); //use sessionId , storage from db

                resultList.add(orderId);
                resultList.add(sessionId);

            }

        }


        return resultList;


    }









}
