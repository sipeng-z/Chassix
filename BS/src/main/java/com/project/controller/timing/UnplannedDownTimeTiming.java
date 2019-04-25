package com.project.controller.timing;

import com.core.dao.imp.DaoImp;
import com.domain.model.PageData;
import com.model.AppConsts;
import com.project.domain.entity.GeneralOEEData;
import com.project.domain.model.output.GeneralOEEDataOutput;
import com.project.service.GeneralOEEDataService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(value = "ProductionTiming")

public class UnplannedDownTimeTiming {
    @Autowired
    private GeneralOEEDataService generalOEEDataService;

    @Autowired
    protected DaoImp daoImp;

    private final Logger logger = LoggerFactory.getLogger(ProductionTemporaryTiming.class);


    //sqlserver驱动包名
    private static final String DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    //用户名
    @Value("${dbo.url}")
    private String URL;

    //数据库连接地址
    @Value("${dbo.user_name}")
    private String USER_NAME;
    //密码
    @Value("${dbo.password}")
    private String PASSWORD;


    public final static long SIXTEEN_Minute = 960 * 1000;


    @Scheduled(fixedRate=SIXTEEN_Minute)
    @RequestMapping(value = "UnplannedDownTimeSync", method = RequestMethod.GET)
    public void fixedRateJob() {
        System.out.println((new Date()) + " >>Unplanned down time sync  ....");
        try {
            //sync content
            List<String> oeeDataTableName = this.getOeeDataTableName();     //G38 already

            Integer beforeCalculation = AppConsts.beforeDownTimeCalculation;    // mark = 1
            Integer afterCalculation = AppConsts.afterDownTimeCalculation;      //mark = 3
            Integer explainedDownTimeCalculation = AppConsts.explainedDownTimeCalculation;  //mark = 5   ; running normally no need to explain
            for (String s : oeeDataTableName) {
                PageData pageData = new PageData();


                pageData.put("mark", beforeCalculation.toString());
                Integer a = s.indexOf("_OEE_Data");

                String[] lineDevice = (s.substring(0, a).split("_"));
                String line = lineDevice[0];
                String device = lineDevice[1];
                String lineAndDevice = lineDevice[0] + lineDevice[1];

                String MapperName = AppConsts.GeneralOEEDataName.replace("General", lineAndDevice);


                List<GeneralOEEDataOutput> oeeQueryList = (List<GeneralOEEDataOutput>) generalOEEDataService.generalList(false, pageData, lineDevice[0], lineDevice[1]);

                for (GeneralOEEData generalOEEData : oeeQueryList) {


                    Integer itemNo = generalOEEData.getItemno();
                    Integer runningTime = generalOEEData.getRunningtime();
                    Integer plannedRunningTime = generalOEEData.getPlannedRunTime();

                    Boolean flagForUpdating = false;    // default status of updating result
                    //get running time ,if it is below planned running time for more than 1 min;
                    if (runningTime <= (plannedRunningTime - 60)) {
                        generalOEEData.setMark(afterCalculation);      // production sync 0  --> 1 ; downtime calculation sync 1 --> 3
                        generalOEEData.setDescription("NO EXPLANATION");
                        generalOEEData.setUnplannedDowntime(plannedRunningTime - runningTime);
                        flagForUpdating = generalOEEDataService.updateDownTime( generalOEEData, line, device);     //itemNO is included

                    }else {
                        //running normally
                        generalOEEData.setMark(explainedDownTimeCalculation);      // production sync 0  --> 1 ; downtime calculation sync 1 --> 3 ; if running time ok, mark =5
                        generalOEEData.setUnplannedDowntime(plannedRunningTime - runningTime);
                        flagForUpdating = generalOEEDataService.updateDownTime( generalOEEData, line, device);     //itemNO is included

                    }


                    if (flagForUpdating == true) {

                        logger.info(" Down time calculation SYNC success " +lineAndDevice+ generalOEEData.getItemno());


                    } else {
                        logger.error("  Down time calculation SYNC error " +lineAndDevice+ generalOEEData.getItemno());
                    }
                }


            }




        logger.info("DOWN TIME CALCULATION SYNC ALL FINISHED ");


    }catch( Exception e){
        logger.error("  Down time calculation SYNC ERROR INSIDE ");
    }


}








    @Test
    public  List<String>  getOeeDataTableName(){
        Connection connection = null;
        try {

            //get driver
            Class.forName(DRIVER_NAME);
            //get connection
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            //sql
            String sql ="";

            String param = "";

            sql ="select name from sys.tables where name like '%OEE_Data' and name like '%G38%'";

            PreparedStatement prst = connection.prepareStatement(sql);

            ResultSet rs = prst.executeQuery();

            Integer count = 0;
            List<String> list = new ArrayList<>();
            while (rs.next()) {
                count++;

                //GET
                String tableName = rs.getString("name");
                list.add(tableName);
            }
            rs.close();
            prst.close();

            return list;


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            return null;

        }finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }





}
