package com.casting.controller;

import com.casting.domain.model.input.MechanicalPropertiesReportInput;
import com.casting.domain.model.output.MechanicalPropertiesReportOutput;
import com.casting.service.MechanicalPropertiesReportService;
import com.casting.service.MechanicalTestSpecService;
import com.core.controller.GenericController;
import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.github.pagehelper.PageInfo;
import com.response.ResponseResult;
import com.utils.CommonConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "MechanicalPropertiesReport")
public class MechanicalPropertiesReportController extends GenericController<MechanicalPropertiesReportInput,MechanicalPropertiesReportOutput> {





    private final Logger logger = LoggerFactory.getLogger(MechanicalPropertiesReportController.class);

    @Autowired
    private MechanicalPropertiesReportService mechanicalPropertiesReportService  ;

    @Autowired
    private MechanicalTestSpecService mechanicalTestSpecService;

    @Override
    protected void OnActionExecuting() {
        mechanicalPropertiesReportService.SetWorkContext(this.WorkContext);
    }


    protected AbstractService<MechanicalPropertiesReportInput,MechanicalPropertiesReportOutput> getService() {
        return mechanicalPropertiesReportService;
    }









    /**
     * ADD/UPDATE

     *mechanical properties report
     * @param id
     * @param input
     * @return
     */
    @Override
    @RequestMapping(value = "formpost",method = RequestMethod.POST)
    public ResponseResult formPost(String id, @RequestBody MechanicalPropertiesReportInput input) {
        ResponseResult result = new ResponseResult();
        try{
            if(input==null){
                result.setMessage("@RequestBody M");
                result.setSuccess(false);
                return result;
            }
            Boolean flag = null;
            if(id==null||id.equals("")){
                flag =  mechanicalPropertiesReportService.add(input);

            }else {
                flag =  mechanicalPropertiesReportService.update(input);
            }
            if(flag==true){


                result.setMessage("Success!");
                result.setSuccess(true);
                return result;
            }else {
                result.setMessage("Error!");
                result.setSuccess(false);
                return result;
            }
        }catch (Exception e){
            logger.error("---------------------add/update error-------"+e);
            result.setMessage("error in progress");
            result.setMessage_detail(e.toString());
        }
        return result.error(CommonConstants.EX.EXCEPTION);
    }









    /**
     * PAGERLIST for Material inspection all list / with search
     * Get
     * @param request
     * @return
     */
    @RequestMapping(value = "pagerlist",method = RequestMethod.GET)
    public ResponseResult pagerList(HttpServletRequest request) {
        try{
            return ResponseResult.success(new PageInfo<>(mechanicalPropertiesReportService.list(true,new PageData(request))));
        }catch (Exception e){
            logger.error("-----------------------pagelist异常------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }


    /**
     * GET
     * get by PKID
     */
    @RequestMapping(value = "getByNumber",method = RequestMethod.GET)
    public ResponseResult getByNumber(String batchNumber) {
        try{

            return ResponseResult.success(mechanicalPropertiesReportService.getByBatchNumber(batchNumber));
        }catch (Exception e){
            logger.error("-----------------------getByNumber------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }

    @RequestMapping(value = "deleteByNumber",method = RequestMethod.GET)
    public ResponseResult deleteByNumber(String batchNumber) {
        try{

            return ResponseResult.success(mechanicalPropertiesReportService.deleteByBatchNumber(batchNumber));
        }catch (Exception e){
            logger.error("-----------------------getByNumber------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }


    @RequestMapping(value = "getData",method = RequestMethod.GET)
    public ResponseResult getData(){
        return ResponseResult.success(mechanicalTestSpecService.getData());
    }

    @RequestMapping(value = "getDataByPartName",method = RequestMethod.GET)
    public ResponseResult getDataByPartName(String partname){
        return ResponseResult.success(mechanicalTestSpecService.getDataByPartName(partname));
    }








}
