package com.system.controller;

import com.authorize.annotation.Authorize;
import com.core.controller.GenericController;
import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.github.pagehelper.PageInfo;
import com.response.ResponseResult;
import com.system.domain.model.input.LoginLogsInput;
import com.system.domain.model.output.LoginLogsOutput;
import com.system.service.LoginLogsService;
import com.utils.CommonConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Authorize(ignore = true)
@RequestMapping(value = "loginlogs")
@RestController
public class LoginLogsController extends GenericController<LoginLogsInput,LoginLogsOutput> {
    private final Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    private LoginLogsService loginLogsService;

    @Override
    protected void OnActionExecuting() {
        loginLogsService.SetWorkContext(this.WorkContext);
    }

    @Override
    protected AbstractService<LoginLogsInput,LoginLogsOutput> getService() {
        return loginLogsService;
    }

    /**
     * 新增
     * @param id
     * @param input
     * @return
     */
    @Override
    @RequestMapping(value = "formpost",method = RequestMethod.POST)
    public ResponseResult formPost(String id,@RequestBody LoginLogsInput input) {
        ResponseResult result = new ResponseResult();
        try{
            return super.formPost(id,input);
        }catch (Exception e){
            logger.error("---------------------add异常-------"+e);
            result.setMessage("处理过程中发生异常");
            result.setMessage_detail(e.toString());
        }
        return result.error(CommonConstants.EX.EXCEPTION);
    }
    /**
     * 获取分页列表
     * @param request
     * @return
     */
    @Override
    @RequestMapping(value = "pagerlist",method = RequestMethod.GET)
    public ResponseResult pagerList(HttpServletRequest request) {
        try{
            return ResponseResult.success(new PageInfo<>(loginLogsService.list(true,new PageData(request))));
        }catch (Exception e){
            logger.error("-----------------------pagelist异常------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }


}
