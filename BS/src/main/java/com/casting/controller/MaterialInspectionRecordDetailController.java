package com.casting.controller;

import com.casting.domain.model.input.MaterialInspectionRecordDetailInput;
import com.casting.domain.model.input.MaterialInspectionRecordInput;
import com.casting.domain.model.output.MaterialInspectionRecordDetailOutput;
import com.casting.domain.model.output.MaterialInspectionRecordOutput;
import com.casting.service.MaterialInspectionRecordDetailService;
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

@RestController
@RequestMapping(value = "MaterialInspectionDetail")
public class MaterialInspectionRecordDetailController extends GenericController<MaterialInspectionRecordDetailInput,MaterialInspectionRecordDetailOutput> {




    private final Logger logger = LoggerFactory.getLogger(MaterialInspectionRecordDetailController.class);


    @Autowired
    private MaterialInspectionRecordDetailService materialInspectionRecordDetailService;


    @Override
    protected void OnActionExecuting() {
        materialInspectionRecordDetailService.SetWorkContext(this.WorkContext);
    }


    protected AbstractService<MaterialInspectionRecordDetailInput,MaterialInspectionRecordDetailOutput> getService() {
        return materialInspectionRecordDetailService;
    }




    /**
     * ADD/UPDATE
     * @param id
     * @param input
     * @return
     */
    @Override
    @RequestMapping(value = "formpost",method = RequestMethod.POST)
    public ResponseResult formPost(String id, @RequestBody MaterialInspectionRecordDetailInput input) {
        ResponseResult result = new ResponseResult();
        try{
            if(input==null){
                result.setMessage("@RequestBody M");
                result.setSuccess(false);
                return result;
            }
            Boolean flag = null;
            if(id==null||id.equals("")){
                flag =  materialInspectionRecordDetailService.add(input);

            }else {
                flag =  materialInspectionRecordDetailService.update(input);
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
     * PAGERLIST for Material inspection all list / with serch
     * Get
     * @param request
     * @return
     */
    @RequestMapping(value = "pagerlist",method = RequestMethod.GET)
    public ResponseResult pagerList(HttpServletRequest request) {
        try{
            return ResponseResult.success(new PageInfo<>(materialInspectionRecordDetailService.list(true,new PageData(request))));
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

            return ResponseResult.success(materialInspectionRecordDetailService.getByBatchNumber(batchNumber));
        }catch (Exception e){
            logger.error("-----------------------getByNumber------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }








}
