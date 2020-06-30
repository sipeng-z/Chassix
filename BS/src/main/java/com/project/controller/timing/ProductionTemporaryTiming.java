package com.project.controller.timing;


import com.core.dao.imp.DaoImp;
import com.domain.model.PageData;
import com.model.AppConsts;
import com.project.domain.entity.GeneralOEEData;
import com.project.domain.entity.GeneralProductionTemporary;
import com.project.domain.model.output.GeneralOEEDataOutput;
import com.project.service.GeneralProductionTemporaryService;
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
@RequestMapping(value = "ProductionTiming")
public class ProductionTemporaryTiming {

    @Autowired
    private GeneralProductionTemporaryService generalProductionTemporaryService;

    @Autowired
    protected DaoImp daoImp;

    private final Logger logger = LoggerFactory.getLogger(ProductionTemporaryTiming.class);

    public final static long ONE_Minute =  60 * 1000;
    public final static long FIFTEEN_Minute =  900 * 1000;
    public final static long SIXTEEN_Minute =  960 * 1000;


    @Scheduled(fixedRate=FIFTEEN_Minute)
    @RequestMapping(value = "ProductionTemporary",method = RequestMethod.GET)
    public void fixedRateJob() {
        System.out.println((new Date())+" >>Production_temporary  ....");
        try{
            //sync content
            List<String> tableNames = generalProductionTemporaryService.getTableName();
            for(String s : tableNames){
                PageData pageData = new PageData();
                pageData.put("mark","0");
                Integer a = s.indexOf("_Production_Temporary");

                String[] lineDevice = (s.substring(0,a).split("_"));
                String lineAndDevice = lineDevice[0]+lineDevice[1];

                String MapperName  = AppConsts.GeneralOEEDataName.replace("General",lineAndDevice);
                String ProductionMapperName  = AppConsts.GeneralProductionTemporaryName.replace("General",lineAndDevice);

                List<GeneralProductionTemporary>  queryList = (List<GeneralProductionTemporary>)generalProductionTemporaryService.generallist(false,pageData,lineDevice[0],lineDevice[1]);

                for(GeneralProductionTemporary q :queryList ){
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
                        inputPageData.put("mark","1");    // production sync 0  --> 1 ; downtime calculation sync 1 --> 3
                       Integer updateResult =  daoImp.update(MapperName+"updateByItemno",inputPageData); //update oee data
                        if (updateResult>=0){

                            //update production data
                           PageData temporaryMark = new PageData();
                            temporaryMark.put("temporaryId",temporaryId);
                            temporaryMark.put("mark","1");

                            Integer updateProduction =  daoImp.update(ProductionMapperName+"updateByTemporaryId",temporaryMark);

                        }else {
                            logger.error("  RATE FOR PRODUCTION TEMPORARY  ERROR OEE SYNC "+lineAndDevice);
                        }
                    }
                }
            }
            logger.info("RATE FOR PRODUCTION SUCCESS");
        }catch (Exception e){
            logger.error("  RATE FOR PRODUCTION TEMPORARY  ERROR  ");
        }


    }




}
