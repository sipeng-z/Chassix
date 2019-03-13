package com.casting.controller;

import com.casting.domain.model.input.CastingCPCGeneralOEEDataTemporaryInput;
import com.casting.domain.model.output.CastingCPCGeneralOEEDataTemporaryOutput;
import com.casting.service.CastingCPCGeneralOEEDataTemporaryService;
import com.core.controller.GenericController;
import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.github.pagehelper.PageInfo;
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


@RequestMapping(value = "CPCGeneralOEEDataTemporary")
@RestController
public class CastingCPCGeneralOEEDataTemporaryController extends GenericController<CastingCPCGeneralOEEDataTemporaryInput,CastingCPCGeneralOEEDataTemporaryOutput> {

    private final Logger logger = LoggerFactory.getLogger(CastingCPCGeneralOEEDataTemporaryController.class);


    @Autowired
    private CastingCPCGeneralOEEDataTemporaryService castingCPCGeneralOEEDataTemporaryService;

    @Override
    protected void OnActionExecuting() {
        castingCPCGeneralOEEDataTemporaryService.SetWorkContext(this.WorkContext);
    }


    protected AbstractService<CastingCPCGeneralOEEDataTemporaryInput,CastingCPCGeneralOEEDataTemporaryOutput> getService() {
        return castingCPCGeneralOEEDataTemporaryService;
    }





    /**
     * ADD/UPDATE
     * @param id
     * @param input
     * @return
     */

    @RequestMapping(value = "generalformpost",method = RequestMethod.POST)
    public ResponseResult generalformPost(String id, @RequestBody CastingCPCGeneralOEEDataTemporaryInput input,String device) {
        ResponseResult result = new ResponseResult();
        try{
            if(input==null){
                result.setSuccess(false);
                result.setMessage("@RequestBody M");
                return  result;
            }
            if(input.getTemporaryId()==null||input.getTemporaryId().equals("")){

                boolean flag = castingCPCGeneralOEEDataTemporaryService.addnewhalt(input,device);
                if(flag==true){
                    result.setMessage("Success!");
                    result.setSuccess(true);
                    return result;
                }
            }else {
                boolean flag = castingCPCGeneralOEEDataTemporaryService.update(input);
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

    @RequestMapping(value = "generalpagerlist",method = RequestMethod.GET)
    public ResponseResult generalpagerList(HttpServletRequest request,String device) {
        try{
            return ResponseResult.success(new PageInfo<>(castingCPCGeneralOEEDataTemporaryService.generallist(true,new PageData(request),device)));
        }catch (Exception e){
            logger.error("-----------------------pagelist异常------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }

















}
