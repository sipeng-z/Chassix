package com.upload.entity;

import java.math.BigDecimal;
import java.util.Date;

public class AttachmentConfig {

    private String configId;

    private String resourceType;

    private Integer type;

    private String actionName;

    private String pathFormat;

    private Integer maxSize;

    private String allowFiles;

    private String urlPrefix;

    private Integer isDefualt;

    private Integer isCompress;

    private BigDecimal compressMaxWidth;

    private String description;

    private Integer displayOrder;

    private Integer state;

    private String createdUserId;

    private String createdUserName;

    private Date createdDateTime;

    private String lastUpdatedUserId;

    private String lastUpdatedUserName;

    private Date lastUpdatedDateTime;

    private Integer auditState;

    private String auditUserId;

    private String auditUserName;

    private Date auditDateTime;

    private Integer isDeleted;

    public String getConfigId() {
        return configId;
    }

    public void setConfigId(String configId) {
        this.configId = configId;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType == null ? null : resourceType.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName == null ? null : actionName.trim();
    }

    public String getPathFormat() {
        return pathFormat;
    }

    public void setPathFormat(String pathFormat) {
        this.pathFormat = pathFormat == null ? null : pathFormat.trim();
    }

    public Integer getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(Integer maxSize) {
        this.maxSize = maxSize;
    }

    public String getAllowFiles() {
        return allowFiles;
    }

    public void setAllowFiles(String allowFiles) {
        this.allowFiles = allowFiles == null ? null : allowFiles.trim();
    }

    public String getUrlPrefix() {
        return urlPrefix;
    }

    public void setUrlPrefix(String urlPrefix) {
        this.urlPrefix = urlPrefix == null ? null : urlPrefix.trim();
    }

    public Integer getIsDefualt() {
        return isDefualt;
    }

    public void setIsDefualt(Integer isDefualt) {
        this.isDefualt = isDefualt;
    }

    public Integer getIsCompress() {
        return isCompress;
    }

    public void setIsCompress(Integer isCompress) {
        this.isCompress = isCompress;
    }

    public BigDecimal getCompressMaxWidth() {
        return compressMaxWidth;
    }

    public void setCompressMaxWidth(BigDecimal compressMaxWidth) {
        this.compressMaxWidth = compressMaxWidth;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(String createdUserId) {
        this.createdUserId = createdUserId;
    }

    public String getCreatedUserName() {
        return createdUserName;
    }

    public void setCreatedUserName(String createdUserName) {
        this.createdUserName = createdUserName == null ? null : createdUserName.trim();
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public String getLastUpdatedUserId() {
        return lastUpdatedUserId;
    }

    public void setLastUpdatedUserId(String lastUpdatedUserId) {
        this.lastUpdatedUserId = lastUpdatedUserId;
    }

    public String getLastUpdatedUserName() {
        return lastUpdatedUserName;
    }

    public void setLastUpdatedUserName(String lastUpdatedUserName) {
        this.lastUpdatedUserName = lastUpdatedUserName == null ? null : lastUpdatedUserName.trim();
    }

    public Date getLastUpdatedDateTime() {
        return lastUpdatedDateTime;
    }

    public void setLastUpdatedDateTime(Date lastUpdatedDateTime) {
        this.lastUpdatedDateTime = lastUpdatedDateTime;
    }

    public Integer getAuditState() {
        return auditState;
    }

    public void setAuditState(Integer auditState) {
        this.auditState = auditState;
    }

    public String getAuditUserId() {
        return auditUserId;
    }

    public void setAuditUserId(String auditUserId) {
        this.auditUserId = auditUserId;
    }

    public String getAuditUserName() {
        return auditUserName;
    }

    public void setAuditUserName(String auditUserName) {
        this.auditUserName = auditUserName == null ? null : auditUserName.trim();
    }

    public Date getAuditDateTime() {
        return auditDateTime;
    }

    public void setAuditDateTime(Date auditDateTime) {
        this.auditDateTime = auditDateTime;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}