package com.casting.service;

import com.casting.domain.model.input.MechanicalPropertiesReportInput;
import com.casting.domain.model.output.MechanicalPropertiesReportOutput;
import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.utils.MapperName;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MechanicalPropertiesReportService extends AbstractService<MechanicalPropertiesReportInput,MechanicalPropertiesReportOutput> {





    private String mapperName = MapperName.Name.MechanicalPropertiesReportName;


    @Override
    public String getMapperName() {
        return mapperName;
    }



    @Override
    public boolean add(MechanicalPropertiesReportInput input) throws Exception{

        if(input.getBatchNumber()==null||input.getBatchNumber().equals("")){
            return false;
        }
        return super.add(input);

    }

    @Override
    /**
     *update record
     */
    public boolean update(MechanicalPropertiesReportInput input) throws Exception{

        if(input.getBatchNumber()!=null&&!input.getBatchNumber().equals("")){

            return super.update(input);
        }else {
            return false;
        }

    }



    @Override
    public List<MechanicalPropertiesReportOutput> list(boolean isPager, PageData pageData) throws Exception {

        StringBuilder sb = new StringBuilder();


        if (pageData.containsKey("state")) {
            sb.append(" AND state = "  + pageData.getMap().get("state"));
        }


        sb.append(new PageData().where(pageData));
        if (isPager) {
            return super.pageList(pageData, mapperName + "list", sb.toString());
        }
        PageData sqlModel = new PageData();
        sqlModel.put("retrieveSql", sb.toString());
        return (List<MechanicalPropertiesReportOutput>) daoImp.findForListSql(getMapperName()+"list",sqlModel);
    }




    /**
     * get by batchNUmber
     * @param
     * @return
     * @throws Exception
     */
    public MechanicalPropertiesReportOutput getByBatchNumber(String batchNumber) throws Exception {
        PageData pageData = new PageData();
        pageData.put("batchNumber",batchNumber);
        return (MechanicalPropertiesReportOutput) daoImp.findForObject(getMapperName()+"findByPkId",pageData);
    }

    public boolean deleteByBatchNumber(String batchNumber) throws Exception {
        PageData pageData = new PageData();
        pageData.put("batchNumber",batchNumber);
        if(daoImp.delete(getMapperName()+"deleteByPrimaryKey",pageData)>0){
            return true;
        }
        return false;
    }






}
