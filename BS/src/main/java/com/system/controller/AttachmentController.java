package com.system.controller;

import com.authorize.annotation.Authorize;
import com.core.controller.GenericController;
import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.github.pagehelper.PageInfo;
import com.response.ResponseResult;
import com.system.domain.model.input.AttachmentInput;
import com.system.domain.model.output.AttachmentOutput;
import com.system.service.AttachmentService;
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
@RequestMapping(value = "attachment")
@RestController
public class AttachmentController extends GenericController<AttachmentInput, AttachmentOutput> {
    private final Logger logger = LoggerFactory.getLogger(AttachmentController.class);

    @Autowired
    private AttachmentService attachmentService;


    @Override
    protected void OnActionExecuting() {
        attachmentService.SetWorkContext(this.WorkContext);
    }

    @Override
    protected AbstractService<AttachmentInput,AttachmentOutput> getService() {
        return attachmentService;
    }

    /**
     * 新增或更新
     * @param id
     * @param input
     * @return
     */
    @Override
    @RequestMapping(value = "formpost",method = RequestMethod.POST)
    public ResponseResult formPost(String id, @RequestBody AttachmentInput input) {
        ResponseResult result=new ResponseResult();
        try{
            return super.formPost(id,input);
        }catch (Exception e){
            logger.error("---------------------add异常-------"+e);
            result.setMessage("处理过程中发生异常");
            result.setMessage_detail(e.toString());
        }
        return  result.error(CommonConstants.EX.EXCEPTION);
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
            return ResponseResult.success(new PageInfo<>(attachmentService.list(true,new PageData(request))));
        }catch (Exception e){
            logger.error("-----------------------pagelist异常------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }


    /**
     * 获取分页列表
     * @param request
     * @return
     */
    @RequestMapping(value = "lists",method = RequestMethod.GET)
    public ResponseResult lists(HttpServletRequest request) {
        try{
            return ResponseResult.success(attachmentService.list(false,new PageData(request)));
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

    /**
     * 审批上传附件
     * @param id
     * @param input
     * @return
     */
    @RequestMapping(value = "approval",method = RequestMethod.POST)
    public ResponseResult approval(String id, @RequestBody AttachmentInput input) {
        ResponseResult result=new ResponseResult();
        try{
            if (input.getResourceId()!=null&&input.getResourceId()!=""){
//                立项审批文件ResourceId
                id=input.getResourceId();
            }else {
//                项目设置审批文件管理ResourceId
                id="00000000-0000-0000-0000-000000000001";
            }

            boolean falg= attachmentService.listAdd(id,input.getAttachment());
            if (falg){
                result.setSuccess(true);
                result.setMessage("操作成功");
            }
             return result;
        }catch (Exception e){
            logger.error("---------------------add异常-------"+e);
            result.setMessage("处理过程中发生异常");
            result.setMessage_detail(e.toString());
        }
        return  result.error(CommonConstants.EX.EXCEPTION);
    }

    /**
     * 上传实施计划附件
     * @param input
     * @return
     */
    @RequestMapping(value = "uploadimplementationplanattachment",method = RequestMethod.POST)
    public ResponseResult uploadImplementationPlanAttachment(@RequestBody AttachmentInput input) {
        ResponseResult result=new ResponseResult();
        try{
            String id = "";
            if (input.getResourceId()!=null&&input.getResourceId()!=""){
                id=input.getResourceId();
            }else {
                id="00000000-0000-0000-0000-000000000001";
            }
            boolean falg= attachmentService.listAdd(id,input.getAttachment());
            if (falg){
                result.setSuccess(true);
                result.setMessage("操作成功");
            }
            return result;
        }catch (Exception e){
            logger.error("---------------------add异常-------"+e);
            result.setMessage("处理过程中发生异常");
            result.setMessage_detail(e.toString());
        }
        return  result.error(CommonConstants.EX.EXCEPTION);
    }


    /**
     * 获取项目设置审批文件列表
     * @param request
     * @return
     */
    @RequestMapping(value = "managementlist",method = RequestMethod.GET)
    public ResponseResult managementlist(HttpServletRequest request) {
        try{
            return ResponseResult.success(new PageInfo<>(attachmentService.managementlist(false,new PageData(request))));
        }catch (Exception e){
            logger.error("-----------------------pagelist异常------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }


    /**
     * 获取立项审批附件列表
     * @param request
     * @return
     */
    @RequestMapping(value = "projectslists",method = RequestMethod.GET)
    public ResponseResult projectslists(HttpServletRequest request) {
        try{
            return ResponseResult.success(attachmentService.list(false,new PageData(request)));
        }catch (Exception e){
            logger.error("-----------------------pagelist异常------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }

}
