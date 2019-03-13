package com.system.controller;

import com.authorize.annotation.Authorize;
import com.core.controller.GenericController;
import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.github.pagehelper.PageInfo;
import com.response.ResponseResult;
import com.system.domain.model.input.SystemDataLogsInput;
import com.system.domain.model.output.SystemDataLogsOutput;
import com.system.service.SystemDataLogsService;
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


@Authorize(ignore = true)
@RequestMapping(value = "systemdatalogs")
@RestController
public class SystemDataLogsController extends GenericController<SystemDataLogsInput,SystemDataLogsOutput> {
    private final Logger logger = LoggerFactory.getLogger(SystemDataLogsController.class);

    @Autowired
    private SystemDataLogsService systemDataLogsService;

    @Override
    protected void OnActionExecuting() {
        systemDataLogsService.SetWorkContext(this.WorkContext);
    }

    @Override
    protected AbstractService<SystemDataLogsInput,SystemDataLogsOutput> getService() {
        return systemDataLogsService;
    }


    /**
     * 新增或更新
     * @param systemDataLogsId
     * @param input
     * @return
     */
    @Override
    @RequestMapping(value = "formpost",method = RequestMethod.POST)
    public ResponseResult formPost(String systemDataLogsId, @RequestBody SystemDataLogsInput input) {
        ResponseResult result=new ResponseResult();
        try{

            if (input.getBusinessId()!=null&&input.getActionType()!=null){

            return super.formPost(systemDataLogsId,input);
            }else {
                result.setMessage("参数错误！");
                return result;
            }

        }catch (Exception e){
            logger.error("---------------------add异常-------"+e);
            result.setMessage("处理过程中发生异常");
            result.setMessage_detail(e.toString());
        }
        return  result.error(CommonConstants.EX.EXCEPTION);
    }





    /**
     * 删除
     * @param idList
     * @return
     */
    @Override
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public ResponseResult delete(String idList) {
        try{
            return super.delete(idList);
        }catch (Exception e){
            logger.error("-----------------------delete异常-------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }




    /**
     * 获取分页列表
     * @param request
     * @return
     */
    @Override
    @RequestMapping(value = "pagerlist",method = RequestMethod.GET)
    public ResponseResult pagerList(HttpServletRequest request) {
        ResponseResult result=new ResponseResult();
        try{
            PageData pageData = new PageData(request);
            if(pageData.containsKey("businessId")==false){
                result.setMessage("查询失败");
                return  result;
            }
            if(pageData.containsKey("businessTable")==false){
                result.setMessage("查询失败");
                return  result;
            }
            return ResponseResult.success(new PageInfo<>(systemDataLogsService.nolimitlist(true,new PageData(request))));
        }catch (Exception e){
            logger.error("-----------------------pagelist异常------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }




    /**
     * 获取列表
     * @param request
     * @return
     */

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public  ResponseResult List(HttpServletRequest request) {
        try{
            List<SystemDataLogsOutput> list = systemDataLogsService.list(false,new PageData(request));
            return ResponseResult.success(list);
        }catch (Exception e){
            logger.error("-----------------------pagelist异常------"+e);
        }
        return null;
    }

    /**
     * 获取TEXT
     * @param request
     *
     * @return
     */

    @RequestMapping(value = "textlist",method = RequestMethod.GET)
    public  ResponseResult textList(HttpServletRequest request) {
        try{
            List<SystemDataLogsOutput> list = systemDataLogsService.textlist(false,new PageData(request));
            return ResponseResult.success(list);
        }catch (Exception e){
            logger.error("-----------------------pagelist异常------"+e);
        }
        return null;
    }







}
