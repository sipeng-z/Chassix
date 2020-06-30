package com.casting.domain.entity;

import java.util.Date;

public class CastingCPCA4OEEDataTemporary {
    private String temporaryId;

    private String dateString;

    private Integer recordno;

    private Integer runningTime;

    private Integer plannedRunTime;

    private Integer lunchTime;

    private Integer breakTime;

    private Integer preventiveMaintenance;

    private Integer setupPreoaration;

    private Integer changeOvers;

    private Integer unplannedDowntime;

    private String createdUserId;

    private Date createdTime;

    private Integer isProduction;

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

    public Integer getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(Integer runningTime) {
        this.runningTime = runningTime;
    }

    public Integer getPlannedRunTime() {
        return plannedRunTime;
    }

    public void setPlannedRunTime(Integer plannedRunTime) {
        this.plannedRunTime = plannedRunTime;
    }

    public Integer getLunchTime() {
        return lunchTime;
    }

    public void setLunchTime(Integer lunchTime) {
        this.lunchTime = lunchTime;
    }

    public Integer getBreakTime() {
        return breakTime;
    }

    public void setBreakTime(Integer breakTime) {
        this.breakTime = breakTime;
    }

    public Integer getPreventiveMaintenance() {
        return preventiveMaintenance;
    }

    public void setPreventiveMaintenance(Integer preventiveMaintenance) {
        this.preventiveMaintenance = preventiveMaintenance;
    }

    public Integer getSetupPreoaration() {
        return setupPreoaration;
    }

    public void setSetupPreoaration(Integer setupPreoaration) {
        this.setupPreoaration = setupPreoaration;
    }

    public Integer getChangeOvers() {
        return changeOvers;
    }

    public void setChangeOvers(Integer changeOvers) {
        this.changeOvers = changeOvers;
    }

    public Integer getUnplannedDowntime() {
        return unplannedDowntime;
    }

    public void setUnplannedDowntime(Integer unplannedDowntime) {
        this.unplannedDowntime = unplannedDowntime;
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