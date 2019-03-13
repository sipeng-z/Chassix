package com.system.controller;

import com.authorize.annotation.Authorize;
import com.core.controller.GenericController;
import com.core.service.AbstractService;
import com.response.ResponseResult;
import com.system.domain.model.input.UserRoleInput;
import com.system.domain.model.input.UserroleDataInput;
import com.system.domain.model.output.UserRoleOutput;
import com.system.domain.model.output.UserroleDataOutput;
import com.system.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "userrole")
@Authorize(ignore = true)
public class UserRoleController extends GenericController<UserRoleInput,UserRoleOutput> {

    @Autowired
    private UserRoleService userRoleService;

    @Override
    protected void OnActionExecuting() {
        userRoleService.SetWorkContext(this.WorkContext);
    }

    @Override
    protected AbstractService<UserRoleInput, UserRoleOutput> getService() {
        return userRoleService;
    }


    @RequestMapping(value = "/userrolepost", method = RequestMethod.POST)
    public ResponseResult userrolepost(@RequestBody UserroleDataInput userroleDataInput) {
        ResponseResult result = new ResponseResult();
        String rtMsg = "";
        String userid = userroleDataInput.getId();
        String roleidList = userroleDataInput.getIdList();
        if (userid == null) {
            rtMsg = "参数错误";
            return ResponseResult.error(rtMsg);
        }
        try {
            if(userid.equals(this.WorkContext.getUserId())){
                rtMsg = "不能修改自己的角色";
                result.setMessage(rtMsg);
                return result;
            }
            if (userRoleService.userrolepost(userid, roleidList)) {
                rtMsg = "数据更改成功";
                result.setSuccess(true);
            }
        } catch (Exception e) {
            rtMsg = "数据更改失败";
        }
        result.setMessage(rtMsg);
        return result;
    }




    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseResult list(String id) {

        ResponseResult result = new ResponseResult();
        String rtMsg = "";
        if (id == null) {
            rtMsg = "参数错误";
        }
        List<UserroleDataOutput> list = null;
        try {
            list = userRoleService.getList(id);
            result.setData(list);
            result.setSuccess(true);
            rtMsg = "数据获取成功";
        } catch (Exception e) {
            rtMsg = "数据获取失败";
            result.setSuccess(false);
        }
        result.setMessage(rtMsg);
        return result;
    }


}
