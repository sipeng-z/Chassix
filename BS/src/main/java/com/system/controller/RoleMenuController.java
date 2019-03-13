package com.system.controller;

import com.authorize.annotation.Authorize;
import com.core.controller.GenericController;
import com.core.service.AbstractService;
import com.response.ResponseResult;
import com.system.domain.model.input.RoleMenuInput;
import com.system.domain.model.output.RoleMenuDataOutput;
import com.system.domain.model.output.RoleMenuOutput;
import com.system.service.RoleMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(value = "rolemenu")
@Authorize(ignore = true)
public class RoleMenuController extends GenericController<RoleMenuInput,RoleMenuOutput>{
    private final Logger logger = LoggerFactory.getLogger(RoleMenuController.class);

    @Autowired
    private RoleMenuService roleMenuService;

    @Override
    protected void OnActionExecuting() {
        roleMenuService.SetWorkContext(this.WorkContext);
    }

    @Override
    protected AbstractService<RoleMenuInput, RoleMenuOutput> getService() {
        return roleMenuService;
    }


    /**
     * 菜单权限列表
     * @param id
     * @return
     */
    @RequestMapping(value="getlist", method = RequestMethod.GET)
    public ResponseResult getlist(String id){

        ResponseResult result = new ResponseResult();
        String rtMge = "";
        if(id==null || id.length()==0) {
            rtMge = "参数错误";
            return ResponseResult.error(rtMge);
        }
        try {
            List<RoleMenuDataOutput> list = roleMenuService.getList(id);
            return ResponseResult.success(list);
        } catch (Exception e) {
            logger.error("-----------------getList出现异常-----------"+e);
            return ResponseResult.error("查询失败");
        }


    }


    @RequestMapping(value="save", method = RequestMethod.POST)
    public ResponseResult save(String id,String idList) {
        ResponseResult result = new ResponseResult();
        if( id == null) {
            return ResponseResult.error("参数错误");
        }
        try {
            if(roleMenuService.save(id, idList)) {
                result.setSuccess(true);
                result.setMessage("保存成功");
                return result;
            }
            result.setSuccess(false);
            result.setMessage("保存失败");
            return result;
        } catch (Exception e) {
            logger.error("----------------save出现异常-----------"+e);
            return ResponseResult.error("处理异常");
        }

    }

}
