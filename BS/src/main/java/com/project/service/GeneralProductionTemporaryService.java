package com.project.service;

import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.model.AppConsts;
import com.project.domain.entity.GeneralImpressive;
import com.project.domain.entity.GeneralProductionTemporary;
import com.project.domain.entity.ScrapValue;
import com.project.domain.model.input.GeneralProductionTemporaryInput;
import com.project.domain.model.output.GeneralProductionTemporaryOutput;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

@Service
public class GeneralProductionTemporaryService  extends AbstractService <GeneralProductionTemporaryInput,GeneralProductionTemporaryOutput> {


    private final String generalName = AppConsts.GeneralProductionTemporaryName;
    private String mapperName = generalName;

    @Override
    public String getMapperName() {
        return mapperName;
    }


    public void setMapperName(String mapperName) {
        this.mapperName = mapperName;
    }


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


    /**
     * addall no matter how many days
     *
     * @param input
     * @return
     * @throws Exception
     */
    public boolean addnewhalt(GeneralProductionTemporaryInput input, String line, String device) throws Exception {

        String replaceName = line + device;
        this.setMapperName(AppConsts.GeneralProductionTemporaryName.replace("General", replaceName));


        if (input.getTemporaryId() == null || input.getTemporaryId().equals("")) {
            input.setTemporaryId(super.getGUID());
        }


        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        Date startDate = (input.getStartDateTime());
        Date endDate = input.getEndDateTime();


        String startDateString = sdf.format(startDate);
        String endDateString = sdf.format(endDate);


        Date startDateWithoutTime = sdf.parse(startDateString);
        Date endDateWithoutTime = sdf.parse(endDateString);


        //days for judging startDate and endDate is in same day or not;
        Integer days = (int) ((endDateWithoutTime.getTime() - startDateWithoutTime.getTime()) / (1000 * 3600 * 24));


        Integer startrecordno = input.getStartRecord();
        Integer endrecordno = input.getEndRecord();

        List<GeneralProductionTemporaryInput> list = new ArrayList<>();
        if (days == 0) {
            //1 same day
            Integer times = (endrecordno - startrecordno); //records
            for (int j = 0; j < times; j++) {
                Integer r = startrecordno;
                r += j;
                GeneralProductionTemporaryInput input4list = new GeneralProductionTemporaryInput();
                input4list.setTemporaryId(super.getGUID());
                input4list.setRecordno(r);
                input4list.setDateString(startDateString);
                input4list.setIsProduction(0);
                input4list.setMark(0);


                list.add(input4list);
            }
        } else if (days == 1) {
            //2 days
            Integer times = (96 - startrecordno);
            for (int j = 0; j < times; j++) {
                Integer r = startrecordno;
                r += j;
                GeneralProductionTemporaryInput input4list = new GeneralProductionTemporaryInput();
                input4list.setTemporaryId(super.getGUID());
                input4list.setRecordno(r);
                input4list.setDateString(startDateString);
                input4list.setIsProduction(0);
                input4list.setMark(0);


                list.add(input4list);
            }
            for (int k = 0; k < endrecordno; k++) {
                Integer r = 1;
                r += k;
                GeneralProductionTemporaryInput input4list = new GeneralProductionTemporaryInput();
                input4list.setTemporaryId(super.getGUID());
                input4list.setRecordno(r);
                Calendar calstart = Calendar.getInstance();
                calstart.setTime(startDate);
                calstart.add(Calendar.DAY_OF_WEEK, 1);
                String startDateStringAdd = sdf.format(calstart.getTime());
                input4list.setDateString(startDateStringAdd);
                input4list.setIsProduction(0);
                input4list.setMark(0);


                list.add(input4list);
            }

        } else {
            //more than 2 days
            Integer times = (96 - startrecordno) + 1;
            for (int j = 0; j < times; j++) {
                Integer r = startrecordno;
                r += j;
                GeneralProductionTemporaryInput input4list = new GeneralProductionTemporaryInput();
                input4list.setTemporaryId(super.getGUID());
                input4list.setRecordno(r);
                input4list.setDateString(startDateString);
                input4list.setIsProduction(0);
                input4list.setMark(0);

                list.add(input4list);
            }

            for (int l = 0; l < days - 1; l++) {

                for (int m = 0; m < 96; m++) {

                    Integer r = 1;
                    r += l;
                    GeneralProductionTemporaryInput input4list = new GeneralProductionTemporaryInput();
                    input4list.setTemporaryId(super.getGUID());
                    input4list.setRecordno(r);
                    Calendar calstart = Calendar.getInstance();
                    calstart.setTime(startDate);
                    calstart.add(Calendar.DAY_OF_WEEK, l + 1);
                    String startDateStringAdd = sdf.format(calstart.getTime());
                    input4list.setDateString(startDateStringAdd);
                    input4list.setIsProduction(0);
                    input4list.setMark(0);


                    list.add(input4list);
                }


            }
            for (int k = 0; k < endrecordno; k++) {
                Integer r = 0;
                r += k;
                GeneralProductionTemporaryInput input4list = new GeneralProductionTemporaryInput();
                input4list.setTemporaryId(super.getGUID());
                input4list.setRecordno(r);
                Calendar calstart = Calendar.getInstance();
                calstart.setTime(startDate);
                calstart.add(Calendar.DAY_OF_WEEK, days);
                String startDateStringAdd = sdf.format(calstart);
                input4list.setDateString(startDateStringAdd);
                input4list.setIsProduction(0);
                input4list.setMark(0);   //mark for be able to queried  to sync

                list.add(input4list);
            }
        }


        Boolean flag = false;
        for (GeneralProductionTemporaryInput g : list) {

            // repeat control?
            PageData checkRepeat = new PageData();
            checkRepeat.put("DateString",g.getDateString());
            checkRepeat.put("RecordNO",g.getRecordno().toString());
          List<GeneralProductionTemporary> checkList =   this.generallist(false,checkRepeat,line,device);
            if(checkList.size()>0){
                continue;
            }


            int isDeleted = 0;
            PageData pageData = super.poToMap(g);
            pageData.put("createdUserId", this.WorkContext.getUserId());
            pageData.put("createdUserName", this.WorkContext.getName());
            pageData.put("createdTime", this.getNowTime());
            pageData.put("lastUpdatedUserId", this.WorkContext.getUserId());
            pageData.put("lastUpdatedUserName", this.WorkContext.getName());
            pageData.put("lastUpdatedDateTime", this.getNowTime());
            pageData.put("isDeleted", isDeleted);
            if (daoImp.save(mapperName + "insertSelective", pageData) > 0) {
                flag = true;
            } else {
                flag = false;
            }


        }
        return flag;
    }


