package com.project.service;

import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.project.domain.model.input.LineDeviceInput;
import com.project.domain.model.output.LineDeviceOutput;
import com.utils.MapperName;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LineDeviceService extends AbstractService<LineDeviceInput,LineDeviceOutput> {


    private String mapperName = MapperName.Name.LineDeviceName;

    @Override
    public String getMapperName() {
        return mapperName;
    }


    @Override
    public List<LineDeviceOutput> list(boolean isPager, PageData pageData) throws Exception {

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

        if(isPager){
            return pageList(pageData,getMapperName()+"list",sb.toString());
        }
        PageData sqlModel = new PageData();
        sqlModel.put("retrieveSql",new PageData().where(pageData));
        sqlModel.put("retrieveSql", sb.toString());

        return (List<LineDeviceOutput>) daoImp.findForListSql(getMapperName()+"list",sqlModel);

    }






}
