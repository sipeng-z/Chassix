package com.system.controller;

import com.authorize.annotation.Authorize;
import com.core.controller.GenericController;
import com.core.service.AbstractService;
import com.response.ResponseResult;
import com.system.domain.model.input.RoleActionInput;
import com.system.domain.model.output.RoleActionOutput;
import com.system.service.RoleActionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "roleaction")
@Authorize(ignore = true)
public class RoleActionController extends GenericController<RoleActionInput,RoleActionOutput> {
    private final Logger logger = LoggerFactory.getLogger(RoleActionController.class);

    @Autowired
    private RoleActionService roleActionService;


    @Override
    protected void OnActionExecuting() {
        roleActionService.SetWorkContext(this.WorkContext);
    }

    @Override
    protected AbstractService<RoleActionInput, RoleActionOutput> getService() {
        return roleActionService;
    }



    @RequestMapping(value="getlist", method = RequestMethod.GET)
    public ResponseResult getlist(String roleid) {
        this.Initialize();
        ResponseResult result = new ResponseResult();
        String rtMge = "";
        if(roleid==null || roleid.length()<=0) {
            rtMge = "参数错误";
            result.setMessage(rtMge);
            result.setSuccess(false);
            return result;
        }
        try{
            return ResponseResult.success(roleActionService.getList(roleid));
        }catch (Exception e){
            return ResponseResult.error("处理异常");
        }
    }




    @RequestMapping(value="save", method = RequestMethod.POST)
    public ResponseResult save(String id,String idList) {
        ResponseResult result = new ResponseResult();
        if( id == null) {
            return ResponseResult.error("参数错误");
        }
        try {
            if(roleActionService.save(id, idList)) {
                result.setSuccess(true);
                result.setMessage("保存成功");
                return result;
            }
            result.setSuccess(false);
            result.setMessage("保存失败");
            return result;

        } catch (Exception e) {
            return ResponseResult.error("保存失败");
        }

    }

}
