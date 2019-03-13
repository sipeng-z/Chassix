package com.system.service;

import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.system.domain.model.input.RoleInput;
import com.system.domain.model.output.RoleOutput;
import com.utils.MapperName;
import com.utils.ValidateUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService extends AbstractService<RoleInput,RoleOutput> {

    private String mapperName = MapperName.Name.RoleName;
    @Override
    public String getMapperName() {
        return mapperName;
    }



    /**
     * 新增
     * @param roleInput
     * @return
     */
    @Override
    public boolean add(RoleInput roleInput) throws Exception {
        roleInput.setRoleId(super.getGUID());
        return super.add(roleInput);
    }

    /**
     * 修改
     * @param roleInput
     * @return
     */
    @Override
    public boolean update(RoleInput roleInput) throws Exception {
        return super.update(roleInput);
    }





    /**
     * 分页列表/全部列表
     * @param pageData
     * @return
     * @throws Exception
     */
    @Override
    public List<RoleOutput> list(boolean isPager, PageData pageData) throws Exception {
        StringBuilder sb = new StringBuilder();
        if(!this.WorkContext.isSuperAdministrator()){
            sb.append(" AND created_user_id = '"+this.WorkContext.getUserId()+"'");
        }
        sb.append(new PageData().where(pageData));
        return super.pageList(pageData,mapperName+"list",sb.toString());
    }

//    校验角色名唯一
    public boolean checkSerialClass(RoleInput roleInput) throws Exception{
        PageData pageData = new PageData();
        pageData.put("name",roleInput.getName());
        pageData.put("id",roleInput.getRoleId());


        Boolean flag;
//        修改时
        if (roleInput.getRoleId()!=null&& ValidateUtils.isDefaultValue(roleInput.getRoleId())){
            List<RoleInput> isOnly =(List<RoleInput>)daoImp.findForListSql(mapperName+"checkSerialClass",pageData);
            if (isOnly.size()>0){
                flag=false;
            }else {
                flag=true;
            }
        }else
        {
            List<RoleInput> isOnly =(List<RoleInput>)daoImp.findForListSql(mapperName+"checkSerialClassAdd",pageData);
            if (isOnly.size()>0){
                flag=false;
            }else {
                flag=true;
            }
        }
        return flag;
    }



}
