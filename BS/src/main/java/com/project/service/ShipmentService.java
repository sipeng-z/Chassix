package com.project.service;

import com.core.service.AbstractService;
import com.project.domain.entity.G38Shipment;
import com.project.domain.entity.ScrapValue;
import com.project.domain.entity.Shipment;
import com.utils.MapperName;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import sun.security.util.Password;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ShipmentService extends AbstractService<Shipment,Shipment> {


//    private String mapperName = MapperName.Name.ShipmentName;
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


    /**
     * get SHIPMENT （customer requirement ）AFTER TODAY
     * @return
     */


    public List<Shipment> getAllShipment(String itmdesc){
        Connection connection = null;
        try {
            URL="jdbc:sqlserver://10.41.32.2:1433;DatabaseName=ERP_MES;";
            USER_NAME="SZ_user";
            PASSWORD="SZuser";

            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            Date today = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String datestring = sdf.format(today);

            //GET SHIPMENT
            //ALL  = LH OR RH TIMES 2
            String sql1 = "select top 5 * from reqdta_static_avenger where itmdesc like'%"+itmdesc+"%' and DUEDT > '"+datestring+"' ORDER BY DUEDT";

            PreparedStatement prst1 = connection.prepareStatement(sql1);

            //RESULT LIST
            ResultSet rs1 = prst1.executeQuery();

            List<Shipment> resultlist = new ArrayList<>();

            while (rs1.next()) {

                String DUEDT =   rs1.getString("DUEDT");
                String rhqty =   rs1.getString("QTY");
                Double QTYdouble = Double.valueOf(rhqty)*2;
                String QTY =QTYdouble.toString();
                String[] couple = QTY.split("\\.");

                Shipment g = new Shipment();
                g.setDate(DUEDT.substring(0,10));
                g.setQty(couple[0]);
                resultlist.add(g);

            }

            rs1.close();
            prst1.close();
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