    /**
     * Stop function
     * date > stopDate
     * record>stopRecord
     *
     * @param line
     * @param device
     * @param stopDate
     * @return
     * @throws Exception
     */
    public boolean stopProduction(String line, String device, Date stopDate, Integer stopRecord) throws Exception {
        String replaceName = line + device;
        this.setMapperName(AppConsts.GeneralProductionTemporaryName.replace("General", replaceName));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String DateString = sdf.format(stopDate);

        PageData pageData = new PageData();
        pageData.put("DateString", DateString);
        pageData.put("RecordNO", stopRecord.toString());
        if (daoImp.delete(mapperName + "stopProduction", pageData) > 0) {
            return true;
        } else {
            return false;
        }


    }

    /**
     * @return
     * @throws Exception
     */
    public boolean ifShiftInProduction(String line, String device, String dateString, String shiftName) throws Exception {

        String replaceName = line + device;
        this.setMapperName(AppConsts.GeneralProductionTemporaryName.replace("General", replaceName));


        String inList = "";
        PageData pageData = new PageData();
        pageData.put("DateString",dateString);
        if (shiftName != null) {

            Integer[] shift = null;
            if (shiftName.equals("SHIFT1")) {
                shift = AppConsts.shift1;
            } else if (shiftName.equals("SHIFT2")) {
                shift = AppConsts.shift2;
            } else if (shiftName.equals("SHIFT3")) {
                shift = AppConsts.shift3;
            } else {
                return false;
            }
            for (int i = 0; i <= shift[1] - shift[0]; i++) {
                inList += "'";

                inList += (shift[0] + i);
                inList += "'";
                if (i <= (shift[1] - shift[0]) - 1) {
                    inList += ",";
                }
            }

            pageData.put("inList",inList);


        }
        List<GeneralProductionTemporary> quertList  =  this.generallist(false,pageData,line,device);


        if(quertList.size()>=1){
            return true;
        }

        return false;

    }










    /**
     * LIST
     * @param isPager
     * @param pageData
     * @return
     * @throws Exception
     */
    public List<GeneralProductionTemporary> generallist(boolean isPager, PageData pageData,String line, String device) throws Exception {
        String replaceName =line+device;
        this.setMapperName(AppConsts.GeneralProductionTemporaryName.replace("General",replaceName));
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

        if(pageData.containsKey("DateStringInList")){
            sb.append(" AND Date_String in ("+pageData.getMap().get("DateStringInList")+")");
        }

        if (pageData.containsKey("NoMark")) {
            sb.append(" AND mark != "  + pageData.getMap().get("NoMark"));
        }


        sb.append(new PageData().where(pageData));
        if (isPager) {

            Integer pagesize = pageData.getRows();
            Integer page = pageData.getPageIndex();
            PageHelper.startPage(page, pagesize);
            PageData sqlModel = new PageData();
            sqlModel.put("retrieveSql",sb.toString());
            Page<GeneralProductionTemporary> dataList = (Page<GeneralProductionTemporary>) daoImp.findForListSql(mapperName + "list",sqlModel);

            return dataList;
        }
        PageData sqlModel = new PageData();
        sqlModel.put("retrieveSql", sb.toString());
        return (List<GeneralProductionTemporary>) daoImp.findForListSql(mapperName+"list",sqlModel);
    }













