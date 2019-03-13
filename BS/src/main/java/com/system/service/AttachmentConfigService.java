package com.system.service;

import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.system.domain.model.input.AttachmentConfigInput;
import com.system.domain.model.output.AttachmentConfigOutput;
import com.utils.MapperName;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachmentConfigService extends AbstractService<AttachmentConfigInput,AttachmentConfigOutput> {
    String mapperName = MapperName.Name.AttachmentConfigName;

    @Override
    public String getMapperName() {
        return mapperName;
    }

    /**
     * 新增
     * @param attachment
     * @return
     */
    @Override
    public boolean add(AttachmentConfigInput attachment) throws Exception {
        return super.add(attachment);
    }


    /**
     * 修改
     * @param attachment
     * @return
     */
    @Override
    public boolean update(AttachmentConfigInput attachment) throws Exception {
        return super.update(attachment);
    }


    /**
     * 分页列表/全部列表
     * @param pageData
     * @return
     * @throws Exception
     */
    @Override
    public List<AttachmentConfigOutput> list(boolean isPager, PageData pageData) throws Exception {
        return super.list(isPager,pageData);
    }

    public List<AttachmentConfigInput> attachmentConfigList() throws Exception {
        PageData pageData = new PageData();
        return (List<AttachmentConfigInput>) this.daoImp.findForList(mapperName+"attachmentConfigList",pageData);
    }

}
