package com.project.controller;

import com.core.controller.GenericController;
import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.github.pagehelper.PageInfo;
import com.project.domain.model.input.G05MarkedContentInput;
import com.project.domain.model.output.G05MarkedContentOutput;
import com.project.service.G05MarkedContentService;
import com.response.ResponseResult;
import com.utils.CommonConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "G05MarkedContent")
public class G05MarkedContentController extends GenericController<G05MarkedContentInput,G05MarkedContentOutput> {


    private final Logger logger = LoggerFactory.getLogger(G05MarkedContentController.class);



    @Autowired
    private G05MarkedContentService g05MarkedContentService;



    @Override
    protected void OnActionExecuting(){
        g05MarkedContentService.SetWorkContext(this.WorkContext);
    }

    protected AbstractService<G05MarkedContentInput,G05MarkedContentOutput> getService() {
        return g05MarkedContentService;
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
            return ResponseResult.success(new PageInfo<>(g05MarkedContentService.list(true,new PageData(request))));
        }catch (Exception e){
            logger.error("-----------------------pagelist异常------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }



}
