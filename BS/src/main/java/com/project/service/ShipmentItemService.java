package com.project.service;

import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.project.domain.entity.ShipmentItem;
import com.project.domain.model.output.LineDeviceOutput;
import com.utils.MapperName;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentItemService extends AbstractService <ShipmentItem,ShipmentItem>{



    private String mapperName = MapperName.Name.ShipmentName;

    @Override
    public String getMapperName() {
        return mapperName;
    }




    @Override
    public List<ShipmentItem> list(boolean isPager, PageData pageData) throws Exception {

        StringBuilder sb = new StringBuilder();

        if (pageData.containsKey("name")) {
            sb.append(" and name like " + "'%" + pageData.getMap().get("name") + "%'");
        }

        sb.append(new PageData().where(pageData));

        if(isPager){
            return pageList(pageData,getMapperName()+"list",sb.toString());
        }
        PageData sqlModel = new PageData();
        sqlModel.put("retrieveSql",new PageData().where(pageData));
        sqlModel.put("retrieveSql", sb.toString());

        return (List<ShipmentItem>) daoImp.findForListSql(getMapperName()+"list",sqlModel);

    }







}
