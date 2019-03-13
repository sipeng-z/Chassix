package com.project.service;


import com.casting.domain.model.output.CastingCPCB7PvFurnaceChamberCurveOutput;
import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.project.domain.entity.MachStock;
import com.project.domain.entity.ScrapValue;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class StockService extends AbstractService<MachStock,MachStock>{



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
    //sql driver
    private static final String DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver" ;
    //url
    @Value("${erp.url}")
    private  String URL;

    //user
    @Value("${erp.user_name}")
    private  String USER_NAME;
    //pw
    @Value("${erp.password}")
    private  String PASSWORD;


    /**
     * get stock data from avenger_840  that was not static refresh every time
     * @return
     */
    public MachStock getStockG38(){
        Connection connection = null;
        try {

            Class.forName(DRIVER_NAME);

            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

            String sql1 = "select sum(quantity)as   qty  from inventory_static_avenger  where ITEM = '00487.10'"; //Mach

            String sql2 = "select sum(quantity)as   qty  from inventory_static_avenger  where ITEM = '00488.10'";

            String sql3 = "select sum(quantity)as  qty  from inventory_static_avenger   where ITEM = '00487.05F'"; //Casting

            String sql4 = "select sum(quantity)as  qty  from inventory_static_avenger  where ITEM = '00488.05F'";



            //Mach finished

            PreparedStatement prst1 = connection.prepareStatement(sql1);
            PreparedStatement prst2 = connection.prepareStatement(sql2);

            //Casting finished
            PreparedStatement prst3 = connection.prepareStatement(sql3);
            PreparedStatement prst4 = connection.prepareStatement(sql4);





            //results
            ResultSet rs1 = prst1.executeQuery();
            ResultSet rs2 = prst1.executeQuery();
            ResultSet rs3 = prst1.executeQuery();
            ResultSet rs4 = prst1.executeQuery();


            MachStock machStock = new MachStock();

            String result = "";
            while (rs1.next()) {

                String qty =   rs1.getString("qty");
                machStock.setLhAssy(qty);

            }

            while (rs2.next()) {

                String qty =   rs2.getString("qty");
                machStock.setRhAssy(qty);

            }


            while (rs3.next()) {

                String qty =   rs3.getString("qty");
                machStock.setLhCast(qty);

            }

            while (rs4.next()) {

                String qty =   rs4.getString("qty");
                machStock.setRhCast(qty);

            }


            rs1.close();
            prst1.close();
            rs2.close();
            prst2.close();
            rs3.close();
            prst3.close();
            rs4.close();
            prst4.close();



            return machStock;

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
