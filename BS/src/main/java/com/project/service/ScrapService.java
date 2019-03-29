package com.project.service;


import com.casting.domain.model.output.CastingCPCB7PvFurnaceChamberCurveOutput;
import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.model.AppConsts;
import com.project.domain.entity.GeneralTraceabilityData;
import com.project.domain.entity.ScrapValue;
import com.project.domain.model.output.GeneralTraceabilityDataOutput;
import com.utils.MapperName;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ScrapService  extends AbstractService<ScrapValue,ScrapValue>{





    private final String generalName = "";
    private String mapperName = generalName;

    @Override
    public String getMapperName() {
        return mapperName;
    }


    public void setMapperName(String mapperName){
        this.mapperName = mapperName;
    }


    @Autowired
    private GeneralTraceabilityDataService generalTraceabilityDataService;




    //sqlserver驱动包名
    private static final String DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver" ;
    //用户名
    @Value("${erp.url}")
    private  String URL;


    //数据库连接地址
    @Value("${erp.user_name}")
    private   String USER_NAME;
    //密码
    @Value("${erp.password}")
    private   String PASSWORD;


    /**
     * getScrap without mybatis to avoid code gbk?utf-8?unicode? >> mess
     *
     * perato
     */
    @Test
    public  List<ScrapValue>  getScrap(PageData pageData){

        Connection connection = null;
        try {
            //get driver
            Class.forName(DRIVER_NAME);
            //get connection
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            //sql
            String sql ="";

            String param = "";

            if(pageData.containsKey("entrydate")){
                param+=" AND ";
                param+= "entrydate > ";
                param+= "'"+pageData.get("entrydate")+"'";
            }

            if(pageData.containsKey("line")){
                param+=" AND ";
                param+= "itdsc like ";
                param+= "'%"+pageData.get("line")+"%'";
            }

            if(pageData.containsKey("cf")){
                param+=" AND ";
                param+= "itnbr like ";
                param+= "'%"+pageData.get("cf")+"%'";
            }



            sql ="select top 5  rsndesc , sum(quantity) as 'sum' from scrap_static_avenger  where 1=1  "+param+" group by   rsndesc  order by sum desc";

            PreparedStatement prst = connection.prepareStatement(sql);
            //结果集
            ResultSet rs = prst.executeQuery();
            String result = "";


            Integer count = 0;
            List<ScrapValue> list = new ArrayList<>();
            while (rs.next()) {
                count++;

                //GET
                String rsndesc = rs.getString("rsndesc");
                String sum =   rs.getString("sum");

                ScrapValue scrapValue = new ScrapValue();

                scrapValue.setName(rsndesc);
                scrapValue.setValue(Integer.valueOf(sum));

                list.add(scrapValue);
            }
            System.out.println("count............"+count);
            System.out.println(list);
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
     *
     * get Scrap with item no and input date
     * @param pageData
     * @return
     */
    public  List<ScrapValue>  getScrapWithName( PageData pageData){

        Connection connection = null;
        try {

            URL="jdbc:sqlserver://10.41.32.2:1433;DatabaseName=ERP_MES;";
            USER_NAME="SZ_user";
            PASSWORD="SZuser";
            //get driver
            Class.forName(DRIVER_NAME);
            //get connection
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            //sql
            String sql ="";

            String param = "";

            if(pageData.containsKey("entrydate")){
                param+=" AND ";
                param+= "entrydate > ";
                param+= "'"+pageData.get("entrydate")+"'";
            }
            sql ="select entrydate, itdsc,rsndesc ,itnbr, sum(quantity) as 'sum' from scrap_static_avenger  where 1=1 "+param+"   group by entrydate, rsndesc,itnbr,itdsc  order by entrydate , sum desc";

            PreparedStatement prst = connection.prepareStatement(sql);
            //结果集
            ResultSet rs = prst.executeQuery();

            List<CastingCPCB7PvFurnaceChamberCurveOutput> outlist = new ArrayList<>();

            Integer count = 0;
            List<ScrapValue> list = new ArrayList<>();
            while (rs.next()) {
                count++;

                //GET
                String itdsc = rs.getString("itdsc");
                String itnbr = rs.getString("itnbr");
                String rsndesc = rs.getString("rsndesc");
                String sum =   rs.getString("sum");
                String entrydate = rs.getString("entrydate");

                ScrapValue scrapValue = new ScrapValue();
                scrapValue.setName(rsndesc);
                scrapValue.setLine(itnbr+"|"+itdsc);
                scrapValue.setValue(Integer.valueOf(sum));
                scrapValue.setEntrydate(entrydate);

                list.add(scrapValue);
            }
            System.out.println("count............"+count);
            System.out.println(list);
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
     *
     * get Scrap
     *
     * @param startDate and endDate and lineName
     * @return
     */
    public  List<ScrapValue>  getScrapLine(String startDate, String endDate, String lineName,String type){

        Connection connection = null;
        try {

              URL="jdbc:sqlserver://10.41.32.2:1433;DatabaseName=ERP_MES;";
              USER_NAME="SZ_user";
              PASSWORD="SZuser";
            //get driver
            Class.forName(DRIVER_NAME);
            //get connection
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            //sql
            String sql ="";

            String param = "";

            if(startDate!=null&&!startDate.equals("")&&endDate!=null&&!endDate.equals("")){
                param+=" AND ";
                param+= "entrydate >= ";
                param+= "'"+startDate+"'";
                param+=" AND ";
                param+= "entrydate <= ";
                param+= "'"+endDate+"'";
            }

            if (lineName!=null&&!lineName.equals("")){
                param+=" AND ";
                param+=" itdsc like ";
                param+="'%"+lineName+"%'";
            }

            if(type!=null&&!type.equals("")){
                param+=" AND ";
                param+=" itnbr like ";
                param+="'%"+type+"%'";
            }

            sql ="select  rsndesc , SUM (quantity) AS 'sum' from scrap_static_avenger  where 1=1 "+param+"  GROUP BY RSNDESC order by sum desc";
            PreparedStatement prst = connection.prepareStatement(sql);
            //结果集
            ResultSet rs = prst.executeQuery();

            List<CastingCPCB7PvFurnaceChamberCurveOutput> outlist = new ArrayList<>();

            Integer count = 0;
            List<ScrapValue> list = new ArrayList<>();
            List<ScrapValue> outList  = new ArrayList<>();


            while (rs.next()) {
                count++;

                //GET

                String rsndesc = rs.getString("rsndesc");
                String sum =   rs.getString("sum");

                ScrapValue scrapValue = new ScrapValue();
                scrapValue.setName(rsndesc);
                scrapValue.setValue(Integer.valueOf(sum));
                list.add(scrapValue);
            }


            boolean loopSignal = true;



            if(list.size()>=5){
                                                                        //put top5 and others reason and quantity of scarp
                                                                        // need scrap reason and scrap list size bigger than 5
            Integer index = 5;

            while (loopSignal){
                Integer fifth = list.get(index - 1).getValue();         //get fifth scrap value
                Integer others = 0;
                for(int i = index; i<list.size();i++){
                    others += list.get(i).getValue();
                }
                if(others > fifth){
                    index++;
                }else {
                    loopSignal = false;                             //break and use index to push outList
                }

            }


            for(int j = 0; j<index;j++){

                ScrapValue scrapValue = new ScrapValue();
                scrapValue.setName(list.get(j).getName());
                scrapValue.setValue(list.get(j).getValue());
                outList.add(scrapValue);

            }

            Integer indexOthers = 0;
            ScrapValue othersValue = new ScrapValue();
            for(int k = index;k<list.size();k++){
                indexOthers+=list.get(k).getValue();
            }

            othersValue.setName("Others");
            othersValue.setValue(indexOthers);
            outList.add(othersValue);

            }else {
                // when scrap list is less than 5,just put all to the list;
                for(int j = 0; j<list.size();j++){

                    ScrapValue scrapValue = new ScrapValue();
                    scrapValue.setName(list.get(j).getName());
                    scrapValue.setValue(list.get(j).getValue());
                    outList.add(scrapValue);

                }

            }

            System.out.println("count............"+count);
            System.out.println(list);
            rs.close();
            prst.close();

            return outList;


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
     * for device scrap
     * @return
     */
    public List<ScrapValue> getScrapWeek(Integer year,Integer weekno,String line,String device) throws Exception{


        Integer StartRecordNO =1;
        Integer EndRecordNO =96;
        Double result ;
        String inList = "";
        String DateStringInList ="";


        //weekno , year get monday date
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,year);
        cal.set(Calendar.WEEK_OF_YEAR, weekno);
        cal.set(Calendar.DAY_OF_WEEK, 2);
        Date date = cal.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");



        for(int i=0;i<7;i++){
            Calendar calstart = Calendar.getInstance();
            calstart.setTime(date);
            calstart.add(Calendar.DAY_OF_WEEK, (i));
            String dateStringAdd =sdf.format(calstart.getTime());
            DateStringInList+="'";
            DateStringInList+=dateStringAdd;
            DateStringInList+="'";
            if(i<6){
                DateStringInList+=",";
            }

        }

        for(int i =0;i<=EndRecordNO-StartRecordNO;i++ ){
            inList+="'";

            inList+=(StartRecordNO+i);
            inList+="'";
            if(i<=(EndRecordNO-StartRecordNO)-1){
                inList+=",";
            }
        }

        PageData pageData4tra = new PageData();
        pageData4tra.put("DateStringInList",DateStringInList);
        pageData4tra.put("inList",inList);
        List<GeneralTraceabilityDataOutput>  tralist =generalTraceabilityDataService.generallist(false,pageData4tra,line,device);
        Integer actuallypieces = tralist.size();

        Integer goodpieces = tralist.size();


        List<ScrapValue> list = new ArrayList<>();

        if(actuallypieces==0){
            return null;
        }

        Integer sum09 =0;
        Integer sum10 =0;
        Integer sum11 =0;
        Integer sum12 =0;
        Integer sum13 =0;
        Integer sum14 =0;

        for (GeneralTraceabilityData gtra : tralist ){

            if(gtra.getPartstatus()!=0){

                if(gtra.getPartstatus()==9){
                    sum09++;

                }
                if(gtra.getPartstatus()==10){
                    sum10++;
                }

                if(gtra.getPartstatus()==11){
                    sum11++;

                }
                if(gtra.getPartstatus()==12){
                    sum12++;

                }
                if(gtra.getPartstatus()==13){

                    sum13++;
                }
                if(gtra.getPartstatus()==14){

                    sum14++;
                }


                goodpieces--;

            }

        }





        for(int i= 0;i<6;i++){

            ScrapValue g38Value = new ScrapValue();

            if(i==0){
                g38Value.setName("Visual Check scrap");
                g38Value.setValue(sum09);

            }
            if(i==1){
                g38Value.setName("2D barcode scrap");
                g38Value.setValue(sum10);
            }
            if(i==2){

                g38Value.setName("Bushing press scrap");
                g38Value.setValue(sum11);
            }
            if(i==3){

                g38Value.setName("Ball joint Press scrap");
                g38Value.setValue(sum12);
            }
            if(i==4){

                g38Value.setName("Test");
                g38Value.setValue(sum13);
            }
            if(i==5){

                g38Value.setName("Appearance scrap");
                g38Value.setValue(sum14);
            }
            list.add(g38Value);

        }


        result = new BigDecimal((float)  goodpieces/actuallypieces).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        return list;


    }











}
