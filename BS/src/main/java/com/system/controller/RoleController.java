package com.system.controller;

import com.authorize.annotation.Authorize;
import com.core.controller.GenericController;
import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.github.pagehelper.PageInfo;
import com.response.ResponseResult;
import com.system.domain.model.input.RoleInput;
import com.system.domain.model.output.RoleOutput;
import com.system.service.RoleService;
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
@Authorize(ignore = true)
@RequestMapping(value = "/role")
public class RoleController extends GenericController<RoleInput,RoleOutput> {
    private final Logger logger = LoggerFactory.getLogger(RoleController.class);


    @Autowired
    private RoleService roleService;

    @Override
    protected void OnActionExecuting() {
        roleService.SetWorkContext(this.WorkContext);
    }

    @Override
    protected AbstractService<RoleInput, RoleOutput> getService() {
        return roleService;
    }

    /**
     * 新增/修改
     * @param id
     * @param roleInput
     * @return
     */
    @Override
    @RequestMapping(value = "formpost",method = RequestMethod.POST)
    public ResponseResult formPost(String id, @RequestBody RoleInput roleInput){
        ResponseResult result = new ResponseResult();
        try{
            boolean flag=roleService.checkSerialClass(roleInput);
            if(flag==true){
                return super.formPost(id,roleInput);
            }else {
                result.setMessage("角色名已被使用，无法继续");
                return result;
            }
        }catch (Exception e){
            logger.error("---------------------add异常-------"+e);
            result.setMessage("处理过程中发生异常");
            result.setMessage_detail(e.toString());
        }
        return result.error(CommonConstants.EX.EXCEPTION);
    }

    /**
     * 审核
     * @param idList
     * @param state
     * @return
     */
    @Override
    @RequestMapping(value = "audit",method = RequestMethod.POST)
    public ResponseResult audit(String idList, Integer state) {
        try{
            return super.audit(idList,state);
        }catch (Exception e){
            logger.error("-----------------------audit异常-------"+e);
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
     * 获取分页列表
     * @param request
     * @return
     */
    @Override
    @RequestMapping(value = "pagerlist",method = RequestMethod.GET)
    public ResponseResult pagerList(HttpServletRequest request) {
        try{
            return ResponseResult.success(new PageInfo<>(roleService.list(true,new PageData(request))));
        }catch (Exception e){
            logger.error("-----------------------pagelist异常------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }


    /**
     * 根据id获取单个对象
     * @param id
     * @return
     */
    @Override
    @RequestMapping(value = "get",method = RequestMethod.GET)
    public ResponseResult get(String id) {
        try{
            return super.get(id);
        }catch (Exception e){
            logger.error("-----------------------pagelist异常------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }









}
