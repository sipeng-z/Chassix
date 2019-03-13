package com.system.service;

import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.system.domain.model.input.LoginLogsInput;
import com.system.domain.model.output.LoginLogsOutput;
import com.utils.MapperName;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LoginLogsService extends AbstractService<LoginLogsInput,LoginLogsOutput> {
    private String LoginLogsName = MapperName.Name.LoginLogsName;

    @Override
    public String getMapperName() {
        return LoginLogsName;
    }


    /**
     * 新增
     * @param logonlogsInput
     * @return
     */
    @Override
    public boolean add(LoginLogsInput logonlogsInput) throws Exception {
        logonlogsInput.setLoginLogsId(super.getGUID());
        logonlogsInput.setLoginTime(new Date());
        return super.add(logonlogsInput);
    }

    /**
     * 修改
     * @param logonlogsInput
     * @return
     */
    @Override
    public boolean update(LoginLogsInput logonlogsInput) throws Exception {
        return super.update(logonlogsInput);
    }


    /**
     * 分页列表/全部列表
     * @param pageData
     * @return
     * @throws Exception
     */
    @Override
    public List<LoginLogsOutput> list(boolean isPager, PageData pageData) throws Exception {
        PageData sqlModel = new PageData();
        sqlModel.put("retrieveSql",new PageData().where(pageData));
        return (List<LoginLogsOutput>) daoImp.findForListSql(getMapperName()+"list",sqlModel);
    }
}
