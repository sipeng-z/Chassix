package com.casting.domain.entity;

import java.util.Date;

public class CastingCPCB3PQData {

    private Integer itemno;

    private String soNumber;

    private Integer partStatus;

    private Date vmTime;

    private Integer recordNo;

    private String dateString;

    private Integer totalParts;

    private Integer ngParts;

    private Integer goodParts;

    public Integer getItemno() {
        return itemno;
    }

    public void setItemno(Integer itemno) {
        this.itemno = itemno;
    }

    public String getSoNumber() {
        return soNumber;
    }

    public void setSoNumber(String soNumber) {
        this.soNumber = soNumber;
    }

    public Integer getPartStatus() {
        return partStatus;
    }

    public void setPartStatus(Integer partStatus) {
        this.partStatus = partStatus;
    }

    public Date getVmTime() {
        return vmTime;
    }

    public void setVmTime(Date vmTime) {
        this.vmTime = vmTime;
    }

    public Integer getRecordNo() {
        return recordNo;
    }

    public void setRecordNo(Integer recordNo) {
        this.recordNo = recordNo;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public Integer getTotalParts() {
        return totalParts;
    }

    public void setTotalParts(Integer totalParts) {
        this.totalParts = totalParts;
    }

    public Integer getNgParts() {
        return ngParts;
    }

    public void setNgParts(Integer ngParts) {
        this.ngParts = ngParts;
    }

    public Integer getGoodParts() {
        return goodParts;
    }

    public void setGoodParts(Integer goodParts) {
        this.goodParts = goodParts;
    }
}
