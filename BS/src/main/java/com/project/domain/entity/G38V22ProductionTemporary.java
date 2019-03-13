package com.project.domain.entity;

import java.util.Date;

public class G38V22ProductionTemporary {
    private String temporaryId;

    private String dateString;

    private Integer recordno;

    private String createdUserId;

    private Date createdTime;

    private Integer isProduction;

    private String operator;

    private String description;

    private Integer mark;

    public String getTemporaryId() {
        return temporaryId;
    }

    public void setTemporaryId(String temporaryId) {
        this.temporaryId = temporaryId == null ? null : temporaryId.trim();
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString == null ? null : dateString.trim();
    }

    public Integer getRecordno() {
        return recordno;
    }

    public void setRecordno(Integer recordno) {
        this.recordno = recordno;
    }

    public String getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(String createdUserId) {
        this.createdUserId = createdUserId == null ? null : createdUserId.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getIsProduction() {
        return isProduction;
    }

    public void setIsProduction(Integer isProduction) {
        this.isProduction = isProduction;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }
}