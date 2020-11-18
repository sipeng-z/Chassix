package com.quality.model;

import java.util.Date;

public class XRayInspectionResult {
    private Integer itemno;

    private Integer machineNo;

    private Integer programCode;

    private String dmContentAbbreviation;

    private String dmContent;

    private Integer partInspectionStatus;

    private Date insertTime;

    private Integer partValidationType;
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

    public Integer getProgramCode() {
        return programCode;
    }

    public void setProgramCode(Integer programCode) {
        this.programCode = programCode;
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

    public Integer getPartInspectionStatus() {
        return partInspectionStatus;
    }

    public void setPartInspectionStatus(Integer partInspectionStatus) {
        this.partInspectionStatus = partInspectionStatus;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Integer getPartValidationType() {
        return partValidationType;
    }

    public void setPartValidationType(Integer partValidationType) {
        this.partValidationType = partValidationType;
    }

}