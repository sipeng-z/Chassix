package com.casting.controller;

import com.casting.domain.entity.MechanicalPropertiesReportDetail;
import com.casting.domain.model.input.MechanicalPropertiesReportDetailInput;
import com.casting.domain.model.output.MechanicalPropertiesReportDetailOutput;
import com.casting.service.MechanicalPropertiesReportDetailService;
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
import java.util.List;


@RestController
@RequestMapping(value = "MechanicalPropertiesReportDetail")
public class MechanicalPropertiesReportDetailController extends GenericController<MechanicalPropertiesReportDetailInput,MechanicalPropertiesReportDetailOutput> {






    private final Logger logger = LoggerFactory.getLogger(MaterialInspectionRecordDetailController.class);


    @Autowired
    private MechanicalPropertiesReportDetailService mechanicalPropertiesReportDetailService;


    @Override
    protected void OnActionExecuting() {
        mechanicalPropertiesReportDetailService.SetWorkContext(this.WorkContext);
    }


    protected AbstractService<MechanicalPropertiesReportDetailInput,MechanicalPropertiesReportDetailOutput> getService() {
        return mechanicalPropertiesReportDetailService;
    }



    /**
     * ADD by table
     * @param id
     * @param input
     * @return
     */
    @RequestMapping(value = "addByTable",method = RequestMethod.POST)
    public ResponseResult addByTable(String id, @RequestBody MechanicalPropertiesReportDetailInput input) {
        ResponseResult result = new ResponseResult();
        try{
            if(input==null){
                result.setMessage("@RequestBody M");
                result.setSuccess(false);
                return result;
            }
            Boolean flag = true;

            List<MechanicalPropertiesReportDetailInput> contents = input.getContents();

            for(MechanicalPropertiesReportDetailInput detail : contents){
                if(detail.getBatchNumber()==null||detail.getBatchNumber().equals("")){
                    result.setMessage("Batch Number is null!");
                    result.setSuccess(false);
                    return result;
                }
                if(detail.getCastingid()==null||detail.equals("")){
                    continue;
                }


              Boolean flags =   mechanicalPropertiesReportDetailService.add(detail);

              if(flags==false){
                  flag = false;
              }
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
            logger.error("--------------------- add by table error-------"+e);
            result.setMessage("error in progress");
            result.setMessage_detail(e.toString());
        }
        return result.error(CommonConstants.EX.EXCEPTION);
    }






    /**
     * PAGERLIST for Material inspection all list / with serch
     * Get
     * @param request
     * @return
     */
    @RequestMapping(value = "pagerlist",method = RequestMethod.GET)
    public ResponseResult pagerList(HttpServletRequest request) {
        try{
            return ResponseResult.success(new PageInfo<>(mechanicalPropertiesReportDetailService.list(true,new PageData(request))));
        }catch (Exception e){
            logger.error("-----------------------pagelist异常------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }



    /**
     * GET
     * get by ByNumber
     */
    @RequestMapping(value = "getDetailByNumber",method = RequestMethod.GET)
    public ResponseResult getDetailByNumber(String batchNumber) {
        try{

            return ResponseResult.success(mechanicalPropertiesReportDetailService.getByBatchNumber(batchNumber));
        }catch (Exception e){
            logger.error("-----------------------getByNumber------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }















}
