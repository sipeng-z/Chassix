package com.project.service;
import com.project.domain.entity.G38Shipment;
import com.project.domain.entity.G38Stock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
/**
 * @author yyh
 * @create 2018/08/08
 * 测试数据库
 */
@Service
@PropertySource({"classpath:application.properties"})
public class G38StockService {
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


    public  String getLhAssy(){
        Connection connection = null;
        try {
            //get driver
            Class.forName(DRIVER_NAME);
            //open
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            String sql = "select sum(quantity)as assylhqty  from inventory_static_avenger  where ITEM = '00487.10'";
            PreparedStatement prst = connection.prepareStatement(sql);
            //get result
            ResultSet rs = prst.executeQuery();
            String result = "";
            while (rs.next()) {

                String qty =   rs.getString("assylhqty");
                result= qty;
            }
            rs.close();
            prst.close();
            return result;
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





    public  String getRhAssy(){
        Connection connection = null;
        try {

            Class.forName(DRIVER_NAME);

            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

            String sql = "select sum(quantity)as assyrhqty  from inventory_static_avenger  where ITEM = '00488.10'";
            PreparedStatement prst = connection.prepareStatement(sql);

            ResultSet rs = prst.executeQuery();
            String result = "";
            while (rs.next()) {

                String qty =   rs.getString("assyrhqty");
                result= qty;
            }
            rs.close();
            prst.close();
            return result;
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






    public  String getLhCast(){
        Connection connection = null;
        try {

            Class.forName(DRIVER_NAME);

            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

            String sql = "select sum(quantity)as lhcastqty  from inventory_static_avenger   where ITEM = '00487.05F'";
            PreparedStatement prst = connection.prepareStatement(sql);

            ResultSet rs = prst.executeQuery();
            String result = "";
            while (rs.next()) {

                String qty =   rs.getString("lhcastqty");
                result=qty;

            }
            rs.close();
            prst.close();
            return result;
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


    public  String getRhCast(){
        Connection connection = null;
        try {

            Class.forName(DRIVER_NAME);

            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

            String sql = "select sum(quantity)as rhcastqty  from inventory_static_avenger  where ITEM = '00488.05F'";
            PreparedStatement prst = connection.prepareStatement(sql);

            ResultSet rs = prst.executeQuery();
            String result = "";
            while (rs.next()) {

                String qty =   rs.getString("rhcastqty");
                result=qty;

            }
            rs.close();
            prst.close();
            return result;
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



    public  String getBushing(){
        Connection connection = null;
        try {

            Class.forName(DRIVER_NAME);

            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

            String sql = "select  sum(quantity) as bushing from inventory_static_avenger where ITEM = '135715'";
            PreparedStatement prst = connection.prepareStatement(sql);

            ResultSet rs = prst.executeQuery();
            String result = "";
            while (rs.next()) {

                String qty =   rs.getString("bushing");
                result=qty;

            }
            rs.close();
            prst.close();
            return result;
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



    public  String getBallJoint(){
        Connection connection = null;
        try {

            Class.forName(DRIVER_NAME);

            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

            String sql = "select  sum(quantity) as balljoint from inventory_static_avenger where ITEM = '115701'";
            PreparedStatement prst = connection.prepareStatement(sql);

            ResultSet rs = prst.executeQuery();
            String result = "";
            while (rs.next()) {

                String qty =   rs.getString("balljoint");
                result=qty;

            }
            rs.close();
            prst.close();
            return result;
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
     * get stock data from avenger_840  that was not static refresh every time
     * @return
     */
    public  G38Stock getAll(){
        Connection connection = null;
        try {

            Class.forName(DRIVER_NAME);

            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

            //ASSY
            String sql1 = "select  sum(qty) as qty from inventory_avenger_840 where ITEM = '00487.05F'";
            PreparedStatement prst1 = connection.prepareStatement(sql1);

            String sql2 = "select  sum(qty) as qty from inventory_avenger_840 where ITEM = '00488.05F'";
            PreparedStatement prst2 = connection.prepareStatement(sql2);

            //CAST
            String sql3 = "select  sum(qty) as qty from inventory_avenger_840 where ITEM = '00487.05C'";
            PreparedStatement prst3 = connection.prepareStatement(sql3);

            String sql4 = "select  sum(qty) as qty from inventory_avenger_840 where ITEM = '00488.05C'";
            PreparedStatement prst4 = connection.prepareStatement(sql4);

            //BUSHING
            String sql5 = "select  sum(qty) as qty from inventory_avenger_840 where ITEM = '135715'";
            PreparedStatement prst5 = connection.prepareStatement(sql5);
            //BALL JOINT
            String sql6 = "select  sum(qty) as qty from inventory_avenger_840 where ITEM = '115701'";
            PreparedStatement prst6 = connection.prepareStatement(sql6);
            //结果集
            ResultSet rs1 = prst1.executeQuery();
            ResultSet rs2 = prst1.executeQuery();
            ResultSet rs3 = prst1.executeQuery();
            ResultSet rs4 = prst1.executeQuery();
            ResultSet rs5 = prst1.executeQuery();
            ResultSet rs6 = prst1.executeQuery();

            G38Stock g38Stock = new G38Stock();

            String result = "";
            while (rs1.next()) {

                String qty =   rs1.getString("qty");
                g38Stock.setLhAssy(qty);

            }

            while (rs2.next()) {

                String qty =   rs2.getString("qty");
                g38Stock.setRhAssy(qty);

            }


            while (rs3.next()) {

                String qty =   rs3.getString("qty");
                g38Stock.setLhCast(qty);

            }

            while (rs4.next()) {

                String qty =   rs4.getString("qty");
                g38Stock.setRhCast(qty);

            }

            while (rs5.next()) {

                String qty =   rs5.getString("qty");
               g38Stock.setBushing(qty);

            }



            while (rs6.next()) {

                String qty =   rs6.getString("qty");
                g38Stock.setBallJoint(qty);

            }



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


            return g38Stock;

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
