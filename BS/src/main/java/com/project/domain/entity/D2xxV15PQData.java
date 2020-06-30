package com.project.domain.entity;

import java.util.Date;

public class D2xxV15PQData {

    private Integer itemno;

    private String soNumber;

    private Integer partstatus;

    private Date vmTime;

    private Integer recordno;

    private String dateString;

    private Integer totalparts;

    private Integer ngparts;

    private Integer goodparts;

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
        this.soNumber = soNumber == null ? null : soNumber.trim();
    }

    public Integer getPartstatus() {
        return partstatus;
    }

    public void setPartstatus(Integer partstatus) {
        this.partstatus = partstatus;
    }

    public Date getVmTime() {
        return vmTime;
    }

    public void setVmTime(Date vmTime) {
        this.vmTime = vmTime;
    }

    public Integer getRecordno() {
        return recordno;
    }

    public void setRecordno(Integer recordno) {
        this.recordno = recordno;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString == null ? null : dateString.trim();
    }

    public Integer getTotalparts() {
        return totalparts;
    }

    public void setTotalparts(Integer totalparts) {
        this.totalparts = totalparts;
    }

    public Integer getNgparts() {
        return ngparts;
    }

    public void setNgparts(Integer ngparts) {
        this.ngparts = ngparts;
    }

    public Integer getGoodparts() {
        return goodparts;
    }

    public void setGoodparts(Integer goodparts) {
        this.goodparts = goodparts;
    }
}
