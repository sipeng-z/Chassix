package com.system.controller;

import com.authorize.annotation.Authorize;
import com.core.controller.GenericController;
import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.github.pagehelper.PageInfo;
import com.response.ResponseResult;
import com.system.domain.model.input.CastingChemistryUseInput;
import com.system.domain.model.output.CastingChemistryUseOutput;
import com.system.service.QueryBatchIdService;
import com.utils.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Authorize(ignore = true)
@RequestMapping(value = "QualityBatch")
@RestController
public class QueryBatchIdController extends GenericController<CastingChemistryUseInput, CastingChemistryUseOutput> {


    @Autowired
    private QueryBatchIdService queryBatchIdService;

    @Override
    protected void OnActionExecuting() {
        queryBatchIdService.SetWorkContext(this.WorkContext);
    }

    @Override
    protected AbstractService<CastingChemistryUseInput, CastingChemistryUseOutput> getService() {
        return queryBatchIdService;
    }
    @Override
    @RequestMapping(value = "pagerlist",method = RequestMethod.GET)
    public ResponseResult pagerList(HttpServletRequest request) {
        try{
            return ResponseResult.success(new PageInfo<>(queryBatchIdService.list(true,new PageData(request))));
        }catch (Exception e){
//            logger.error("-----------------------pagelist异常------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }

}
