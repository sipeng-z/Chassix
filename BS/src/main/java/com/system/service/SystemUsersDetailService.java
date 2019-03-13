package com.system.service;

import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.system.domain.model.input.SystemUsersDetailInput;
import com.system.domain.model.input.SystemUsersInput;
import com.system.domain.model.output.SystemUsersDetailOutput;
import com.system.domain.model.output.SystemUsersOutput;
import com.utils.MapperName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.system.domain.entity.SystemUsers;
import com.system.service.SystemUsersService;

import java.math.BigDecimal;

@Service
public class SystemUsersDetailService extends AbstractService<SystemUsersDetailInput,SystemUsersDetailOutput> {

    //mapper方法名
    private String mapperName = MapperName.Name.SystemUsersDetailName;

    @Autowired
    SystemUsersService systemUsersService;

    @Override
    public String getMapperName() {
        return mapperName;
    }


    /**
     * 用于增加余额
     * param pkid,reward amount
     * @return
     */
    public boolean addamount(String systemUsersDetailId, BigDecimal after) throws Exception{

            PageData pageData = new PageData();
            pageData.put("systemUsersDetailId",systemUsersDetailId);
            pageData.put("amount",after);
            pageData.put("lastUpdatedUserId",this.WorkContext.getUserId());
            pageData.put("lastUpdatedUserName",this.WorkContext.getName());
            pageData.put("lastUpdatedDateTime",this.getNowTime());
            if(daoImp.update(getMapperName()+"updateAmount",pageData)>0){
                return true;
            }
            return false;

    }


    /**
     * 通过usedId去获取单个对象
     * @return
     */
    public SystemUsersDetailOutput getByUserId(String userId) throws Exception{

        PageData pageData = new PageData();
        pageData.put("userId",userId);
        return (SystemUsersDetailOutput)daoImp.findForObject(this.getMapperName()+"findbyuserid",pageData );


    }

    /**
     * 用于新增用户详情
     * @param input
     * @return
     */
    @Override
    public boolean add(SystemUsersDetailInput input) throws Exception{

        if(input.getSystemUsersDetailId()==null||input.getSystemUsersDetailId().equals("")){
            input.setSystemUsersDetailId(super.getGUID());
        }
        if(input.getAmount()==null){
            input.setAmount(new BigDecimal("0.00"));
        }
        return super.add(input);
    }






}
