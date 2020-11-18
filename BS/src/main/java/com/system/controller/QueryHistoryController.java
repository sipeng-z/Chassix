package com.system.controller;

import com.authorize.annotation.Authorize;
import com.core.controller.GenericController;
import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.github.pagehelper.PageInfo;
import com.response.ResponseResult;
import com.system.domain.model.input.LaserMarkerPrintedPNInput;
import com.system.domain.model.input.LoginLogsInput;
import com.system.domain.model.output.LaserMarkerPrintedPNOutput;
import com.system.domain.model.output.LoginLogsOutput;
import com.system.service.LoginLogsService;
import com.system.service.QueryHistoryService;
import com.utils.CommonConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Authorize(ignore = true)
@RequestMapping(value = "Quality")
@RestController
public class QueryHistoryController extends GenericController<LaserMarkerPrintedPNInput, LaserMarkerPrintedPNOutput> {


    @Autowired
    private QueryHistoryService queryHistoryService;

    @Override
    protected void OnActionExecuting() {
        queryHistoryService.SetWorkContext(this.WorkContext);
    }

    @Override
    protected AbstractService<LaserMarkerPrintedPNInput, LaserMarkerPrintedPNOutput> getService() {
        return queryHistoryService;
    }
    @Override
    @RequestMapping(value = "pagerlist",method = RequestMethod.GET)
    public ResponseResult pagerList(HttpServletRequest request) {
        try{
            return ResponseResult.success(new PageInfo<>(queryHistoryService.list(true,new PageData(request))));
        }catch (Exception e){
//            logger.error("-----------------------pagelist异常------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }

}
