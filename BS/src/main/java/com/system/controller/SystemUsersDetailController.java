package com.system.controller;

import com.core.controller.GenericController;
import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.github.pagehelper.PageInfo;
import com.response.ResponseResult;
import com.system.domain.entity.SystemUsersDetail;
import com.system.domain.model.input.SystemUsersDetailInput;
import com.system.domain.model.input.SystemUsersInput;
import com.system.domain.model.output.SystemUsersDetailOutput;
import com.system.domain.model.output.SystemUsersOutput;
import com.system.service.SystemUsersDetailService;
import com.utils.CommonConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "systemuserdetail")
public class SystemUsersDetailController extends GenericController<SystemUsersDetailInput,SystemUsersDetailOutput> {


    private final Logger logger = LoggerFactory.getLogger(SystemUsersDetailController.class);

    @Autowired
    private SystemUsersDetailService systemUsersDetailService;

    protected void OnActionExecuting(){
        systemUsersDetailService.SetWorkContext(this.WorkContext);
    }

    @Override
    protected AbstractService<SystemUsersDetailInput,SystemUsersDetailOutput> getService() {
        return systemUsersDetailService ;
    }

    /**
     * 新增／修改用户
     * @param
     * @return
     */
    @Override
    @RequestMapping(value = "formpost",method = RequestMethod.POST)
    public ResponseResult formPost(String systemUsersDetailId, @RequestBody SystemUsersDetailInput input){
        ResponseResult result = new ResponseResult();
        try {
            return super.formPost(systemUsersDetailId, input);
        }catch (Exception e){
            logger.error("-----------------formPostd异常-----------------"+e);
            result.setMessage("处理过程中发生异常");
            result.setMessage_detail(e.toString());
        }
        return result.error(CommonConstants.EX.EXCEPTION);
    }




    /**
     * 获取用户分页列表
     * @param request
     * @return
     */
    @Override
    @RequestMapping(value = "pagerlist",method = RequestMethod.GET)
    public ResponseResult pagerList(HttpServletRequest request) {
        try{
            return ResponseResult.success(new PageInfo<>(systemUsersDetailService.list(true,new PageData(request))));
        }catch (Exception e){
            logger.error("-----------------------pagelist异常------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }



    /**
     * 删除
     * @param idList
     * @return
     */
    @Override
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public ResponseResult delete(String idList) {
        try{
            return super.delete(idList);
        }catch (Exception e){
            logger.error("-----------------------delete异常-------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }






    /**
     * 根据id获取单个对象
     * @param systemUsersDetailId
     * @return
     */
    @Override
    @RequestMapping(value = "get",method = RequestMethod.GET)
    public ResponseResult get(String systemUsersDetailId) {
        try{

            return super.get(systemUsersDetailId);
        }catch (Exception e){
            logger.error("-----------------------pagelist异常------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }





}
