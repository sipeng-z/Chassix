package com.system.service;

import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.system.domain.entity.UserRole;
import com.system.domain.model.input.UserRoleInput;
import com.system.domain.model.output.UserRoleOutput;
import com.system.domain.model.output.UserroleDataOutput;
import com.utils.MapperName;
import com.utils.ValidateUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserRoleService extends AbstractService<UserRoleInput, UserRoleOutput> {
    private String mapperName = MapperName.Name.UserRoleName;

    @Override
    public String getMapperName() {
        return mapperName;
    }



    public boolean add(UserRoleInput userRoleInput) throws Exception {
        if(!ValidateUtils.isDefaultValue(userRoleInput.getUserRoleId())){
            userRoleInput.setUserRoleId(super.getGUID());
        }
        return  super.add(userRoleInput);
    }

    /**
     * 更改用户的角色
     * @param userid
     * @param roleidList
     * @return
     */
    @Transactional
    public boolean userrolepost(String userid,String roleidList) throws Exception {
        boolean flag = false;
        if(roleidList == null || "".equals(roleidList)) {
            PageData pageData = new PageData();
            pageData.put("userId",userid);
            daoImp.delete(mapperName+"deleteByUserId",pageData);
            return true;
        }
        String[] strs = roleidList.split(",");
        PageData pageData = new PageData();
        pageData.put("userId",userid);
        daoImp.delete(mapperName+"deleteByUserId",pageData);
        UserRole userrole = new UserRole();
        for(String s : strs) {
            userrole.setUserRoleId(super.getGUID());
            userrole.setUserId(userid);
            userrole.setRoleId(s);
            daoImp.save(mapperName+"insertSelective",userrole);
        }
        flag = true;

        return flag;
    }







    /**
     * param userid设置用户id loginid登录用户id isadmin 是否未超级管理员
     *
     * @return
     */
    public List<UserroleDataOutput> getList(String userid) throws Exception {
        StringBuilder sql = new StringBuilder();
        if (!this.WorkContext.isSuperAdministrator()) {
            sql.append("  AND  r.created_user_id = '"+this.WorkContext.getUserId()+"'");

        }
        PageData pageData = new PageData();
        pageData.put("userId", "'"+userid+"'");
        pageData.put("retrieveSql", sql);
        List<UserroleDataOutput> dataList = (List<UserroleDataOutput>) daoImp.findForList(mapperName + "findByUserId", pageData);
        String str = sql.toString();
        for (UserroleDataOutput urd : dataList) {
            if (urd.getCheckedroleids() == null) {
                urd.setCheckedroleid(0);
            } else {
                urd.setCheckedroleid(1);
            }
        }
        return dataList;
    }
}
