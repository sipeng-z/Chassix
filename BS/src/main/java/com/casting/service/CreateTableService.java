package com.casting.service;

import com.casting.domain.model.output.CastingCPCB7PvFurnaceChamberCurveOutput;
import com.domain.model.PageData;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class CreateTableService {



    //sqlserver驱动包名
    private static final String DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver" ;
    //用户名
    @Value("${dbo.url}")
    private  String URL;


    //数据库连接地址
    @Value("${dbo.user_name}")
    private  String USER_NAME;
    //密码
    @Value("${dbo.password}")
    private  String PASSWORD;




    /**
     * getPoint without mybatis to avoid code gbk?utf-8?unicode? >> mess
     */

    public boolean createTables(String deviceName){

        if(deviceName==null||deviceName.equals("")){
            return false;
        }
        Connection connection = null;
        try {
            URL="jdbc:sqlserver://10.41.32.2:1433;DatabaseName=SZ_001;";
            USER_NAME="SZ_user";
            PASSWORD="SZuser";
            //get driver
            Class.forName(DRIVER_NAME);
            //get connection
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            //sql


            String oeeSql ="create table Casting_CPC_"+deviceName+"_OEE_Data" +
                    "(" +
                    "  ItemNO                 int identity" +
                    "    primary key," +
                    "  Date_String            char(8)  not null," +
                    "  RecordNO               int      not null," +
                    "  RunningTime            int," +
                    "  Planned_Run_Time       int," +
                    "  Lunch_time             int," +
                    "  Break_Time             int," +
                    "  Prevention_Maintenance int," +
                    "  Setup_Preparation      int," +
                    "  Change_Overs           int," +
                    "  Unplanned_Downtime     int," +
                    "  VM_Time_INS            datetime not null," +
                    "  Description            varchar(20)," +
                    "  mark                   int" +
                    ")";

            String oeeTemSql ="create table Casting_CPC_"+deviceName+"_OEE_Data_Temporary" +
                    "(" +
                    "  Date_String            varchar(8) not null," +
                    "  RecordNO               int," +
                    "  Running_Time           int," +
                    "  Planned_Run_Time       int," +
                    "  Lunch_Time             int," +
                    "  Break_Time             int," +
                    "  Preventive_Maintenance int," +
                    "  Setup_Preoaration      int," +
                    "  Change_Overs           int," +
                    "  Unplanned_Downtime     int," +
                    "  Created_User_Id        varchar(36)," +
                    "  Created_Time           datetime," +
                    "  Temporary_id           char(36)   not null" +
                    "    primary key," +
                    "  Is_Production          int," +
                    "  Description            varchar(20)," +
                    "  mark                   int" +
                    ")";


            String pvSql ="create table Casting_CPC_"+deviceName+"_Pv_Furnace_Chamber_Curve" +
                    "(" +
                    "  ItemNO          int identity" +
                    "    primary key," +
                    "  Time_String     char(12) not null," +
                    "  Furnace_Chamber char(8)," +
                    "  Point_Matrix    varbinary(6000)," +
                    "  RecordNO        int" +
                    ")";



            //parse and run  for 3 tables

            PreparedStatement oeeprst = connection.prepareStatement(oeeSql);
            PreparedStatement oeetemprst = connection.prepareStatement(oeeTemSql);
            PreparedStatement pvprst = connection.prepareStatement(pvSql);


            // result

            Integer oeers = oeeprst. executeUpdate();
            Integer oeetemrs = oeetemprst. executeUpdate();
            Integer pvrs = pvprst.executeUpdate();


            //1
            if (oeers>=0) {
                System.out.println("oee table created");

            }

            //2
            if (oeetemrs>=0) {
                System.out.println("oee_tem table created");

            }

            //3
            if (pvrs>=0) {
                System.out.println("pv table created");

            }

            return true;



        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            return false;

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
