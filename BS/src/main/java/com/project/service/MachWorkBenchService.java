package com.project.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.model.AppConsts;
import com.project.domain.workbench.auth;
import com.project.domain.workbench.logindomain;
import org.springframework.stereotype.Service;
import com.project.domain.workbench.params;
import com.project.domain.workbench.forapi;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;




@Service
public class MachWorkBenchService {


    /**
     * get WORKBENCH jsapi login
     * @return
     */
    public String getApiLogin(String username,String password)throws Exception{

        String url = AppConsts.workBenchLoginUrl; //machining process
        auth a = new auth();
        a.setUsername(username);
        a.setPassword(password);
        String json = JSON.toJSONString(a);

        logindomain domain = new logindomain();

        domain.setAuth(a);

        String domainString = JSON.toJSONString(domain);
        String result = jsonPostobj(url,domainString,null);
        JSONObject jsonObject = null;
        jsonObject =JSON.parseObject(result);

        String sessionId  = jsonObject.getString("sessionId");
        if (sessionId==null){
            return null;
        }
        System.out.print("sessionId__________"+sessionId);
        return sessionId;

    }


    /**
     * 发送HttpPost请求
     *
     * @param strURL
     *            服务地址
     * @param params
     *
     * @return 成功:返回json字符串<br/>
     */
    public static String jsonPostobj(String strURL,String params,String sessionId) throws Exception {
        try {
            URL url = new URL(strURL);// open
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestMethod("POST"); //setting method
            connection.setRequestProperty("Accept", "application/json"); //
            connection.setRequestProperty("Content-Type", "application/json"); // Content-Type need to be json, in api. Should be used to be ResponseBody


            if (sessionId!=null&&!sessionId.equals("")){
                String Cookie = "";
                Cookie+="sessionId=";
                Cookie+=sessionId;
                connection.setRequestProperty("Cookie",Cookie ); // set cookie
            }
            connection.connect();
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8"); // utf-8
            out.append((params));
            out.flush();
            out.close();

            int code = connection.getResponseCode();
            InputStream is = null;
            if (code == 200) {
                is = connection.getInputStream();
            } else {
                is = connection.getErrorStream();
            }

            // 读取响应
            int length = (int) connection.getContentLength();// 获取长度
            if (length != -1) {
                byte[] data = new byte[length];
                byte[] temp = new byte[512];
                int readLen = 0;
                int destPos = 0;
                while ((readLen = is.read(temp)) > 0) {
                    System.arraycopy(temp, 0, data, destPos, readLen);
                    destPos += readLen;
                }
                String result = new String(data, "UTF-8"); // utf-8编码
                return result;
            }

        } catch (IOException e) {
            System.out.print("Exception occur when send http post request!"+ e);
        }
        return "error"; // 自定义错误信息
    }




    /**
     * get WORKBENCH jsapi  get data
     *
     */
    public String getApiData(String sessionId,forapi forjpi) throws Exception{


        String url = AppConsts.workBenchUrl;


        String info = JSON.toJSONString(forjpi);
        String result = jsonPostobj(url,info,sessionId);

        JSONObject jsonObject = null;
        jsonObject =JSON.parseObject(result);

        String resultparams  = jsonObject.getString("params");
        if (resultparams==null){
            return null;
        }else{
             String resultdata = JSON.parseObject(resultparams).getString("data");
            System.out.print("Device Data__________"+resultdata);
            return resultdata;
        }




    }






}
