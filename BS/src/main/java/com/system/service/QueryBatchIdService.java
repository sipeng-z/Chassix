package com.system.service;

import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.system.domain.model.input.CastingChemistryUseInput;
import com.system.domain.model.output.CastingChemistryUseOutput;
import com.system.domain.model.output.LaserMarkerPrintedPNOutput;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.utils.MapperName.Name.QueryBatchIdName;
import static com.utils.MapperName.Name.QueryHistoryName;

@Service
public class QueryBatchIdService extends AbstractService<CastingChemistryUseInput, CastingChemistryUseOutput> {


    private String QueryBatchIdNames = QueryBatchIdName;

    @Override
    public String getMapperName() {
        return QueryBatchIdNames;
    }

    /**
     * 分页列表/全部列表
     * @param pageData
     * @return
     * @throws Exception
     */
    @Override
    public List<CastingChemistryUseOutput> list(boolean isPager, PageData pageData) throws Exception {
        PageData sqlModel = new PageData();
        sqlModel.put("retrieveSql",new PageData().where(pageData));
        return (List<CastingChemistryUseOutput>) daoImp.findForListSql(getMapperName()+"list",sqlModel);
    }
}
