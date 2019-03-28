package com.project.controller;

import com.core.controller.GenericController;
import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.github.pagehelper.PageInfo;

import com.project.domain.model.input.LineDeviceInput;
import com.project.domain.model.output.LineDeviceOutput;
import com.project.service.LineDeviceService;
import com.response.ResponseResult;
import com.utils.CommonConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


/**
 * get line and devices details list
 */

@RestController
@RequestMapping(value = "LineDevice")
public class LineDeviceController extends GenericController<LineDeviceInput,LineDeviceOutput> {



    private final Logger logger = LoggerFactory.getLogger(LineDeviceController.class);

    @Autowired
    private LineDeviceService lineDeviceService;

    @Override
    protected void OnActionExecuting(){
        lineDeviceService.SetWorkContext(this.WorkContext);
    }

    protected AbstractService<LineDeviceInput,LineDeviceOutput> getService() {
        return lineDeviceService;
    }



    /**
     * PAGERLIST
     * @param request
     * @return
     */
    @Override
    @RequestMapping(value = "pagerlist",method = RequestMethod.GET)
    public ResponseResult pagerList(HttpServletRequest request) {
        try{

            PageData pageData = new PageData(request);
            if (pageData.containsKey("layer")==false){
                pageData.put("layer","0"); //get first layer for line name
            }
            return ResponseResult.success(new PageInfo<>(lineDeviceService.list(true,pageData)));
        }catch (Exception e){
            logger.error("-----------------------pagelist异常------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }






    /**
     * PAGE LIST
     * @param request
     * @return
     */
    @RequestMapping(value = "castingPagerlist",method = RequestMethod.GET)
    public ResponseResult castingPagerList(HttpServletRequest request) {
        try{

            PageData pageData = new PageData(request);
            if (pageData.containsKey("layer")==false){
                pageData.put("layer","0"); //get first layer for line name
            }

            pageData.put("module","C");

            return ResponseResult.success(new PageInfo<>(lineDeviceService.list(true,pageData)));
        }catch (Exception e){
            logger.error("-----------------------pagelist异常------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }







    /**
     * GET
     */

    @RequestMapping(value = "get",method = RequestMethod.GET)
    public ResponseResult get(String LineDeviceId) {
        try{

            return ResponseResult.success(lineDeviceService.get(LineDeviceId));
        }catch (Exception e){
            logger.error("-----------------------pagelist异常------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }









}