    /**
     * impressiveList
     * @param isPager
     * @param pageData
     * @return
     * @throws Exception
     */
    public List<GeneralImpressive> impressiveList(boolean isPager, PageData pageData, String line, String device) throws Exception {
        String replaceName =line+device;
        this.setMapperName(AppConsts.GeneralProductionTemporaryName.replace("General",replaceName));
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


        if(pageData.containsKey("inList")){
            sb.append(" AND RecordNO in ("+pageData.getMap().get("inList")+")");
        }

        if(pageData.containsKey("DateStringInList")){
            sb.append(" AND Date_String in ("+pageData.getMap().get("DateStringInList")+")");
        }

        if (pageData.containsKey("NoMark")) {
            sb.append(" AND mark != "  + pageData.getMap().get("NoMark"));
        }

        sb.append(new PageData().where(pageData));
        if (isPager) {

            Integer pagesize = pageData.getRows();
            Integer page = pageData.getPageIndex();
            PageHelper.startPage(page, pagesize);
            PageData sqlModel = new PageData();
            sqlModel.put("retrieveSql",sb.toString());
            Page<GeneralImpressive> dataList = (Page<GeneralImpressive>) daoImp.findForListSql(mapperName + "impressive",sqlModel);

            return dataList;
        }
        PageData sqlModel = new PageData();
        sqlModel.put("retrieveSql", sb.toString());
        return (List<GeneralImpressive>) daoImp.findForListSql(mapperName+"impressive",sqlModel);
    }











    /**
     * After syn update mark
     * @param mark
     * @return
     * @throws Exception
     */

    public boolean updateMark(Integer mark,String pkId,String line,String device) throws  Exception{
        String replaceName =line+"_"+device;
        this.setMapperName(AppConsts.GeneralProductionTemporaryName.replace("General",replaceName));
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

    public GeneralProductionTemporary findByDateRecord(String DateString, Integer recordNO, String device) throws  Exception{
        this.setMapperName(AppConsts.GeneralProductionTemporaryName.replace("General",device));
        PageData pageData = new PageData();
        pageData.put("DateString",DateString);
        pageData.put("RecordNO",recordNO.toString());


        return (GeneralProductionTemporary) daoImp.findForObject(mapperName+"findByDateRecord",pageData);

    }





    @Test
    public  List<String>  getTableName(){
        Connection connection = null;
        try {

            //get driver
            Class.forName(DRIVER_NAME);
            //get connection
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            //sql
            String sql ="";

            String param = "";

            sql ="select name from sys.tables where name like '%production_temporary%'";

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








    /**
     * get oee week
     * @param weekNo
     * @return
     * @throws Exception
     */

    public  List<Integer> getWeekOeeTarget(Integer year,Integer weekNo,String line,String device) throws Exception {

        PageData pageData = new PageData();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,year);
        cal.set(Calendar.WEEK_OF_YEAR,weekNo);
        cal.set(Calendar.DAY_OF_WEEK, 2);//monday 2
        Date date = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String datestring = sdf.format(date);
        String DateStringInList = "";          //in list

        List<String> DateStringList =  new ArrayList<>();
        for(int i =1;i<=7;i++){
            Calendar calstart = Calendar.getInstance();
            calstart.setTime(date);
            calstart.add(Calendar.DAY_OF_WEEK, (i-1));
            String dateStringAdd =sdf.format(calstart.getTime());
            DateStringInList+=dateStringAdd;
            DateStringList.add(dateStringAdd);
            if(i<7){
                DateStringInList+=",";
            }

        }
        pageData.put("DateStringInList",DateStringInList);

        List<GeneralProductionTemporary> productionList = (List<GeneralProductionTemporary>) this.generallist(false,pageData,line,device);


        Map<Integer,String> map = new HashMap<Integer,String>();
        List<Integer> ordersFull = new ArrayList<>();
        List<Integer> orders = new ArrayList<>();
        List<Integer> resultOrders = new ArrayList<>();
        List<Integer> outList = new ArrayList<>();
        for(int i =0;i<productionList.size();i++){


            for(int j= 0;j<7;j++){

                String a = productionList.get(i).getDateString();
                String b = DateStringList.get(j);
                if(a.equals(b)){

                    Integer recordNo =   productionList.get(i).getRecordno();

                    Integer shiftAdd = 0;

                    if(recordNo<=32){
                        shiftAdd= 0;
                    }else if(recordNo<=64){
                        shiftAdd= 1;
                    }else if(recordNo<=96){
                        shiftAdd= 2;
                    }

                    Integer order = j*3+shiftAdd;
                    orders.add(order);

                }

            }

        }

        for(int i =0;i<21;i++){
            ordersFull.add(i);
            outList.add(85);
        }

        for(Integer o:ordersFull){
            if(!orders.contains(o)){
                resultOrders.add(o);
            }
        }

        for(Integer ro :resultOrders){
            Integer index =  ro;
            outList.set(index,0);
        }



        return outList;

    }

















}
