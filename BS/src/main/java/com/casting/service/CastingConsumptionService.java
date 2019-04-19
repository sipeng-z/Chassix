package com.casting.service;

import com.casting.domain.entity.CastingValue;
import com.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class CastingConsumptionService extends AbstractService<CastingValue,CastingValue> {


    private final String generalName = "";
    private String mapperName = generalName;

    @Override
    public String getMapperName() {
        return mapperName;
    }


    public void setMapperName(String mapperName){
        this.mapperName = mapperName;
    }




    //sqlserver驱动包名
    private static final String DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver" ;
    //用户名
    @Value("${new.erp.url}")
    private  String URL;


    //数据库连接地址
    @Value("${erp.user_name}")
    private   String USER_NAME;
    //密码
    @Value("${erp.password}")
    private   String PASSWORD;


    /**
     *
     * get  Aluminum usage
     * until now , latest records
     *
     * primary in stock ; scrap in stock ; sprue in stock
     * primary in wis ; scrap in wis; sprue in wip
     * @paramF
     * @return
     */
    public List<CastingValue> getAluminumUsage(){

        Connection connection = null;
        try {

            Class.forName(DRIVER_NAME);

            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

            List<CastingValue> outList = new ArrayList<>();

            // content : primary in stock ; scrap in stock ; sprue in stock
            // content : primary wis ; scrap wis; sprue wip


            String sql1 = "select sum(ABS(quantity)) as 'qty' from inventory_static_avenger where itmdesc like '%PRIMARY%' and locn = 'RAWM'";

            String sql2 = "select sum(ABS(quantity)) as 'qty' from inventory_static_avenger where itmdesc like '%SCRAP%' and locn = 'RAWM'";

            String sql3 = "select sum(ABS(quantity)) as 'qty' from inventory_static_avenger where itmdesc like '%SPRUE%' and locn = 'RAWM'";


            String sql4 = "select sum(ABS(quantity)) as 'qty' from inventory_static_avenger where itmdesc like '%PRIMARY%' and locn LIKE 'Y10%'";


            String sql5 = "select sum(ABS(quantity)) as 'qty' from inventory_static_avenger where itmdesc like '%SCRAP%' and locn LIKE 'Y10%'";

            String sql6 = "select sum(ABS(quantity)) as 'qty' from inventory_static_avenger where itmdesc like '%SPRUE%' and locn LIKE 'Y10%'";


            PreparedStatement prst1 = connection.prepareStatement(sql1);
            PreparedStatement prst2 = connection.prepareStatement(sql2);

            PreparedStatement prst3 = connection.prepareStatement(sql3);
            PreparedStatement prst4 = connection.prepareStatement(sql4);

            PreparedStatement prst5 = connection.prepareStatement(sql5);
            PreparedStatement prst6 = connection.prepareStatement(sql6);


            //results
            ResultSet rs1 = prst1.executeQuery();
            ResultSet rs2 = prst2.executeQuery();
            ResultSet rs3 = prst3.executeQuery();
            ResultSet rs4 = prst4.executeQuery();
            ResultSet rs5 = prst5.executeQuery();
            ResultSet rs6 = prst6.executeQuery();

            // content : primary in stock ; scrap in stock ; sprue in stock
            // content : primary wis ; scrap wis; sprue wip



            while (rs1.next()) {

                String qty1 =   rs1.getString("qty");

                CastingValue castingValue = new CastingValue();

                if(qty1!=null&&!qty1.equals("")){

                    castingValue.setName(" primary in stock");
                    castingValue.setValue(Integer.valueOf(qty1));
                    outList.add(castingValue);
                }else {
                    castingValue.setName(" primary in stock");
                    castingValue.setValue(0);
                    outList.add(castingValue);
                }

            }

            while (rs2.next()) {

                String qty2 =   rs2.getString("qty");
                CastingValue castingValue = new CastingValue();
                if(qty2!=null&&!qty2.equals("")){
                    castingValue.setName(" scrap in stock");
                    castingValue.setValue(Integer.valueOf(qty2));
                    outList.add(castingValue);
                }else {
                    castingValue.setName(" scrap in stock");
                    castingValue.setValue(0);
                    outList.add(castingValue);
                }

            }


            while (rs3.next()) {

                String qty3 =   rs3.getString("qty");

                CastingValue castingValue = new CastingValue();
                if(qty3!=null&&!qty3.equals("")){
                    castingValue.setName(" sprue in stock");
                    castingValue.setValue(Integer.valueOf(qty3));
                    outList.add(castingValue);
                }else {
                    castingValue.setName(" sprue in stock");
                    castingValue.setValue(0);
                    outList.add(castingValue);
                }

            }

            while (rs4.next()) {

                String qty4 =   rs4.getString("qty");
                CastingValue castingValue = new CastingValue();

                if(qty4!=null&&!qty4.equals("")){
                    castingValue.setName("primary in WIP");
                    castingValue.setValue(Integer.valueOf(qty4));
                    outList.add(castingValue);
                }else {
                    castingValue.setName("primary in WIP");
                    castingValue.setValue(0);
                    outList.add(castingValue);
                }

            }


            while (rs5.next()) {

                String qty5 =   rs5.getString("qty");
                CastingValue castingValue = new CastingValue();
                if(qty5!=null&&!qty5.equals("")){
                    castingValue.setName("scrap in WIP");
                    castingValue.setValue(Integer.valueOf(qty5));
                    outList.add(castingValue);
                }else {
                    castingValue.setName("scrap in WIP");
                    castingValue.setValue(0);
                    outList.add(castingValue);
                }

            }


            while (rs6.next()) {

                String qty6 =   rs6.getString("qty");
                CastingValue castingValue = new CastingValue();
                if(qty6!=null&&!qty6.equals("")){

                    castingValue.setName("sprue in WIP");
                    castingValue.setValue(Integer.valueOf(qty6));
                    outList.add(castingValue);
                }else {
                    castingValue.setName("sprue in WIP");
                    castingValue.setValue(0);
                    outList.add(castingValue);
                }

            }

            // CLOSE ALL RESULTS
            rs1.close();
            prst1.close();
            rs2.close();
            prst2.close();
            rs3.close();
            prst3.close();
            rs4.close();
            prst4.close();
            rs5.close();
            prst5.close();
            rs6.close();
            prst6.close();

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
     *
     * get  Aluminum consumption
     * until now , latest records
     *
     * for each line
     * @paramF String Line
     * @return
     */
    public List<CastingValue> getAluminumConsumption(String line){

        Connection connection = null;
        try {

            Class.forName(DRIVER_NAME);

            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);



            // 3 results for the line aluminum consumption in one line
            //different line will generate different sql
            // sql1 for primary , sql2 for scrap ,sql3 for sprue

            String sql1 = "select sum(quantity)as   qty  from inventory_static_avenger  where ITEM = '00487.10'";

            String sql2 = "select sum(quantity)as   qty  from inventory_static_avenger  where ITEM = '00488.10'";

            String sql3 = "select sum(quantity)as   qty  from inventory_static_avenger   where ITEM = '00487.05F'";



            PreparedStatement prst1 = connection.prepareStatement(sql1);
            PreparedStatement prst2 = connection.prepareStatement(sql2);

            PreparedStatement prst3 = connection.prepareStatement(sql3);


            //results
            ResultSet rs1 = prst1.executeQuery();
            ResultSet rs2 = prst2.executeQuery();
            ResultSet rs3 = prst3.executeQuery();


            // content : primary in stock ; scrap in stock ; sprue in stock
            // content : primary wis ; scrap wis; sprue wis

            List<CastingValue> outList = new ArrayList<>();

            while (rs1.next()) {
                CastingValue castingValue = new CastingValue();
                String qty =   rs1.getString("qty");
                castingValue.setName(" primary in stock");
                castingValue.setValue(Integer.valueOf(qty));
                outList.add(castingValue);

            }

            while (rs2.next()) {
                CastingValue castingValue = new CastingValue();
                String qty =   rs2.getString("qty");
                castingValue.setName(" scrap in stock");
                castingValue.setValue(Integer.valueOf(qty));
                outList.add(castingValue);
            }


            while (rs3.next()) {
                CastingValue castingValue = new CastingValue();
                String qty =   rs3.getString("qty");
                castingValue.setName(" sprue in stock");
                castingValue.setValue(Integer.valueOf(qty));
                outList.add(castingValue);
            }

            // CLOSE ALL RESULTS
            rs1.close();
            prst1.close();
            rs2.close();
            prst2.close();
            rs3.close();
            prst3.close();

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





}
