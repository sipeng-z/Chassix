package com.project.service;

import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.project.domain.entity.G38ASSYOEEData;
import com.project.domain.entity.G38OperationTeam;
import com.project.domain.model.input.G38OperationTeamInput;
import com.project.domain.model.output.G38OperationTeamOutput;
import com.utils.MapperName;
import org.springframework.stereotype.Service;

@Service
public class G38OperationTeamService extends AbstractService<G38OperationTeamInput,G38OperationTeamOutput> {



    private String mapperName = MapperName.Name.G38OperationTeamName;


    @Override
    public String getMapperName() {
        return mapperName;
    }


    /*
    ADD
     */
    @Override
    public boolean add(G38OperationTeamInput input) throws Exception{

        if(input.getOperationTeamId()==null||!input.getOperationTeamId().equals("")){
            input.setOperationTeamId(super.getGUID());
        }

        return super.add(input);

    }


    /**
     * getByTeamId (pkid)
     * @param
     * @return
     * @throws Exception
     */
    public G38OperationTeam getByTeamId(String TeamId) throws Exception {
        PageData pageData = new PageData();
        pageData.put("TeamId",TeamId);
        return (G38OperationTeam) daoImp.findForObject(getMapperName()+"findByPkId",pageData);
    }









}
