package com.project.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class G38ASSYShift {
    private String shiftId;

    private String mon;

    private String tue;

    private String wed;

    private String thu;

    private String fri;

    private String sat;

    private String sun;

    private String shiftName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdDateTime;

    private String createdUserId;

    private Integer isDeleted;

    private String lastUpdatedUserId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastUpdatedDateTime;

    private Integer displayorder;

    private Integer weekNo;

    private Integer mark;

    public String getShiftId() {
        return shiftId;
    }

    public void setShiftId(String shiftId) {
        this.shiftId = shiftId == null ? null : shiftId.trim();
    }

    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon == null ? null : mon.trim();
    }

    public String getTue() {
        return tue;
    }

    public void setTue(String tue) {
        this.tue = tue == null ? null : tue.trim();
    }

    public String getWed() {
        return wed;
    }

    public void setWed(String wed) {
        this.wed = wed == null ? null : wed.trim();
    }

    public String getThu() {
        return thu;
    }

    public void setThu(String thu) {
        this.thu = thu == null ? null : thu.trim();
    }

    public String getFri() {
        return fri;
    }

    public void setFri(String fri) {
        this.fri = fri == null ? null : fri.trim();
    }

    public String getSat() {
        return sat;
    }

    public void setSat(String sat) {
        this.sat = sat == null ? null : sat.trim();
    }

    public String getSun() {
        return sun;
    }

    public void setSun(String sun) {
        this.sun = sun == null ? null : sun.trim();
    }

    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName == null ? null : shiftName.trim();
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public String getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(String createdUserId) {
        this.createdUserId = createdUserId == null ? null : createdUserId.trim();
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getLastUpdatedUserId() {
        return lastUpdatedUserId;
    }

    public void setLastUpdatedUserId(String lastUpdatedUserId) {
        this.lastUpdatedUserId = lastUpdatedUserId == null ? null : lastUpdatedUserId.trim();
    }

    public Date getLastUpdatedDateTime() {
        return lastUpdatedDateTime;
    }

    public void setLastUpdatedDateTime(Date lastUpdatedDateTime) {
        this.lastUpdatedDateTime = lastUpdatedDateTime;
    }

    public Integer getDisplayorder() {
        return displayorder;
    }

    public void setDisplayorder(Integer displayorder) {
        this.displayorder = displayorder;
    }

    public Integer getWeekNo() {
        return weekNo;
    }

    public void setWeekNo(Integer weekNo) {
        this.weekNo = weekNo;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }
}