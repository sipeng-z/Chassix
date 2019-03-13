package com.casting.controller;

import com.casting.domain.model.input.CastingCPCGeneralShiftInput;
import com.casting.domain.model.output.CastingCPCGeneralShiftOutput;
import com.casting.service.CastingCPCGeneralOEEDataTemporaryService;
import com.casting.service.CastingCPCGeneralShiftService;
import com.core.controller.GenericController;
import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.github.pagehelper.PageInfo;
import com.model.AppConsts;
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


@RestController
@RequestMapping(value = "generalCPCGeneralShift")
public class CastingCPCGeneralShiftController extends GenericController<CastingCPCGeneralShiftInput,CastingCPCGeneralShiftOutput> {



    private final Logger logger = LoggerFactory.getLogger(CastingCPCGeneralShiftController.class);

    @Autowired
    private CastingCPCGeneralShiftService castingCPCGeneralShiftService;


    @Autowired
    private CastingCPCGeneralOEEDataTemporaryService castingCPCGeneralOEEDataTemporaryService;


    @Override
    protected void OnActionExecuting(){
        castingCPCGeneralShiftService.SetWorkContext(this.WorkContext);
    }

    protected AbstractService<CastingCPCGeneralShiftInput,CastingCPCGeneralShiftOutput> getService() {
        return castingCPCGeneralShiftService;
    }






    /**
     * ADD/UPDATE
     * @param id
     * @param input
     * @return
     */

    @RequestMapping(value = "generalformpost",method = RequestMethod.POST)
    public ResponseResult generalformPost(String id, @RequestBody CastingCPCGeneralShiftInput input,String device) {
        ResponseResult result = new ResponseResult();
        try{
            if(input==null){
                result.setSuccess(false);
                result.setMessage("@RequestBody M");
                return  result;
            }
            if(input.getShiftId()==null||input.getShiftId().equals("")){

                boolean flag = castingCPCGeneralShiftService.generaladd(input,device);
                if(flag==true){
                    result.setMessage("Success!");
                    result.setSuccess(true);
                    return result;
                }
            }else {
                boolean flag = castingCPCGeneralShiftService.generalupdate(input,device);
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
     * PAGERLIST
     * @param request
     * @return
     */

    @RequestMapping(value = "generalpagerlist",method = RequestMethod.GET)
    public ResponseResult generalpagerList(HttpServletRequest request,String device) {
        try{
            return ResponseResult.success(new PageInfo<>(castingCPCGeneralShiftService.generallist(true,new PageData(request),device)));
        }catch (Exception e){
            logger.error("-----------------------pagelist异常------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }





    /**
     * ADD/UPDATE
     * @param id
     * @param input
     * @return
     */
    @RequestMapping(value = "addshift",method = RequestMethod.POST)
    public ResponseResult addshift(String id, @RequestBody CastingCPCGeneralShiftInput input,String device) {
        ResponseResult result = new ResponseResult();
        try{
            if(input==null){
                result.setSuccess(false);
                result.setMessage("@RequestBody Error");
                return  result;
            }
            if(input.getIsDefault()==0||input.getIsDefault()==null){
                return super.formPost(id,input);
            }else {

                Integer flag = castingCPCGeneralShiftService.addByDefault(input,device);
                boolean flag4LnB  =  castingCPCGeneralOEEDataTemporaryService.fixLnB(AppConsts.yearNo,input.getWeekNo(),device);

                if(flag==1&&flag4LnB==true){
                    result.setSuccess(true);
                    result.setMessage("Add Shift Success! (Lnd fixed) ");
                    return  result;
                }else if(flag==0){
                    result.setSuccess(false);
                    result.setMessage(" The shift Plan already exists!");
                    return  result;
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
     * GET
     */

    @RequestMapping(value = "generalget",method = RequestMethod.GET)
    public ResponseResult generalget(String shiftId,String device) {
        try{

            return ResponseResult.success(castingCPCGeneralShiftService.generalget(shiftId,device));
        }catch (Exception e){
            logger.error("-----------------------pagelist异常------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }










}
