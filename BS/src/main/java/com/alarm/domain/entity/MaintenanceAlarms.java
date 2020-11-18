package com.alarm.domain.entity;

import java.util.Date;

public class MaintenanceAlarms {
    private Integer itemno;

    private String equipmentId;

    private String equipmentType;

    private Date vmTime;

    private Date startTime;

    private Date endTime;

    private Integer duration;

    private String alarmcode;

    private String category;

    private String dateString;

    private String description;

    public Integer getItemno() {
        return itemno;
    }

    public void setItemno(Integer itemno) {
        this.itemno = itemno;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId == null ? null : equipmentId.trim();
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType == null ? null : equipmentType.trim();
    }

    public Date getVmTime() {
        return vmTime;
    }

    public void setVmTime(Date vmTime) {
        this.vmTime = vmTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getAlarmcode() {
        return alarmcode;
    }

    public void setAlarmcode(String alarmcode) {
        this.alarmcode = alarmcode == null ? null : alarmcode.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString == null ? null : dateString.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}