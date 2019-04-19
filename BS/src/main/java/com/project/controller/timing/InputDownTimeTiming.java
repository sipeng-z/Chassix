package com.project.controller.timing;


import com.core.dao.imp.DaoImp;
import com.domain.model.PageData;
import com.model.AppConsts;
import com.project.domain.entity.GeneralOEEData;
import com.project.domain.entity.GeneralOEEDataTemporary;

import com.project.domain.model.output.GeneralOEEDataOutput;
import com.project.domain.model.output.GeneralOEEDataTemporaryOutput;

import com.project.service.GeneralOEEDataTemporaryService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(value = "InputDownTimeTiming")
public class InputDownTimeTiming {


    @Autowired
    private GeneralOEEDataTemporaryService generalOEEDataTemporaryService;

    @Autowired
    protected DaoImp daoImp;



    private final Logger logger = LoggerFactory.getLogger(InputDownTimeTiming.class);


    public final static long SIXTEEN_Minute =  960 * 1000;

//    @Scheduled(fixedRate=SIXTEEN_Minute)
    @RequestMapping(value = "InputDownTimeTemporary",method = RequestMethod.GET)
    public void fixedRateJob() {
        System.out.println((new Date())+" >>inputs down time temporary  ....");
        try{
            //sync content
            List<String> tableNames = generalOEEDataTemporaryService.getTableNameOeeDataTemporary();
            for(String s : tableNames){
                PageData pageData = new PageData();
                pageData.put("mark","0");
                Integer a = s.indexOf("_OEE_Data_Temporary");

                String[] lineDevice = (s.substring(0,a).split("_")); //get line name and device name
                String lineAndDevice = lineDevice[0]+lineDevice[1];

                String MapperName  = AppConsts.GeneralOEEDataName.replace("General",lineAndDevice);
                String DownTimeMapperName  = AppConsts.GeneralOEEDataTemporaryName.replace("General",lineAndDevice);

                List<GeneralOEEDataTemporaryOutput>  queryList = (List<GeneralOEEDataTemporaryOutput>)generalOEEDataTemporaryService.generallist(false,pageData,lineDevice[0],lineDevice[1]);


                for(GeneralOEEDataTemporary q :queryList ){

                    String DateString = q.getDateString();
                    Integer Record = q.getRecordno();
                    String temporaryId = q.getTemporaryId();

                    StringBuilder sb = new StringBuilder();

                    sb.append(" AND Date_String = "  + DateString);
                    sb.append(" AND RecordNO = "  + Record.toString());
                    PageData sqlModel = new PageData();
                    sqlModel.put("retrieveSql", sb.toString());
                    List<GeneralOEEDataOutput> timeList = (List<GeneralOEEDataOutput>) daoImp.findForListSql(MapperName+"generallist",sqlModel);

                    for(GeneralOEEData generalOEEDataOutput : timeList){
                        Integer itemno = generalOEEDataOutput.getItemno();

                        PageData inputPageData = new PageData();
                        inputPageData.put("itemno",itemno.toString());
                        inputPageData.put("plannedRunTime","900");
                        inputPageData.put("mark","1");
                        Integer updateResult =  daoImp.update(MapperName+"updateByItemno",inputPageData); //update oee data
                        if (updateResult>=0){

                            //update production data
                            PageData temporaryMark = new PageData();
                            temporaryMark.put("temporaryId",temporaryId);
                            temporaryMark.put("mark","1");

                            Integer updateProduction =  daoImp.update(DownTimeMapperName+"updateByTemporaryId",temporaryMark); //MARK DOWNTIME PLAN DATA

                        }else {
                            logger.error("  SIX MIN FOR DOWN TIME SYNC  ERROR  "+lineAndDevice);
                        }
                    }

                }


            }


            logger.info("SIX MIN FOR DOWN TIME SYNC  SUCCESS");




        }catch (Exception e){
            logger.error("  SIX MIN FOR DOWN TIME SYNC   ERROR  ");
        }


    }





}

