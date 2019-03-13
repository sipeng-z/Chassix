package com.project.controller;


import com.project.service.G38ASSYOEEDataService;
import com.project.service.G38ASSYOEEDataTemporaryService;
import com.project.service.G38ASSYShiftService;
import com.response.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;


@Component

public class G38Timing {

    private final Logger logger = LoggerFactory.getLogger(G38Timing.class);

    @Autowired
   private G38ASSYShiftService  g38ASSYShiftService;

    @Autowired
    private G38TimingImpl g38TimingTest;

    @Autowired
    private G38ASSYOEEDataService g38ASSYOEEDataService;

    @Autowired
    private G38ASSYOEEDataTemporaryService g38ASSYOEEDataTemporaryService;



    public final static long ONE_Minute =  60 * 1000;
    public final static long FIFTEEN_Minute =  900 * 1000;
    public final static long SIXTEEN_Minute =  960 * 1000;

//
//    @Scheduled(fixedDelay=SIXTEEN_Minute)
    public void fixedDelayJob(){
        System.out.println((new Date())+" >>G38 Tem sync do....");


        try{

           ResponseResult assyresult = g38TimingTest.assyTemTiming();
            if(assyresult.isSuccess()==true){
                logger.info("SUCCESS! SYN! ASSY TEM!");
            }
            ResponseResult v21result = g38TimingTest.v21TemTiming();
            if(v21result.isSuccess()==true){
                logger.info("SUCCESS! SYN! V21 TEM!");
            }
            ResponseResult v22result = g38TimingTest.v22TemTiming();
            if(v22result.isSuccess()==true){
                logger.info("SUCCESS! SYN! V22 TEM!");
            }
            ResponseResult v23result = g38TimingTest.v23TemTiming();
            if(v23result.isSuccess()==true){
                logger.info("SUCCESS! SYN! V23 TEM!");
            }

        }catch (Exception e){
            logger.error("----------- DELAY  ERROR-------" + e);
        }


    }


//    @Scheduled(fixedRate=FIFTEEN_Minute)
    public void fixedRateJob() {

    try{

      ResponseResult result =  g38TimingTest.assyShiftTiming();
      if(result.isSuccess()==true){
          logger.info("SUCCESS! SYN! ASSY SHIFT");
      }else {
          logger.error("ERROR !SYN! ASSY SHIFT ");
      }

      ResponseResult v21result = g38TimingTest.v21ShiftTiming();
      if(v21result.isSuccess()==true){
          logger.info("SUCCESS! SxYN! V21 SHIFT");
      }else {
          logger.error("ERROR !SYN! V21 SHIFT ");
      }


        ResponseResult v22result = g38TimingTest.v22ShiftTiming();
        if(v22result.isSuccess()==true){
            logger.info("SUCCESS! SYN! V22 SHIFT");
        }else {
            logger.error("ERROR !SYN! V22 SHIFT ");
        }




        ResponseResult v23result = g38TimingTest.v23ShiftTiming();
        if(v23result.isSuccess()==true){
            logger.info("SUCCESS! SYN! V23 SHIFT");
        }else {
            logger.error("ERROR !SYN! V23 SHIFT ");
        }


    }catch (Exception e){
        logger.error("  RATE  ERROR ");
    }



    }

//
//    @Scheduled(cron="0 15 3 * * ?")
//    public void cronJob(){
//        System.out.println((new Date())+" >>cron执行....");
//    }






}
