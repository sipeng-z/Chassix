package com.casting.controller;



import com.casting.service.CastingConsumptionService;
import com.core.controller.GenericController;
import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.casting.domain.entity.CastingValue;
import com.project.domain.entity.ScrapValue;
import com.response.ResponseResult;
import com.utils.CommonConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@RequestMapping(value = "CastingConsumption")
@RestController
public class CastingConsumptionController extends GenericController<CastingValue,CastingValue> {


    private final Logger logger = LoggerFactory.getLogger(CastingConsumptionController.class);


    @Autowired
    private CastingConsumptionService castingConsumptionService;

    @Override
    protected void OnActionExecuting() {
        castingConsumptionService.SetWorkContext(this.WorkContext);
    }


    protected AbstractService<CastingValue,CastingValue> getService() {
        return castingConsumptionService;
    }



    /**
     *
     * get  Aluminum usage
     * until now , latest records
     * primary in stock ; scrap in stock ; sprue in stock
     * primary in wis ; scrap in wis; sprue in wip
     * @paramF
     * @return
     */
    @RequestMapping(value = "Usage",method = RequestMethod.GET)
    public ResponseResult getUsage()  {

        try{

            return ResponseResult.success(castingConsumptionService.getAluminumUsage());

        }catch (Exception e){
            logger.error("-------------getDownTime Error--------"+e);
        }


        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }






    /**
     * line consumption
     *
     * get  Aluminum consumption
     * until now , latest records
     *
     * for each line
     * @paramF String Line
     * @return
     */
    @RequestMapping(value = "Consumption",method = RequestMethod.GET)
    public ResponseResult getConsumption(String line)  {

        try{

            return ResponseResult.success(castingConsumptionService.getAluminumConsumption(line));

        }catch (Exception e){
            logger.error("-------------getDownTime Error--------"+e);
        }


        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }










}
