package com.casting.service;

import com.casting.domain.model.input.MechanicalPropertiesReportDetailInput;
import com.casting.domain.model.output.MechanicalPropertiesReportDetailOutput;
import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.utils.MapperName;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MechanicalPropertiesReportDetailService extends AbstractService<MechanicalPropertiesReportDetailInput,MechanicalPropertiesReportDetailOutput> {

    private String mapperName = MapperName.Name.MechanicalPropertiesReportDetailName;

    @Override
    public String getMapperName() {
        return mapperName;
    }



    @Override
    public boolean add(MechanicalPropertiesReportDetailInput input) throws Exception{




        if(input.getBatchNumber()==null||input.getBatchNumber().equals("")){
            return false;
        }


        if(input.getDetailId()==null||input.getDetailId().equals("")){
            input.setDetailId(super.getGUID());
        }

        return super.add(input);

    }





    @Override
    /**
     *update recordDetail
     */
    public boolean update(MechanicalPropertiesReportDetailInput input) throws Exception{

        if(input.getBatchNumber()!=null&&!input.getBatchNumber().equals("")){

            return super.update(input);
        }else {
            return false;
        }

    }


    @Override
    /**
     *  search content batchNumber for more detail in chemical results
     */
    public List<MechanicalPropertiesReportDetailOutput> list(boolean isPager, PageData pageData) throws Exception {

        StringBuilder sb = new StringBuilder();

        if (pageData.containsKey("BatchNumber")) {
            sb.append(" AND  Batch_Number  = "  + pageData.getMap().get("BatchNumber"));
        }

        sb.append(new PageData().where(pageData));
        if (isPager) {
            return super.pageList(pageData, mapperName + "list", sb.toString());
        }
        PageData sqlModel = new PageData();
        sqlModel.put("retrieveSql", sb.toString());
        return (List<MechanicalPropertiesReportDetailOutput>) daoImp.findForListSql(getMapperName()+"list",sqlModel);
    }



    /**
     *  get by detailId
     * @param
     * @return
     * @throws Exception
     */
    @Override
    public MechanicalPropertiesReportDetailOutput get(String detailId) throws Exception {

        PageData pageData = new PageData();
        pageData.put("detailId",detailId);
        return (MechanicalPropertiesReportDetailOutput) daoImp.findForObject(mapperName+"findByPkId",pageData);
    }


    /**
     *  get by batchNumber
     * @param
     * @return
     * @throws Exception
     */
    public List<MechanicalPropertiesReportDetailOutput> getByBatchNumber(String batchNumber) throws Exception {

        PageData pageData = new PageData();
        pageData.put("batchNumber",batchNumber);
        return (List<MechanicalPropertiesReportDetailOutput> ) daoImp.findForList(mapperName+"findByBatchNumber",pageData);
    }















}
