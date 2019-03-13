package com.system.controller;


import com.authorize.annotation.Authorize;
import com.core.controller.GenericController;
import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.github.pagehelper.PageInfo;
import com.response.ResponseResult;
import com.system.domain.model.input.AttachmentConfigInput;
import com.system.domain.model.output.AttachmentConfigOutput;
import com.system.service.AttachmentConfigService;
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
@RequestMapping(value = "attachmentconfig")
@RestController
public class AttachmentConfigController  extends GenericController<AttachmentConfigInput,AttachmentConfigOutput> {
    private final Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    private AttachmentConfigService attachmentConfigService;

    @Override
    protected void OnActionExecuting() {
        attachmentConfigService.SetWorkContext(this.WorkContext);
    }

    @Override
    protected AbstractService<AttachmentConfigInput,AttachmentConfigOutput> getService() {
        return attachmentConfigService;
    }

    /**
     * 新增或更新
     * @param id
     * @param input
     * @return
     */
    @Override
    @RequestMapping(value = "formpost",method = RequestMethod.POST)
    public ResponseResult formPost(String id, @RequestBody AttachmentConfigInput input) {
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
            return ResponseResult.success(new PageInfo<>(attachmentConfigService.list(true,new PageData(request))));
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
            if (id.equals("1")){
                return ResponseResult.success(attachmentConfigService.attachmentConfigList());
            }else {
                return super.get(id);
            }
        }catch (Exception e){
            logger.error("-----------------------pagelist异常------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }
}
