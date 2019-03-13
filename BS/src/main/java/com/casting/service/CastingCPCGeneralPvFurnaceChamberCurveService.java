package com.casting.service;

import com.casting.domain.model.input.CastingCPCGeneralPvFurnaceChamberCurveInput;
import com.casting.domain.model.output.CastingCPCGeneralPvFurnaceChamberCurveOutput;
import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.model.AppConsts;
import com.utils.MapperName;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class CastingCPCGeneralPvFurnaceChamberCurveService extends AbstractService<CastingCPCGeneralPvFurnaceChamberCurveInput,CastingCPCGeneralPvFurnaceChamberCurveOutput> {


    private final String generalName =  AppConsts.CastingCPCGeneralPvFurnaceChamberCurveName;
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
    @Value("${new.dbo.url}")
    private  String URL;

    //数据库连接地址
    @Value("${new.dbo.user_name}")
    private  String USER_NAME;
    //密码
    @Value("${new.dbo.password}")
    private  String PASSWORD;


    /**
     * using different device name to judge different xml to operate the db
     * get list
     * @param isPager
     * @param pageData{
     *                TimeString ,device
     * }
     * @return
     * @throws Exception
     */

    public List<CastingCPCGeneralPvFurnaceChamberCurveOutput> generallist(boolean isPager, PageData pageData,String device) throws Exception {

        this.setMapperName(AppConsts.CastingCPCGeneralPvFurnaceChamberCurveName.replace("General",device));

        StringBuilder sb = new StringBuilder();

        if(pageData.containsKey("DateString")){
            sb.append("AND Time_String like "+"'%"+pageData.getMap().get("DateString")+"%'");
        }


        if(pageData.containsKey("TimeString")){
            sb.append("AND Time_String like "+"'%"+pageData.getMap().get("TimeString")+"%'");
        }


        if(pageData.containsKey("inList")){
            sb.append("AND RecordNo in ("+pageData.getMap().get("inList")+")");
        }


        sb.append(new PageData().where(pageData));
        if (isPager) {

            return  super.pageList(pageData, mapperName + "list", sb.toString());

        }
        PageData sqlModel = new PageData();
        sqlModel.put("retrieveSql", sb.toString());
        return (List<CastingCPCGeneralPvFurnaceChamberCurveOutput>) daoImp.findForListSql(mapperName+"list",sqlModel);
    }




    /**
     * getPoint without mybatis to avoid code gbk?utf-8?unicode? >> mess
     * assignment table -- cpc curve point records ,
     */
  @Test
    public  List<CastingCPCGeneralPvFurnaceChamberCurveOutput> getPoint(PageData pageData,String device){

        Connection connection = null;
        try {
            URL=AppConsts.dbUrlForCPCPointConnection;
            USER_NAME="SZ_user";
            PASSWORD="SZuser";
            //get driver
            Class.forName(DRIVER_NAME);
            //get connection
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            //sql
            String sql ="";

            String db = "dbo.Casting_CPC_General_Pv_Furnace_Chamber_Curve";
            db = db.replace("General",device);

            if(pageData.containsKey("Flag")&&pageData.containsKey("TimeString")){
                String timeString = pageData.getMap().get("TimeString");

                if(pageData.getMap().get("Flag").equals("0")){ //next , time string < time model

                    sql = "select top 2 * from  "+db+" where Time_String < '"+timeString+" 'order by Time_String desc";
                }else if(pageData.getMap().get("Flag").equals("1")) { //before
                    sql = "select top 2 * from  "+db+" where Time_String > '"+timeString+" 'order by Time_String desc";
                   }

            }else if(pageData.containsKey("TimeString")){
                if(!pageData.getMap().get("TimeString").equals("")){
                    String timeString = pageData.getMap().get("TimeString");
                    sql = "select top 2 * from  "+db+" where Time_String LIKE '%"+timeString+"%' order by Time_String desc";

                }
            }else{
                sql = "SELECT TOP 2 ItemNO, Time_String, Furnace_Chamber, Point_Matrix FROM (SELECT ROW_NUMBER() OVER ( ORDER BY Time_String DESC) PAGE_ROW_NUMBER, ItemNO, Time_String, Furnace_Chamber, Point_Matrix FROM "+db+" WHERE 1 = 1) AS PAGE_TABLE_ALIAS WHERE PAGE_ROW_NUMBER > 0  ORDER BY PAGE_ROW_NUMBER";

            }


            PreparedStatement prst = connection.prepareStatement(sql);
            //结果集
            ResultSet rs = prst.executeQuery();
            String result = "";
            List<CastingCPCGeneralPvFurnaceChamberCurveOutput> outlist = new ArrayList<>();

            while (rs.next()) {
                CastingCPCGeneralPvFurnaceChamberCurveOutput pointObj = new CastingCPCGeneralPvFurnaceChamberCurveOutput();

                //GET
                String ItemNO =   rs.getString("ItemNO");
                String TimeString = rs.getString("Time_String");
                String FurnaceChamber =rs.getString("Furnace_Chamber");
                String point =   rs.getString("Point_Matrix");

              //SET
                pointObj.setItemno(Integer.valueOf(ItemNO));
                pointObj.setTimeString(TimeString);
                pointObj.setFurnaceChamber(FurnaceChamber);
                pointObj.setPointMatrixString(point);
             //PUSH
                outlist.add(pointObj);

            }
            rs.close();
            prst.close();
            return outlist;

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
