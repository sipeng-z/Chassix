package com.project.service;

import com.core.service.AbstractService;
import com.project.domain.entity.Shipment;
import com.project.domain.entity.StockAndWIP;
import com.project.domain.model.input.RawMaterialMonitoringInput;
import com.project.domain.model.output.RawMaterialMonitoringOutput;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RawMaterialMonitoringService extends AbstractService<RawMaterialMonitoringInput, RawMaterialMonitoringOutput> {


    private final String generalName = "";
    private String mapperName = generalName;

    @Override
    public String getMapperName() {
        return mapperName;
    }

    //sql driver
    private static final String DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver" ;
    //url
    @Value("${new.erp.url}")
    private static  String URL;


    //user
    @Value("${new.erp.user_name}")
    private static String USER_NAME;
    //pw
    @Value("${new.erp.password}")
    private  String PASSWORD;

    public List<StockAndWIP> getQuantity(String datestring) {

        Connection connection = null;
        try {
            URL="jdbc:sqlserver://10.41.32.2:1433;DatabaseName=ERP_MES;";
            USER_NAME ="SZ_user";
            PASSWORD ="SZuser";

            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

            //GET SHIPMENT
            //ALL  = LH OR RH TIMES 2
            String sql1 = "select quantity from inventory_snapshot_avenger where itmdesc like'%AL:A356%' and DATEDIFF(DAY,rundate,GETDATE())=1 and locn = '2RAWM'";
            String sql2 = "select quantity from inventory_snapshot_avenger where itmdesc like'%AL:A356%' and DATEDIFF(DAY,rundate,GETDATE())=1 and locn = '2Y10I'";
            String sql3 = "select quantity from inventory_snapshot_avenger where itmdesc like'%OFAL%' and DATEDIFF(DAY,rundate,GETDATE())=1 and locn = '2Y10I'";
            String sql4 = "select quantity from inventory_snapshot_avenger where itmdesc like'%OFAL%' and DATEDIFF(DAY,rundate,GETDATE())=1 and locn = '2Y99I'";
            String sql5 = "select quantity from inventory_snapshot_avenger where itmdesc like'%OFAL%' and DATEDIFF(DAY,rundate,GETDATE())=1 and locn = '2RAWM'";


            PreparedStatement prst1 = connection.prepareStatement(sql1);
            PreparedStatement prst2 = connection.prepareStatement(sql2);
            PreparedStatement prst3 = connection.prepareStatement(sql3);
            PreparedStatement prst4 = connection.prepareStatement(sql4);
            PreparedStatement prst5 = connection.prepareStatement(sql5);

            //RESULT LIST
            ResultSet rs1 = prst1.executeQuery();
            ResultSet rs2 = prst2.executeQuery();
            ResultSet rs3 = prst3.executeQuery();
            ResultSet rs4 = prst4.executeQuery();
            ResultSet rs5 = prst5.executeQuery();

            List<StockAndWIP> resultlist = new ArrayList<>();

            StockAndWIP stockAndWIP = new StockAndWIP();

            while (rs1.next()) {

                Long quantity =   rs1.getLong("quantity");
                stockAndWIP.setPrimaryStock(quantity/1000);

            }
            while (rs2.next()) {

                Long quantity =   rs2.getLong("quantity");
                stockAndWIP.setPrimaryWIP(quantity/1000);
            }
            while (rs5.next()) {

                Long quantity =   rs5.getLong("quantity");
                stockAndWIP.setPrimaryWIP(quantity/1000);
            }

            while (rs3.next()) {

                Long quantity = rs3.getLong("quantity");
                stockAndWIP.setSprueWIP(quantity/1000);
            }
            while (rs5.next()) {

                Long quantity =   rs5.getLong("quantity");
                stockAndWIP.setPrimaryWIP(quantity/1000);
            }
            while (rs4.next()) {

                Long quantity =   rs4.getLong("quantity");
                stockAndWIP.setScrapWIP(quantity/1000);
            }
            resultlist.add(stockAndWIP);

            rs1.close();
            rs2.close();
            rs3.close();
            rs4.close();
            rs5.close();
            prst1.close();
            prst2.close();
            prst3.close();
            prst4.close();
            prst5.close();
            System.out.println(resultlist);
            return resultlist;

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
