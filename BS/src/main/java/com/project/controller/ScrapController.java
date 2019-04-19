package com.project.controller;

import com.project.service.ScrapService;
import com.core.controller.GenericController;
import com.core.service.AbstractService;
import com.domain.model.PageData;
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

@RequestMapping(value = "Scrap")
@RestController
public class ScrapController extends GenericController<ScrapValue,ScrapValue> {




    private final Logger logger = LoggerFactory.getLogger(ScrapController.class);


    @Autowired
    private ScrapService scrapService;

    @Override
    protected void OnActionExecuting() {
        scrapService.SetWorkContext(this.WorkContext);
    }


    protected AbstractService<ScrapValue,ScrapValue> getService() {
        return scrapService;
    }

    /**
     *
     * @param days time round
     * @param line line name
     * @param cf casting / machining
     * @return
     */

    @RequestMapping(value = "getScrap",method = RequestMethod.GET)
    public ResponseResult getScrap(Integer days, String line,String cf)  {


        try{

            PageData pageData = new PageData();

            if(days!=null){
                Date today = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Calendar calstart = Calendar.getInstance();
                calstart.setTime(today);
                calstart.add(Calendar.DAY_OF_WEEK, (days));
                String dateStringAdd =sdf.format(calstart.getTime());
                pageData.put("entrydate",dateStringAdd);

            }


            if(line!=null&&!line.equals("")){
                pageData.put("line",line);
            }

            if(cf!=null&&!cf.equals("")){
                pageData.put("cf",cf);
            }


            return ResponseResult.success(scrapService.getScrap(pageData));

        }catch (Exception e){
            logger.error("-------------getDownTime Error--------"+e);
        }


        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }


    /**
     * days for how many days before query date
     * @param days from ago
     * @return
     */
    @RequestMapping(value = "getScrapWithName",method = RequestMethod.GET)
    public ResponseResult getScrapWithName(Integer days)  {

        try{
            PageData pageData = new PageData();

            if(days!=null){
                Date today = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Calendar calstart = Calendar.getInstance();
                calstart.setTime(today);
                      calstart.add(Calendar.DAY_OF_WEEK, (days));
                      String dateStringAdd =sdf.format(calstart.getTime());
                      pageData.put("entrydate",dateStringAdd);
            }

            return ResponseResult.success(scrapService.getScrapWithName(pageData));

        }catch (Exception e){
            logger.error("-------------getDownTime Error--------"+e);
        }


        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }





    /**
     * days for how many days before query date
     * parameter : lineName , weekNo , type : casting/machining (c/f)
     * @return
     */
    @RequestMapping(value = "getScrapLineWeek",method = RequestMethod.GET)
    public ResponseResult getScrapLineWeek(Integer year,Integer weekNo,String lineName,String type)  {

        try{
            PageData pageData = new PageData();

            List<String> DateStringInList = new ArrayList<>();


            //weekno , year get monday date
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR,year);
            cal.set(Calendar.WEEK_OF_YEAR, weekNo);
            cal.set(Calendar.DAY_OF_WEEK, 2);
            Date date = cal.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");



            for(int i=0;i<7;i++){
                Calendar calstart = Calendar.getInstance();
                calstart.setTime(date);
                calstart.add(Calendar.DAY_OF_WEEK, (i));
                String dateStringAdd =sdf.format(calstart.getTime());
                DateStringInList.add(dateStringAdd);
            }


            //date list 0 : start date ; list 6 : end date
            return ResponseResult.success(scrapService.getScrapLine(DateStringInList.get(0),DateStringInList.get(6),lineName,type));

        }catch (Exception e){
            logger.error("-------------getDownTime Error--------"+e);
        }


        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }



    /**
     *
     *Scrap Week Device
     */
    @RequestMapping(value = "getScrapWeek",method = RequestMethod.GET)
    public ResponseResult getScrapWeek(Integer year,Integer weekNo,String line,String device)  {

        try{

            return ResponseResult.success(scrapService.getScrapWeek(year,weekNo,line,device));

        }catch (Exception e){
            logger.error("-------------getDownTime Error--------"+e);
        }

        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }














}
