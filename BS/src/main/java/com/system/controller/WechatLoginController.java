package com.system.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.authorize.AuthorizeJwt;
import com.core.dao.imp.DaoImp;
import com.domain.model.PageData;
import com.response.ResponseResult;
import com.system.domain.entity.SystemUsers;
import com.system.domain.model.LoginOutput;
import com.system.domain.model.input.SystemUsersInput;
import com.system.domain.model.output.SystemUsersOutput;
import com.system.service.LoginLogsService;
import com.system.service.SystemUsersService;
import com.utils.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import  com.authorize.oauth2.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * preparation for transfer to wechat apps
 */


@RestController
public class WechatLoginController {
    private final Logger logger = LoggerFactory.getLogger(WechatLoginController.class);



    @Autowired
    private DaoImp daoImp;

    @Autowired
    private SystemUsersService systemUsersService;



    @Autowired
    private LoginLogsService loginLogsService;



    //account setup from wechat official website
    private  final String APPID = "";

    private final String SECRET = "";

    //mapper in system
    public static final String MAPPERNAME = "com.system.mapper.mybatis.UsersMapper.";


    //login to chassix_da
    @RequestMapping(value = "wechatlogin",method = RequestMethod.POST)
    public ResponseResult getmodel(String code,String state,HttpServletRequest request) {

        String ip = "";
        ip = WebUtils.getIP(request);
        ResponseResult result = new ResponseResult();
        if (code == null || code.equals("")) {
            result.setMessage("code为空");
            return result;
        }
        String CODE = code;
        String WebAccessToken = "";
        String nickName, sex, openid = "";
        String avatar="";
        String userId ="";
        String REDIRECT_URI = "http://iazdtg.natappfree.cc/wechat";
        String SCOPE = "snsapi_userinfo";
//        1.（code已经获取，第一步省略）
//        String getCodeUrl = UserInfoUtil.getCode(APPID, REDIRECT_URI, SCOPE);
//        logger.info("第一步:用户授权, get Code URL:{}", getCodeUrl);

        // 2.替换字符串，获得请求access token URL
        String tokenUrl = UserInfoUtil.getWebAccess(APPID, SECRET, CODE);
        logger.info("第二步:get Access Token URL:{}", tokenUrl);
        // 通过https方式请求获得web_access_token
        String response = HttpsUtil.httpsRequestToString(tokenUrl, "GET", null);
        JSONObject jsonObject = JSON.parseObject(response);
        logger.info("请求到的Access Token:{}", jsonObject.toJSONString());



        if (null != jsonObject) {
            try {
                WebAccessToken = jsonObject.getString("access_token");
                openid = jsonObject.getString("openid");
                logger.info("获取access_token成功!");
                logger.info("WebAccessToken:{} , openId:{}", WebAccessToken, openid);

                // 3. 使用获取到的 Access_token 以及Code 获取信息 userInfo
                String userMessageUrl = UserInfoUtil.getUserMessage(WebAccessToken, openid);
                logger.info("第三步:获取用户信息的URL:{}", userMessageUrl);
                // 通过https方式请求获得用户信息响应
                String userMessageResponse = HttpsUtil.httpsRequestToString(userMessageUrl, "GET", null);
                JSONObject userMessageJsonObject = JSON.parseObject(userMessageResponse);
                logger.info("用户信息:{}", userMessageJsonObject.toJSONString());
                //userid 存在userMessageJsonObject中
                result.setData(userMessageJsonObject.toJSONString());
                 avatar = userMessageJsonObject.getString("headimgurl");
                nickName = userMessageJsonObject.getString("nickname");

                //4.记录用户、信息
               userId = this.addByOpenid(openid,avatar,nickName);

            } catch (JSONException e) {
                result.setSuccess(false);
                result.setMessage("JSONException错误");
                logger.error("获取Web Access Token失败／获取userInfo失败");
            } catch (Exception e){
                result.setSuccess(false);
                result.setMessage("Exception内部错误");
                logger.error("异常————" +e);
            }

        }else {
            result.setSuccess(false);
            result.setMessage("获取Web Access Token为空");
            return result;
        }
        try{
            AuthorizeJwt jwt = new AuthorizeJwt();
            String subject = AuthorizeJwt.generalSubject(userId);
            String token = jwt.createJWT(jwt.JWT_ID, subject, jwt.JWT_TTL);
            String refreshToken = jwt.createJWT(jwt.JWT_ID, subject, jwt.JWT_REFRESH_TTL);
            JSONObject jo = new JSONObject();
            jo.put("token", token);
            jo.put("refreshToken", refreshToken);

            LoginOutput output = new LoginOutput();
            output.setUserid(userId);
            output.setAuthorization(token);
            output.setOpenid(openid);

            StringBuffer userinfo = new StringBuffer("");
            output.setUserinfo(userinfo.toString());
            output.setCookieName("_sid_oc_");
            output.setCookieValue(token);
            output.setCookieExpires(1);

            result.setSuccess(true);
            result.setData(output);

        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage("身份认证过程中发生异常");
            return result;
    }
        result.setMessage("登陆成功");
        return result;
    }

    /**
     * 通过OpenId的新增
     * @param openid
     * @param avatar
     * @param nickName
     * @return guid -userid
     */
    public  String addByOpenid(String openid,String avatar,String nickName){
        try{
            //往用户表插入用户/验证是否存在
            SystemUsersOutput systemUsersOutput   =   systemUsersService.getbyopenid(openid);
            if(systemUsersOutput==null){
                SystemUsersInput input = new SystemUsersInput();
                input.setOpenid(openid);
                input.setAvatar(avatar);
                input.setNickName(nickName);
             String userId =   systemUsersService.addoutstring(input);
             if(userId!=null){
                 return userId;
             }
            }else{
                return null;
            }


        }catch (Exception e){
            this.logger.info(e+"addByOpenid错误");
        }

        return null;
    }


}
