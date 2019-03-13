package com.system.service;

import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.response.ResponseResult;
import com.system.domain.entity.SystemUsers;
import com.system.domain.model.input.SystemUsersInput;
import com.system.domain.model.output.SystemUsersOutput;
import com.utils.MapperName;
import org.springframework.stereotype.Service;

@Service
public class SystemUsersService extends AbstractService<SystemUsersInput,SystemUsersOutput> {
    //mapper方法名
    private String mapperName = MapperName.Name.SystemUsersName;

    @Override
    public String getMapperName() {
        return mapperName;
    }
    /**
     *
     * add时赋予guid主键
     * return guid
     */

    public String addoutstring(SystemUsersInput systemUsersInput) throws Exception{
            String guid = super.getGUID();
            systemUsersInput.setUserId(guid);
            Boolean flag =   super.add(systemUsersInput);
            if(flag==true){
                return guid;
            }
            return null;
    }
    /**
     * 审核
     *
     * 0未审核
     * 1通过
     * 3未通过
     * @param userId
     * @return
     */
    public boolean audituser(String userId,Integer state) throws Exception{
        PageData pageData = new PageData();
        pageData.put("userId",userId);
        pageData.put("state",state);
        int resultPageData = daoImp.update(mapperName+"audituser",pageData);
        if(resultPageData>0)
        {
            return true;
        }
        return  false;
    }


    /**
     * 获取单个对象by openid
     * @param openid
     * @return
     * @throws Exception
     */

    public SystemUsersOutput getbyopenid(String openid) throws Exception {
        PageData pageData = new PageData();
        pageData.put("openid",openid);
        return (SystemUsersOutput) daoImp.findForObject(getMapperName()+"findByOpenId",pageData);
    }




    /**
     * 获取单个对象by openid
     * @param userId
     * @return
     * @throws Exception
     */

    @Override
    public SystemUsersOutput get(String userId) throws Exception {
        PageData pageData = new PageData();
        pageData.put("id",userId);
        return (SystemUsersOutput) daoImp.findForObject(getMapperName()+"findByPkId",pageData);
    }







}
