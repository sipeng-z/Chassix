package com.system.service;

import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.system.domain.model.input.LaserMarkerPrintedPNInput;
import com.system.domain.model.output.LaserMarkerPrintedPNOutput;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.utils.MapperName.Name.QueryHistoryName;

@Service
public class QueryHistoryService extends AbstractService<LaserMarkerPrintedPNInput, LaserMarkerPrintedPNOutput> {

    private String QueryHistoryNames = QueryHistoryName;

    @Override
    public String getMapperName() {
        return QueryHistoryNames;
    }

    /**
     * 分页列表/全部列表
     * @param pageData
     * @return
     * @throws Exception
     */
    @Override
    public List<LaserMarkerPrintedPNOutput> list(boolean isPager, PageData pageData) throws Exception {
        PageData sqlModel = new PageData();
        sqlModel.put("retrieveSql",new PageData().where(pageData));
        return (List<LaserMarkerPrintedPNOutput>) daoImp.findForListSql(getMapperName()+"list",sqlModel);
    }
}
