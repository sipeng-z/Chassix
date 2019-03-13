package com.project.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class G38OperationTeam {
    private String operationTeamId;

    private String name;

    private Integer programNo;

    private String programName;

    private Integer state;

    private Integer isDeleted;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date beginningDate;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date endDate;

    private String avatar;

    public String getOperationTeamId() {
        return operationTeamId;
    }

    public void setOperationTeamId(String operationTeamId) {
        this.operationTeamId = operationTeamId == null ? null : operationTeamId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getProgramNo() {
        return programNo;
    }

    public void setProgramNo(Integer programNo) {
        this.programNo = programNo;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName == null ? null : programName.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getBeginningDate() {
        return beginningDate;
    }

    public void setBeginningDate(Date beginningDate) {
        this.beginningDate = beginningDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }
}