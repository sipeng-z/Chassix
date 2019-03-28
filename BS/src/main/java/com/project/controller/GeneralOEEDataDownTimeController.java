package com.project.controller;

import com.core.controller.GenericController;
import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.github.pagehelper.PageInfo;
import com.project.domain.model.input.GeneralOEEDataTemporaryInput;
import com.project.domain.model.output.GeneralOEEDataTemporaryOutput;
import com.project.service.GeneralOEEDataTemporaryService;
import com.response.ResponseResult;
import com.utils.CommonConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RequestMapping(value = "GeneralDownTime")
@RestController
public class GeneralOEEDataDownTimeController extends GenericController<GeneralOEEDataTemporaryInput, GeneralOEEDataTemporaryOutput> {

    private final Logger logger = LoggerFactory.getLogger(GeneralOEEDataDownTimeController.class);


    @Autowired
    private GeneralOEEDataTemporaryService generalOEEDataTemporaryService;

    @Override
    protected void OnActionExecuting() {
        generalOEEDataTemporaryService.SetWorkContext(this.WorkContext);
    }


    protected AbstractService<GeneralOEEDataTemporaryInput,GeneralOEEDataTemporaryOutput> getService() {
        return generalOEEDataTemporaryService;
    }





    /**
     * ADD
     * @param id
     * @param input
     * @return
     */

    @RequestMapping(value = "addDownTime",method = RequestMethod.POST)
    public ResponseResult generalFormPost(String id, @RequestBody GeneralOEEDataTemporaryInput input,String line,String device) {
        ResponseResult result = new ResponseResult();
        try{
            if(input==null){
                result.setSuccess(false);
                result.setMessage("@RequestBody M");
                return  result;
            }
            if(input.getTemporaryId()==null||input.getTemporaryId().equals("")){

                boolean flag = generalOEEDataTemporaryService.addnewhalt(input,line, device);
                if(flag==true){
                    result.setMessage("Success!");
                    result.setSuccess(true);
                    return result;
                }
            }else {
                boolean flag = generalOEEDataTemporaryService.update(input);
                if(flag==true){
                    result.setMessage("Success!");
                    result.setSuccess(true);
                    return result;
                }
            }
        }catch (Exception e){
            logger.error("---------------------add异常-------"+e);
            result.setMessage("处理过程中发生异常");
            result.setMessage_detail(e.toString());
        }
        return result.error(CommonConstants.EX.EXCEPTION);
    }





    /**
     * PAGELIST
     * @param request
     * @return
     */

    @RequestMapping(value = "pageList",method = RequestMethod.GET)
    public ResponseResult generalPageList(HttpServletRequest request,String line,String device) {
        try{
            return ResponseResult.success(new PageInfo<>(generalOEEDataTemporaryService.generallist(true,new PageData(request),line,device)));
        }catch (Exception e){
            logger.error("-----------------------pagelist异常------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }













}
