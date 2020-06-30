package com.application;

import com.core.dao.imp.DaoImp;
import com.domain.model.PageData;
import com.model.AppConsts;
import com.project.domain.entity.LineDevice;
import com.project.domain.entity.MachineOverviewValue;
import com.project.domain.model.output.LineDeviceOutput;
import com.project.service.LineDeviceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Test {


    public static void main(String[] args) throws ParseException {

        String lineName  = "C1xxV2";
        Integer targetPieces = 0;

        double runningSumDouble = 0.5;


        Integer[] Budget ={25,57};  // cnc assy
        Integer[] cyclePieces = {2,4};


        if(lineName.contains("V2")){
            targetPieces = new BigDecimal((float) cyclePieces[1]*3600/Budget[1]*runningSumDouble ).setScale(2, BigDecimal.ROUND_HALF_UP).intValue();

//            targetPieces = cyclePieces[1]*3600/Budget[1]*runningSumDouble;
        }
        System.out.println(targetPieces);
    }
   /* public List<LineDeviceOutput> list(PageData pageData) throws Exception {


        StringBuilder sb = new StringBuilder();

        if (pageData.containsKey("layer")) {
            sb.append(" and layer = " + "'" + pageData.getMap().get("layer") + "'");
        }


        if (pageData.containsKey("parentId")) {
            sb.append(" and parent_id = " + "'" + pageData.getMap().get("parentId") + "'");
        }


        if (pageData.containsKey("lineName")) {
            sb.append(" and parent_id in (select Line_Device_id from Line_Device where name like " + "'" + pageData.getMap().get("lineName") + "')");
        }

        if (pageData.containsKey("module")) {
            sb.append(" and module = " + "'" + pageData.getMap().get("module") + "'");
        }


        sb.append(new PageData().where(pageData));


        PageData sqlModel = new PageData();
        sqlModel.put("retrieveSql",new PageData().where(pageData));
        sqlModel.put("retrieveSql", sb.toString());
        System.out.println(new PageData().where(pageData));
        return null;
//        return (List<LineDeviceOutput>) daoImp.findForListSql("com.project.mapper.mybatis.LineDeviceMapper"+"list",sqlModel);
    }*/
}
