package com.project.service;

import com.project.domain.entity.GeneralOEEDataTemporary;
import com.project.domain.model.input.GeneralOEEDataTemporaryInput;
import com.project.domain.model.output.GeneralOEEDataTemporaryOutput;
import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.model.AppConsts;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class GeneralOEEDataTemporaryService extends AbstractService<GeneralOEEDataTemporaryInput,GeneralOEEDataTemporaryOutput> {

    private final String generalName = AppConsts.GeneralOEEDataTemporaryName;
    private String mapperName = generalName;


    @Override
    public String getMapperName(){
        return mapperName;
    }

    public void setMapperName(String mapperName){
        this.mapperName = mapperName;
    }


    //sqlserver驱动包名
    private static final String DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    //用户名
    @Value("${new.dbo.url}")
    private String URL;

    //数据库连接地址
    @Value("${dbo.user_name}")
    private String USER_NAME;
    //密码
    @Value("${dbo.password}")
    private String PASSWORD;








    /**
     * addall no matter how many days
     *
     * @param input
     * @return
     * @throws Exception
     */
    public boolean addnewhalt(GeneralOEEDataTemporaryInput input,String line,String device) throws Exception {

       this.setMapperName(AppConsts.GeneralOEEDataTemporaryName.replace("General",line+device));
        Integer type = input.getType();

        if (input.getTemporaryId() == null || input.getTemporaryId().equals("")) {
            input.setTemporaryId(super.getGUID());
        }


        Date startDate = input.getStartDateTime();
        Date endDate = input.getEndDateTime();

        String description = input.getDescription();

        //days for judging startDate and endDate is in same day or not;
        Integer days = (int) ((endDate.getTime() - startDate.getTime()) / (1000 * 3600 * 24));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String startDateString = sdf.format(startDate);
        String endDateString = sdf.format(endDate);

        Integer startrecordno = (input.getStartRecord() + startDate.getHours() * 4);
        Integer endrecordno = (input.getEndRecord() + endDate.getHours() * 4);

        List<GeneralOEEDataTemporaryInput> list = new ArrayList<>();
        if (days == 0) {
            //1 same day
            Integer times = (endrecordno - startrecordno) + 1;
            for (int j = 0; j < times; j++) {
                Integer r = startrecordno;
                r += j;
                GeneralOEEDataTemporaryInput input4list = new GeneralOEEDataTemporaryInput();
                input4list.setTemporaryId(super.getGUID());
                input4list.setRecordno(r);
                input4list.setDateString(startDateString);
                input4list.setIsProduction(1);
                input4list.setMark(0);
                input4list.setDescription(description);

                if(type==0){
                    input4list.setPreventiveMaintenance(900);
                }else if(type==1) {
                    input4list.setSetupPreoaration(900);
                }else if(type==2){
                    input4list.setChangeOvers(900);
                }else {
                    input4list.setUnplannedDowntime(900);
                }
                list.add(input4list);
            }
        }else if(days==1) {
            //2 days
            Integer times = (96 - startrecordno) + 1;
            for (int j = 0; j < times; j++) {
                Integer r = startrecordno;
                r += j;
                GeneralOEEDataTemporaryInput input4list = new GeneralOEEDataTemporaryInput();
                input4list.setTemporaryId(super.getGUID());
                input4list.setRecordno(r);
                input4list.setDateString(startDateString);
                input4list.setIsProduction(1);
                input4list.setMark(0);
                input4list.setDescription(description);
                if(type==0){
                    input4list.setPreventiveMaintenance(900);
                }else if(type==1) {
                    input4list.setSetupPreoaration(900);
                }else if(type==2){
                    input4list.setChangeOvers(900);
                }else {
                    input4list.setUnplannedDowntime(900);
                }
                list.add(input4list);
            }
            for(int k=0;k<endrecordno;k++) {
                Integer r = 1;
                r+=k;
                GeneralOEEDataTemporaryInput input4list = new GeneralOEEDataTemporaryInput();
                input4list.setTemporaryId(super.getGUID());
                input4list.setRecordno(r);
                Calendar calstart = Calendar.getInstance();
                calstart.setTime(startDate);
                calstart.add(Calendar.DAY_OF_WEEK, 1);
                String startDateStringAdd =sdf.format(calstart);
                input4list.setDateString(startDateStringAdd);
                input4list.setIsProduction(1);
                input4list.setMark(0);
                input4list.setDescription(description);
                if(type==0){
                    input4list.setPreventiveMaintenance(900);
                }else if(type==1) {
                    input4list.setSetupPreoaration(900);
                }else if(type==2){
                    input4list.setChangeOvers(900);
                }else {
                    input4list.setUnplannedDowntime(900);
                }
                list.add(input4list);
            }

        }else {
            //more than 2 days
            Integer times = (96 - startrecordno) + 1;
            for (int j = 0; j < times; j++) {
                Integer r = startrecordno;
                r += j;
                GeneralOEEDataTemporaryInput input4list = new GeneralOEEDataTemporaryInput();
                input4list.setTemporaryId(super.getGUID());
                input4list.setRecordno(r);
                input4list.setDateString(startDateString);
                input4list.setIsProduction(1);
                input4list.setMark(0);
                input4list.setDescription(description);
                if(type==0){
                    input4list.setPreventiveMaintenance(900);
                }else if(type==1) {
                    input4list.setSetupPreoaration(900);
                }else if(type==2){
                    input4list.setChangeOvers(900);
                }else {
                    input4list.setUnplannedDowntime(900);
                }
                list.add(input4list);
            }

            for(int l=0;l<days-1;l++){

                for(int m=0;m<96;m++){

                    Integer r = 1;
                    r+=l;
                    GeneralOEEDataTemporaryInput input4list = new GeneralOEEDataTemporaryInput();
                    input4list.setTemporaryId(super.getGUID());
                    input4list.setRecordno(r);
                    Calendar calstart = Calendar.getInstance();
                    calstart.setTime(startDate);
                    calstart.add(Calendar.DAY_OF_WEEK, l+1);
                    String startDateStringAdd =sdf.format(calstart);
                    input4list.setDateString(startDateStringAdd);
                    input4list.setIsProduction(1);
                    input4list.setMark(0);
                    input4list.setDescription(description);
                    if(type==0){
                        input4list.setPreventiveMaintenance(900);
                    }else if(type==1) {
                        input4list.setSetupPreoaration(900);
                    }else if(type==2){
                        input4list.setChangeOvers(900);
                    }else {
                        input4list.setUnplannedDowntime(900);
                    }
                    list.add(input4list);
                }



            }
            for(int k=0;k<endrecordno;k++) {
                Integer r = 0;
                r+=k;
                GeneralOEEDataTemporaryInput input4list = new GeneralOEEDataTemporaryInput();
                input4list.setTemporaryId(super.getGUID());
                input4list.setRecordno(r);
                Calendar calstart = Calendar.getInstance();
                calstart.setTime(startDate);
                calstart.add(Calendar.DAY_OF_WEEK, days);
                String startDateStringAdd =sdf.format(calstart);
                input4list.setDateString(startDateStringAdd);
                input4list.setIsProduction(1);
                input4list.setMark(0);
                input4list.setDescription(description);
                if(type==0){
                    input4list.setPreventiveMaintenance(900);
                }else if(type==1) {
                    input4list.setSetupPreoaration(900);
                }else if(type==2){
                    input4list.setChangeOvers(900);
                }else {
                    input4list.setUnplannedDowntime(900);
                }
                list.add(input4list);
            }
        }


        Boolean flag = false;
        for(GeneralOEEDataTemporaryInput g: list){

            int isDeleted=0;
            PageData pageData = super.poToMap(g);
            pageData.put("createdUserId",this.WorkContext.getUserId());
            pageData.put("createdUserName",this.WorkContext.getName());
            pageData.put("createdDateTime",this.getNowTime());
            pageData.put("lastUpdatedUserId",this.WorkContext.getUserId());
            pageData.put("lastUpdatedUserName",this.WorkContext.getName());
            pageData.put("lastUpdatedDateTime",this.getNowTime());
            pageData.put("isDeleted", AppConsts.IsDelete_No);
            pageData.put("auditState",AppConsts.Audit_Default);
            pageData.put("isDeleted",isDeleted);
            if(daoImp.save(mapperName+"insertSelective",pageData)>0){
                flag = true;
            }else {
                flag = false;
            }

        }
        return flag;
    }

    /**
     * make break and lunch time be fixed in a week ;
     * @param yearNo
     * @param weekNo
     * @return
     */
    public boolean fixLnB (Integer yearNo,Integer weekNo ,String line,String device) throws Exception{
       this.setMapperName(AppConsts.GeneralOEEDataTemporaryName.replace("General",line+device));
        //weekNo , yearNo to  get monday date
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,yearNo);
        cal.set(Calendar.WEEK_OF_YEAR, weekNo);
        cal.set(Calendar.DAY_OF_WEEK, 2);
        Date date = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");



        for(int i=0;i<7;i++){
            Calendar calstart = Calendar.getInstance();
            calstart.setTime(date);
            calstart.add(Calendar.DAY_OF_WEEK, (i));
            String dateStringAdd =sdf.format(calstart.getTime());
            int[] LnB = new int[]{47,48};

            GeneralOEEDataTemporaryInput input4L = new GeneralOEEDataTemporaryInput();

            input4L.setTemporaryId(super.getGUID());
            input4L.setDateString(dateStringAdd);
            input4L.setRecordno(LnB[0]);
            input4L.setLunchTime(900);
            input4L.setRunningTime(0);
            input4L.setPlannedRunTime(0);
            input4L.setMark(0);


            super.add(input4L);

            GeneralOEEDataTemporaryInput input4B = new GeneralOEEDataTemporaryInput();
            input4B.setTemporaryId(super.getGUID());
            input4B.setDateString(dateStringAdd);
            input4B.setRecordno(LnB[1]);
            input4B.setBreakTime(900);
            input4B.setRunningTime(0);
            input4B.setPlannedRunTime(0);
            input4B.setMark(0);
            super.add(input4B);


            Boolean flagL =false;
            Boolean flagB =false;
            int isDeleted=0;
            PageData pageData = super.poToMap(input4L);
            pageData.put("createdUserId",this.WorkContext.getUserId());
            pageData.put("createdUserName",this.WorkContext.getName());
            pageData.put("createdDateTime",this.getNowTime());
            pageData.put("lastUpdatedUserId",this.WorkContext.getUserId());
            pageData.put("lastUpdatedUserName",this.WorkContext.getName());
            pageData.put("lastUpdatedDateTime",this.getNowTime());
            pageData.put("isDeleted", AppConsts.IsDelete_No);
            pageData.put("auditState",AppConsts.Audit_Default);
            pageData.put("isDeleted",isDeleted);
            if(daoImp.save(mapperName+"insertSelective",pageData)>0){
                flagL = true;
            }else {
                flagL = false;
            }

            PageData pageData2 = super.poToMap(input4B);
            pageData2.put("createdUserId",this.WorkContext.getUserId());
            pageData2.put("createdUserName",this.WorkContext.getName());
            pageData2.put("createdDateTime",this.getNowTime());
            pageData2.put("lastUpdatedUserId",this.WorkContext.getUserId());
            pageData2.put("lastUpdatedUserName",this.WorkContext.getName());
            pageData2.put("lastUpdatedDateTime",this.getNowTime());
            pageData2.put("isDeleted", AppConsts.IsDelete_No);
            pageData2.put("auditState",AppConsts.Audit_Default);
            pageData2.put("isDeleted",isDeleted);
            if(daoImp.save(mapperName+"insertSelective",pageData2)>0){
                flagB = true;
            }else {
                flagB = false;
            }
        }
        return true;
    }

    /**
     * LIST
     * @param isPager
     * @param pageData
     * @return
     * @throws Exception
     */
    public List<GeneralOEEDataTemporaryOutput> generallist(boolean isPager, PageData pageData,String line, String device) throws Exception {
       this.setMapperName(AppConsts.GeneralOEEDataTemporaryName.replace("General",line+device));
        StringBuilder sb = new StringBuilder();
        if (pageData.containsKey("DateString")) {
            sb.append(" AND Date_String = " + "'" + pageData.getMap().get("DateString") + "'");
        }
        if (pageData.containsKey("Description")) {
            sb.append(" AND Description like " + "'%" + pageData.getMap().get("Description") + "%'");
        }
        if (pageData.containsKey("RecordNO")) {
            sb.append(" AND RecordNO = " + "'" + pageData.getMap().get("RecordNO") + "'");
        }
        if(pageData.containsKey("inList")){
            sb.append("AND RecordNO in ("+pageData.getMap().get("inList")+")");
        }

        if (pageData.containsKey("mark")) {
            sb.append(" AND mark = "  + pageData.getMap().get("mark"));
        }


        if (pageData.containsKey("NoMark")) {
            sb.append(" AND mark != "  + pageData.getMap().get("NoMark"));
        }


        sb.append(new PageData().where(pageData));
        if (isPager) {
            return super.pageList(pageData, mapperName + "list", sb.toString());
        }
        PageData sqlModel = new PageData();
        sqlModel.put("retrieveSql", sb.toString());
        return (List<GeneralOEEDataTemporaryOutput>) daoImp.findForListSql(mapperName+"list",sqlModel);
    }

    /**
     * After syn update mark
     * @param mark
     * @return
     * @throws Exception
     */

    public boolean updateMark(Integer mark,String pkId,String line,String device) throws  Exception{
       this.setMapperName(AppConsts.GeneralOEEDataTemporaryName.replace("General",line+device));
        PageData pageData = new PageData();
        pageData.put("mark",""+mark+"");
        pageData.put("temporaryId",pkId);

        if(daoImp.update(mapperName+"updateMark",pageData)>0){
            return true;
        }
        return false;

    }

    /**
     * get one by date / record
     * @param
     * @return
     * @throws Exception
     */

    public GeneralOEEDataTemporary findByDateRecord(String DateString, Integer recordNO,String line, String device) throws  Exception{
       this.setMapperName(AppConsts.GeneralOEEDataTemporaryName.replace("General",line+device));
        PageData pageData = new PageData();
        pageData.put("DateString",DateString);
        pageData.put("RecordNO",recordNO.toString());
        return (GeneralOEEDataTemporary) daoImp.findForObject(mapperName+"findByDateRecord",pageData);
    }
    public  List<String>  getTableNameOeeDataTemporary(){
        Connection connection = null;
        try {
            //get driver
            Class.forName(DRIVER_NAME);
            //get connection
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            //sql
            String sql ="";
            String param = "";
            sql ="select name from sys.tables where name like '%oee_data_temporary%'"; //downtime inputs by production
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
