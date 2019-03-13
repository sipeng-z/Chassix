package com.system.controller;

import com.alibaba.fastjson.JSONObject;
import com.authorize.AuthorizeJwt;
import com.core.controller.GenericController;
import com.core.dao.imp.DaoImp;
import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.response.ResponseResult;
import com.system.domain.entity.SystemUsers;
import com.system.domain.entity.Users;
import com.system.domain.model.LoginInfo;
import com.system.domain.model.LoginOutput;
import com.system.domain.model.input.LoginLogsInput;
import com.system.domain.model.input.SystemUsersInput;
import com.system.domain.model.output.AuthorizeActionOutput;
import com.system.domain.model.output.SystemUsersOutput;
import com.system.service.ActionsService;
import com.system.service.LoginLogsService;
import com.utils.Md5Util;
import com.utils.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class LoginController extends GenericController<SystemUsersInput, SystemUsersOutput> {
    private final Logger logger = LoggerFactory.getLogger(LoginController.class);
    private final static Boolean IGNORE_CASE = false;

    @Autowired
    private DaoImp daoImp;



    @Autowired
    private ActionsService actionsService;


    @Autowired
    private LoginLogsService loginLogsService;


    @Override
    protected void OnActionExecuting() {

}

    @Override
    protected AbstractService<SystemUsersInput, SystemUsersOutput> getService() {
        return null;
    }

    //mapper方法名
    public static final String MAPPERNAME = "com.system.mapper.mybatis.SystemUsersMapper.";


    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResponseResult login(@RequestBody LoginInfo loginInfo, HttpServletRequest request) {
        ResponseResult result = new ResponseResult();
        String ip = "";
        ip = WebUtils.getIP(request);
        /**
         * 判断传的参数是否正确
         */
        if (loginInfo == null) {
            result.setSuccess(false);
            result.setMessage("提交的数据为空");
            return result;
        }
        /**
         * 判断账号是否为空
         */
        if (loginInfo.getUseraccount() == null && "".equals(loginInfo.getUseraccount())) {
            result.setSuccess(false);
            result.setMessage("账号不能为空");
            return result;
        }
        /**
         * 判断密码是否为空
         */
        if (loginInfo.getUserpassword() == null && "".equals(loginInfo.getUserpassword())) {
            result.setSuccess(false);
            result.setMessage("密码不能为空");
            return result;
        }
        try {
            List<SystemUsers> usersList = null;
            if (IGNORE_CASE) {
                String username = loginInfo.getUseraccount().toUpperCase();
                loginInfo.setUseraccount(username);
                usersList = (List<SystemUsers>) daoImp.findForList(MAPPERNAME + "findByAccountIgnoreCase", loginInfo);
            } else {
                usersList = (List<SystemUsers>) daoImp.findForList(MAPPERNAME + "findByAccount", loginInfo);
            }
            if (usersList.size() <= 0) {
                result.setSuccess(false);
                result.setMessage("系统无此用户账号");
                return result;
            }

            if (usersList.size() > 1) {
                result.setSuccess(false);
                result.setMessage("系统中有多个相同的账号");
                return result;
            }


//            //开始审查账号
            SystemUsers users = usersList.get(0);

            String inputPassword = Md5Util.Encode(loginInfo.getUserpassword() + users.getSalt());
            if (!usersList.get(0).getPassword().equals(inputPassword)) {
                result.setSuccess(false);
                result.setMessage("密码不正确");
                return result;
            }


            String userId = users.getUserId();
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
            StringBuffer userinfo = new StringBuffer("");

            if (users != null) {

                if (users.getName() != null) {
                    userinfo.append(users.getName());
                }
                if (users.getAccount() != null) {
                    userinfo.append("(" +users.getAccount() + ")");
                }
                if (users.getLevel() != null && users.getLevel() == 9) {
                    userinfo.append(" (Administrator) ");
                } else {
                    userinfo.append(" (User) ");
                }
            }
            output.setUserinfo(userinfo.toString());
            output.setCookieName("_sid_oc_");
            output.setCookieValue(token);
            output.setCookieExpires(1);

            result.setSuccess(true);
            result.setData(output);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("身份认证过程中发生异常");
            return result;
        }
        LoginLogsInput loginlogs = new LoginLogsInput();
        loginlogs.setClientIp(ip);
        loginlogs.setDescription("登陆成功");
        if(loginInfo!=null){
            loginlogs.setAccount(loginInfo.getUseraccount());
        }else{
            loginlogs.setAccount("");
        }
        try{
            loginLogsService.add(loginlogs);
        }catch (Exception e){
            logger.error("插入登陆日志异常");
        }
        result.setMessage("登陆成功");
        return result;
    }









    @RequestMapping(value = "openidlogin",method = RequestMethod.GET)
    public ResponseResult openidlogin( HttpServletRequest request) {

        String ip = "";
        ip = WebUtils.getIP(request);
        ResponseResult result = new ResponseResult();

        try {

           PageData pageData= new PageData(request);
            List<SystemUsers> usersList = null;
            usersList = (List<SystemUsers>) daoImp.findForList(MAPPERNAME + "findByOpenId", pageData);
            if(usersList.size()<=0){
                result.setMessage("openid登录失败");
                result.setSuccess(false);
                return result;
            }
            SystemUsers users = usersList.get(0);
            String userId = users.getUserId();
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
            StringBuffer userinfo = new StringBuffer("");

            if (users != null) {

                if (users.getName() != null) {
                    userinfo.append(users.getName());
                }
                if (users.getAccount() != null) {
                    userinfo.append("(" + users.getAccount() + ")");
                }
                if (users.getLevel() != null && users.getLevel() == 9) {
                    userinfo.append(" (超级管理员) ");
                } else {
                    userinfo.append(" (普通用户) ");
                }
            }
            output.setUserinfo(userinfo.toString());
            output.setCookieName("_sid_oc_");
            output.setCookieValue(token);
            output.setCookieExpires(1);

            result.setSuccess(true);
            result.setData(output);

        } catch (Exception e) {

            result.setSuccess(false);
            result.setMessage("身份认证过程中发生异常");
            return result;
        }

        result.setMessage("登陆成功");
        return result;
    }




    @RequestMapping(value = "action", method = RequestMethod.POST)
    public ResponseResult action(HttpServletRequest request) {
        ResponseResult result = new ResponseResult();
        String module = new PageData(request).GetParameter("module");
        if (module != null && !module.equals("")) {
            try {
                List<AuthorizeActionOutput> authorizeActionOutput = actionsService
                        .convertAction2AuthorizeActionOutput(actionsService.getAuthorizeAllActionListByModule(module));
                result.setData(authorizeActionOutput);
                if (authorizeActionOutput != null && authorizeActionOutput.size() > 0) {
                    result.setSuccess(true);
                    result.setMessage("查询成功");
                } else {
                    result.setMessage("查询失败");
                }
            } catch (Exception e) {
                logger.error("---------------获取权限异常---------" + e);
            }
        } else {
            result.setMessage("参数为空");
        }
        return result;
    }




    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ResponseResult exit() {
        return ResponseResult.success();
    }


}
