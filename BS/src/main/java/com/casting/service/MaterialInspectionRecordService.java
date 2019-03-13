package com.casting.service;

import com.casting.domain.entity.MaterialInspectionRecord;
import com.casting.domain.model.input.MaterialInspectionRecordInput;
import com.casting.domain.model.output.MaterialInspectionRecordOutput;
import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.utils.MapperName;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialInspectionRecordService extends AbstractService<MaterialInspectionRecordInput,MaterialInspectionRecordOutput> {




    private String mapperName = MapperName.Name.MaterialInspectionRecordName;


    @Override
    public String getMapperName() {
        return mapperName;
    }




    @Override
    public boolean add(MaterialInspectionRecordInput input) throws Exception{

      if(input.getBatchNumber()==null||input.getBatchNumber().equals("")){
          return false;
      }

        return super.add(input);

    }


    @Override
    /**
     *update record
     */
    public boolean update(MaterialInspectionRecordInput input) throws Exception{

        if(input.getBatchNumber()!=null&&!input.getBatchNumber().equals("")){

            return super.update(input);
        }else {
            return false;
        }

    }


    @Override
    public List<MaterialInspectionRecordOutput> list(boolean isPager, PageData pageData) throws Exception {

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
        return (List<MaterialInspectionRecordOutput>) daoImp.findForListSql(getMapperName()+"list",sqlModel);
    }



    /**
     * updateState
     * @param batchNumber
     * @return
     * @throws Exception
     */
    public boolean updateState (String batchNumber,Integer state) throws Exception{

        PageData pageData = new PageData();
        pageData.put("batchNumber",batchNumber);
        pageData.put("state",state);

        if(daoImp.update(getMapperName()+"updateByBatch",pageData)>0){
            return true;
        }
        return false;


    }




    /**
     * get by ItemNO
     * @param
     * @return
     * @throws Exception
     */
    public MaterialInspectionRecordOutput getByBatchNumber(String batchNumber) throws Exception {
        PageData pageData = new PageData();
        pageData.put("batchNumber",batchNumber);
        return (MaterialInspectionRecordOutput) daoImp.findForObject(getMapperName()+"findByPkId",pageData);
    }








}
