package com.casting.controller;

import com.casting.domain.entity.MechanicalPropertiesLocationRequirement;
import com.casting.domain.model.input.MechanicalPropertiesLocationRequirementInput;
import com.casting.domain.model.output.MechanicalPropertiesLocationRequirementOutput;
import com.casting.service.MechanicalPropertiesLocationRequirementService;
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
@RequestMapping(value = "MechanicalPropertiesLocationRequirement")
public class MechanicalPropertiesLocationRequirementController extends GenericController<MechanicalPropertiesLocationRequirementInput, MechanicalPropertiesLocationRequirementOutput>{

    private final Logger logger = LoggerFactory.getLogger(MechanicalPropertiesLocationRequirementController.class);

    // IOC function to get
    @Autowired
    private MechanicalPropertiesLocationRequirementService mechanicalPropertiesLocationRequirementService;


    @Override
    protected void OnActionExecuting() {
        mechanicalPropertiesLocationRequirementService.SetWorkContext(this.WorkContext);
    }


    protected AbstractService<MechanicalPropertiesLocationRequirementInput, MechanicalPropertiesLocationRequirementOutput> getService() {
        return mechanicalPropertiesLocationRequirementService;
    }





    /**
     * ADD/UPDATE

     *mechanical properties location form post
     * @param id
     * @param input
     * @return
     */
    @Override
    @RequestMapping(value = "formpost",method = RequestMethod.POST)
    public ResponseResult formPost(String id, @RequestBody MechanicalPropertiesLocationRequirementInput input) {
        ResponseResult result = new ResponseResult();
        try{
            if(input==null){
                result.setMessage("@RequestBody M");
                result.setSuccess(false);
                return result;
            }
            Boolean flag = null;
            if(id==null||id.equals("")){
                flag =  mechanicalPropertiesLocationRequirementService.add(input);

            }else {
                flag =  mechanicalPropertiesLocationRequirementService.update(input);
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
            return ResponseResult.success(new PageInfo<>(mechanicalPropertiesLocationRequirementService.list(true,new PageData(request))));
        }catch (Exception e){
            logger.error("-----------------------pagelist异常------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }



    /**
     * GET
     * get by part name
     */
    @RequestMapping(value = "getByName",method = RequestMethod.GET)
    public ResponseResult getByName(String partName) {
        try{

            PageData pageData = new PageData();
            pageData.put("PartName",partName);
            MechanicalPropertiesLocationRequirementOutput outObj = null;
            List<MechanicalPropertiesLocationRequirementOutput> list = mechanicalPropertiesLocationRequirementService.list(false,pageData);

            if (list.size()>0){
                outObj=list.get(0);
            }

            return ResponseResult.success(outObj);
        }catch (Exception e){
            logger.error("-----------------------getByNumber------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }









}
