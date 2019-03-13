package com.system.controller;

import com.core.controller.GenericController;
import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.github.pagehelper.PageInfo;
import com.response.ResponseResult;
import com.system.domain.entity.SystemUsers;
import com.system.domain.entity.SystemUsersDetail;
import com.system.domain.model.input.SystemUsersDetailInput;
import com.system.domain.model.input.SystemUsersInput;
import com.system.domain.model.output.SystemUsersOutput;
import com.system.service.SystemUsersDetailService;
import com.system.service.SystemUsersService;
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
@RequestMapping(value = "systemusers")
public class SystemUsersController extends GenericController<SystemUsersInput,SystemUsersOutput> {

    private final Logger logger = LoggerFactory.getLogger(SystemUsersController.class);

    @Autowired
    private SystemUsersService systemUsersService;

    @Autowired
    private SystemUsersDetailService systemUsersDetailService;

    protected void OnActionExecuting(){

        systemUsersService.SetWorkContext(this.WorkContext);
        systemUsersDetailService.SetWorkContext(this.WorkContext);
    }


    @Override
    protected AbstractService<SystemUsersInput,SystemUsersOutput> getService() {
        return systemUsersService;
    }

    /**
     * 新增／修改用户
     * @param
     * @return
     */
    @Override
    @RequestMapping(value = "formpost",method = RequestMethod.POST)
    public ResponseResult formPost(String userId, @RequestBody SystemUsersInput input){
        ResponseResult result = new ResponseResult();
        try {
            if(input.getOpenid()==null||input.getOpenid().equals("")){
                result.setSuccess(false);
                result.setMessage("openid为空");
                return result;
            }

            SystemUsersOutput systemUsersOutput   =   systemUsersService.getbyopenid(input.getOpenid());
            if(systemUsersOutput!=null){
                result.setSuccess(false);
                result.setMessage("openid已存在");
                return result;
            }


           boolean flag = systemUsersService.add(input);
            if(flag){
                SystemUsersDetailInput systemUsersDetailInput = new SystemUsersDetailInput();
                systemUsersDetailService.add(systemUsersDetailInput);
            }


            result.setMessage("新增用户／详情成功！");
            result.setSuccess(true);
            return result;
        }catch (Exception e){
            logger.error("-----------------新增用户／详情发生异常！-----------------"+e);
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
            return ResponseResult.success(new PageInfo<>(systemUsersService.list(true,new PageData(request))));
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
     * @param userId
     * @return
     */
    @Override
    @RequestMapping(value = "get",method = RequestMethod.GET)
    public ResponseResult get(String userId) {
        try{

            return super.get(userId);
        }catch (Exception e){
            logger.error("-----------------------pagelist异常------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }

    /**
     * 审核用户（商家）
     * @param userId
     * @return
     */



    @RequestMapping(value="audituser",method = RequestMethod.GET)
    public ResponseResult audituser(String userId,Integer state){
        ResponseResult result =new ResponseResult();

        if(userId==null || userId.equals("")){
            result.setMessage("参数错误");
            result.setSuccess(false);
            return result;
        }
        try{
            systemUsersService.audituser(userId,state);
            result.setMessage("操作成功！");
            result.setSuccess(true);
            return result;
        }catch (Exception e){
            logger.error("---------------------关闭异常-------"+e);
            result.setMessage("处理过程中发生异常");
            result.setMessage_detail(e.toString());
        }

        return result.error(CommonConstants.EX.EXCEPTION);
    }




}
