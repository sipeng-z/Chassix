package com.system.service;

import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.system.domain.model.input.AttachmentInput;
import com.system.domain.model.output.AttachmentOutput;
import com.utils.MapperName;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AttachmentService extends AbstractService<AttachmentInput, AttachmentOutput> {

    String mapperName = MapperName.Name.AttachmentName;

    @Override
    public String getMapperName() {
        return mapperName;
    }

    /**
     * 新增
     *
     * @param attachment
     * @return
     */
    @Override
    public boolean add(AttachmentInput attachment) throws Exception {
        attachment.setAttachmentId(super.getGUID());
        attachment.setAttachmentSize(new BigDecimal(String.valueOf(attachment.getAttachmentSize())));
        return super.add(attachment);
    }


    /**
     * 修改
     *
     * @param attachment
     * @return
     */
    @Override
    public boolean update(AttachmentInput attachment) throws Exception {
        return super.update(attachment);
    }


    /**
     * 分页列表/全部列表
     *
     * @param pageData
     * @return
     * @throws Exception
     */
    @Override
    public List<AttachmentOutput> list(boolean isPager, PageData pageData) throws Exception {
        StringBuilder sb = new StringBuilder();
        if (pageData.containsKey("resourceId")) {
            sb.append(" AND resource_id = " + "'" + pageData.getMap().get("resourceId") + "'");
        }
        if (pageData.containsKey("templateId")) {
            sb.append(" AND template_id = " + "'" + pageData.getMap().get("templateId") + "'");
        }
        if (pageData.containsKey("resourceType")) {
            sb.append(" AND resource_type = " + "'" + pageData.getMap().get("resourceType") + "'");
        }
        if (pageData.containsKey("attachmentId")) {
            sb.append(" AND attachment_id = " + "'" + pageData.getMap().get("attachmentId") + "'");
        }
        sb.append(new PageData().where(pageData));
        if (isPager) {
            return super.pageList(pageData, mapperName + "list", sb.toString());
        }
        PageData sqlModel = new PageData();
        sqlModel.put("retrieveSql", sb.toString());

        return (List<AttachmentOutput>) daoImp.findForListSql(mapperName + "list", sqlModel);
    }


    @Transactional
    public boolean listAdd(String id, List<AttachmentInput> list) throws Exception {
        PageData pageData = new PageData();
        pageData.put("resourceId", id);
        String resourceIds = "00000000-0000-0000-0000-000000000001";
        if (!id.equals(resourceIds)) {
            this.daoImp.delete(mapperName + "deleteByResourceId", pageData);
        }
        if (list != null && list.size() > 0) {
            for (AttachmentInput attachmentInput : list) {
                attachmentInput.setResourceId(id);
                this.add(attachmentInput);
            }
        }
        return true;
    }

    /**
     * 获取项目设置审批文件列表
     *
     * @param pageData
     * @return
     * @throws Exception
     */
    public List<AttachmentOutput> managementlist(boolean isPager, PageData pageData) throws Exception {
        StringBuilder sb = new StringBuilder();
        String resourceId = "00000000-0000-0000-0000-000000000001";
        int resourceType = 88;
        if (resourceId != null) {
            sb.append(" AND resource_id = " + "'" + resourceId + "'");
        }
        if (resourceType != 0) {
            sb.append(" AND resource_type = " + "'" + resourceType + "'");
        }
        sb.append(new PageData().where(pageData));
        if (isPager) {
            return super.pageList(pageData, mapperName + "list", sb.toString());
        }
        PageData sqlModel = new PageData();
        sqlModel.put("retrieveSql", sb.toString());

        return (List<AttachmentOutput>) daoImp.findForListSql(mapperName + "list", sqlModel);
    }


    /**
     * 获取项目设置审批文件列表
     *
     * @param pageData
     * @return
     * @throws Exception
     */
    public List<AttachmentOutput> projectslist(boolean isPager, PageData pageData) throws Exception {
        StringBuilder sb = new StringBuilder();
        int resourceType = 3;
        if (pageData.containsKey("resourceId")) {
            sb.append(" AND resource_id = " + "'" + pageData.getMap().get("resourceId") + "'");
        }

        if (resourceType != 0) {
            sb.append(" AND resource_type = " + "'" + resourceType + "'");
        }
        sb.append(new PageData().where(pageData));
        if (isPager) {
            return super.pageList(pageData, mapperName + "list", sb.toString());
        }
        PageData sqlModel = new PageData();
        sqlModel.put("retrieveSql", sb.toString());

        return (List<AttachmentOutput>) daoImp.findForListSql(mapperName + "list", sqlModel);
    }
}
