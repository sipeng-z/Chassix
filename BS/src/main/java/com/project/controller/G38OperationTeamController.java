package com.project.controller;

import com.core.controller.GenericController;
import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.github.pagehelper.PageInfo;
import com.project.domain.entity.G38OperationTeam;
import com.project.domain.model.input.G38OperationTeamInput;
import com.project.domain.model.output.G38OperationTeamOutput;
import com.project.service.G38OperationTeamService;
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
@RequestMapping(value = "G38OperationTeam")
public class G38OperationTeamController extends GenericController<G38OperationTeamInput,G38OperationTeamOutput> {




    private final Logger logger = LoggerFactory.getLogger(G38OperationTeamController.class);


    @Autowired
    private G38OperationTeamService g38OperationTeamService;

    @Override
    protected void OnActionExecuting() {
        g38OperationTeamService.SetWorkContext(this.WorkContext);
    }


    protected AbstractService<G38OperationTeamInput,G38OperationTeamOutput> getService() {
        return g38OperationTeamService;
    }




    /**
     * ADD/UPDATE
     * @param id
     * @param input
     * @return
     */
    @Override
    @RequestMapping(value = "formpost",method = RequestMethod.POST)
    public ResponseResult formPost(String id, @RequestBody G38OperationTeamInput input) {
        ResponseResult result = new ResponseResult();
        try{
            if(input==null){
                result.setSuccess(false);
                result.setMessage("@RequestBody M");
                return  result;
            }
            if(input.getOperationTeamId()==null||!input.getOperationTeamId().equals("")){

                boolean flag = g38OperationTeamService.add(input);
                if(flag==true){
                    result.setMessage("Success!");
                    result.setSuccess(true);
                    return result;
                }
            }else {
                boolean flag = g38OperationTeamService.update(input);
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
    @Override
    @RequestMapping(value = "pagerlist",method = RequestMethod.GET)
    public ResponseResult pagerList(HttpServletRequest request) {
        try{
            return ResponseResult.success(new PageInfo<>(g38OperationTeamService.list(true,new PageData(request))));
        }catch (Exception e){
            logger.error("-----------------------pagelist异常------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }






}
