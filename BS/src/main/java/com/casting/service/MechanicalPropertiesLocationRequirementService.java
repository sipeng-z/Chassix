package com.casting.service;

import com.casting.domain.model.input.MechanicalPropertiesLocationRequirementInput;
import com.casting.domain.model.output.MechanicalPropertiesLocationRequirementOutput;
import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.utils.MapperName;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MechanicalPropertiesLocationRequirementService extends AbstractService <MechanicalPropertiesLocationRequirementInput,MechanicalPropertiesLocationRequirementOutput> {




    private String mapperName = MapperName.Name.MechanicalPropertiesLocationRequirementName;

    @Override
    public String getMapperName() {
        return mapperName;
    }


    /**
     * add new requirement of location inspection
     * @param input
     * @return
     * @throws Exception
     */
    @Override
    public boolean add(MechanicalPropertiesLocationRequirementInput input) throws Exception{




        if(input.getRequirementId()==null||input.getRequirementId().equals("")){
            input.setRequirementId(super.getGUID());
        }

        return super.add(input);

    }


    @Override
    /**
     *update
     */
    public boolean update(MechanicalPropertiesLocationRequirementInput input) throws Exception{

        if(input.getRequirementId()!=null&&!input.getRequirementId().equals("")){

            return super.update(input);
        }else {
            return false;
        }

    }



    @Override
    /**
     *  search content batchNumber for more detail in chemical results
     */
    public List<MechanicalPropertiesLocationRequirementOutput> list(boolean isPager, PageData pageData) throws Exception {

        StringBuilder sb = new StringBuilder();

        if (pageData.containsKey("PartName")) {
            sb.append(" AND  Part_Name  like " +"'%" + pageData.getMap().get("PartName")+"%'");

        }

        sb.append(new PageData().where(pageData));
        if (isPager) {
            return super.pageList(pageData, mapperName + "list", sb.toString());
        }
        PageData sqlModel = new PageData();
        sqlModel.put("retrieveSql", sb.toString());
        return (List<MechanicalPropertiesLocationRequirementOutput>) daoImp.findForListSql(getMapperName()+"list",sqlModel);
    }



    /**
     *  get by requirement_Id
     * @param
     * @return
     * @throws Exception
     */
    @Override
    public MechanicalPropertiesLocationRequirementOutput get(String requirementId) throws Exception {

        PageData pageData = new PageData();
        pageData.put("requirementId",requirementId);
        return (MechanicalPropertiesLocationRequirementOutput) daoImp.findForObject(mapperName+"findByPkId",pageData);
    }


    /**
     *  get by part name
     * @param
     * @return
     * @throws Exception
     */
    public MechanicalPropertiesLocationRequirementOutput getByName(String partName) throws Exception {

        PageData pageData = new PageData();
        pageData.put("partName",partName);
        return (MechanicalPropertiesLocationRequirementOutput) daoImp.findForObject(mapperName+"findByName",pageData);
    }








}
