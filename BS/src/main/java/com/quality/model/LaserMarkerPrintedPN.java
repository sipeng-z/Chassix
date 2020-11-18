package com.quality.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class LaserMarkerPrintedPN {
    private Integer itemno;

    private String machineNo;

    private String soNumber;

    private String handSign;

    private String dmContent;

    private Integer dailyCount;

    private Integer flcCount;

    private String partType;

    private Date askedTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    private Date insertTime;

    private Integer codeLevel;

    private Integer matchingLevel;

    private String vcContent;

    private String batchId;

    public Integer getItemno() {
        return itemno;
    }

    public void setItemno(Integer itemno) {
        this.itemno = itemno;
    }

    public String getMachineNo() {
        return machineNo;
    }

    public void setMachineNo(String machineNo) {
        this.machineNo = machineNo == null ? null : machineNo.trim();
    }

    public String getSoNumber() {
        return soNumber;
    }

    public void setSoNumber(String soNumber) {
        this.soNumber = soNumber == null ? null : soNumber.trim();
    }

    public String getHandSign() {
        return handSign;
    }

    public void setHandSign(String handSign) {
        this.handSign = handSign == null ? null : handSign.trim();
    }

    public String getDmContent() {
        return dmContent;
    }

    public void setDmContent(String dmContent) {
        this.dmContent = dmContent == null ? null : dmContent.trim();
    }

    public Integer getDailyCount() {
        return dailyCount;
    }

    public void setDailyCount(Integer dailyCount) {
        this.dailyCount = dailyCount;
    }

    public Integer getFlcCount() {
        return flcCount;
    }

    public void setFlcCount(Integer flcCount) {
        this.flcCount = flcCount;
    }

    public String getPartType() {
        return partType;
    }

    public void setPartType(String partType) {
        this.partType = partType == null ? null : partType.trim();
    }

    public Date getAskedTime() {
        return askedTime;
    }

    public void setAskedTime(Date askedTime) {
        this.askedTime = askedTime;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Integer getCodeLevel() {
        return codeLevel;
    }

    public void setCodeLevel(Integer codeLevel) {
        this.codeLevel = codeLevel;
    }

    public Integer getMatchingLevel() {
        return matchingLevel;
    }

    public void setMatchingLevel(Integer matchingLevel) {
        this.matchingLevel = matchingLevel;
    }

    public String getVcContent() {
        return vcContent;
    }

    public void setVcContent(String vcContent) {
        this.vcContent = vcContent == null ? null : vcContent.trim();
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }
}