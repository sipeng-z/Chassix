package com.quality.model;

import java.util.Date;

public class XRayBatchNO {
    private Integer itemno;

    private Integer machineNo;

    private Integer parttypeQuantity;

    private String soNumber;

    private String partType;

    private String dmContentAbbreviation;

    private String dmContent;

    private String rackNo;

    private String batchNo;

    private Date insertTime;

    private Integer htStatus;

    public Integer getItemno() {
        return itemno;
    }

    public void setItemno(Integer itemno) {
        this.itemno = itemno;
    }

    public Integer getMachineNo() {
        return machineNo;
    }

    public void setMachineNo(Integer machineNo) {
        this.machineNo = machineNo;
    }

    public Integer getParttypeQuantity() {
        return parttypeQuantity;
    }

    public void setParttypeQuantity(Integer parttypeQuantity) {
        this.parttypeQuantity = parttypeQuantity;
    }

    public String getSoNumber() {
        return soNumber;
    }

    public void setSoNumber(String soNumber) {
        this.soNumber = soNumber == null ? null : soNumber.trim();
    }

    public String getPartType() {
        return partType;
    }

    public void setPartType(String partType) {
        this.partType = partType == null ? null : partType.trim();
    }

    public String getDmContentAbbreviation() {
        return dmContentAbbreviation;
    }

    public void setDmContentAbbreviation(String dmContentAbbreviation) {
        this.dmContentAbbreviation = dmContentAbbreviation == null ? null : dmContentAbbreviation.trim();
    }

    public String getDmContent() {
        return dmContent;
    }

    public void setDmContent(String dmContent) {
        this.dmContent = dmContent == null ? null : dmContent.trim();
    }

    public String getRackNo() {
        return rackNo;
    }

    public void setRackNo(String rackNo) {
        this.rackNo = rackNo == null ? null : rackNo.trim();
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Integer getHtStatus() {
        return htStatus;
    }

    public void setHtStatus(Integer htStatus) {
        this.htStatus = htStatus;
    }

}