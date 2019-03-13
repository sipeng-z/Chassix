package com.project.service;

import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.project.domain.model.input.G05MarkedContentInput;
import com.project.domain.model.output.G05MarkedContentOutput;
import com.project.domain.model.output.G38V23ShiftOutput;
import com.utils.MapperName;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class G05MarkedContentService extends AbstractService <G05MarkedContentInput,G05MarkedContentOutput> {


    private String mapperName = MapperName.Name.G05MarkedContentName;

    @Override
    public String getMapperName() {
        return mapperName;
    }





    /**
     * LIST
     * @param isPager
     * @param pageData
     * @return
     * @throws Exception
     */
    @Override
    public List<G05MarkedContentOutput> list(boolean isPager, PageData pageData) throws Exception {


        StringBuilder sb = new StringBuilder();

        if (pageData.containsKey("DateString")) {
            sb.append(" AND Date_String like " + "'%" + pageData.getMap().get("DateString") + "%'");
        }

        if (pageData.containsKey("Content")) {
            sb.append(" AND Content like " + "'%" + pageData.getMap().get("Content") + "%'");
        }

        sb.append(new PageData().where(pageData));

        if(isPager){
            return pageList(pageData,getMapperName()+"list",sb.toString());
        }
        PageData sqlModel = new PageData();
        sqlModel.put("retrieveSql",new PageData().where(pageData));
        sqlModel.put("retrieveSql", sb.toString());

        return (List<G05MarkedContentOutput>) daoImp.findForListSql(getMapperName()+"list",sqlModel);
    }









}
