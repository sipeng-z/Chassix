package com.quality.model;

import java.util.Date;

public class EMP2ASSYTraceabilityData {
    private Integer itemno;

    private Integer partTypeNo;

    private String machineno;

    private String soNumber;

    private String partType;

    private String partno;

    private String partnoAbbr;

    private Integer partstatus;

    private Float e1PressForce;

    private Float e1EndPostion;

    private Float e1FinalForce;

    private Float e2PressForce;

    private Float e2EndPostion;

    private Float e2FinalForce;

    private Float stud1PressForce;

    private Float stud1EndPostion;

    private Float stud1FinalForce;

    private Float stud2PressForce;

    private Float stud2EndPostion;

    private Float stud2FinalForce;

    private Float stud3PressForce;

    private Float stud3EndPostion;

    private Float stud3FinalForce;

    private Date e1E2CompletedTime;

    private Date labelStickTime;

    private Integer studAssembleStatus;

    private Date partCompletedTime;

    private Integer lastCycleSpentTime;

    private Integer recordno;

    private String dateString;

    public Integer getItemno() {
        return itemno;
    }

    public void setItemno(Integer itemno) {
        this.itemno = itemno;
    }

    public Integer getPartTypeNo() {
        return partTypeNo;
    }

    public void setPartTypeNo(Integer partTypeNo) {
        this.partTypeNo = partTypeNo;
    }

    public String getMachineno() {
        return machineno;
    }

    public void setMachineno(String machineno) {
        this.machineno = machineno == null ? null : machineno.trim();
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

    public String getPartno() {
        return partno;
    }

    public void setPartno(String partno) {
        this.partno = partno == null ? null : partno.trim();
    }

    public String getPartnoAbbr() {
        return partnoAbbr;
    }

    public void setPartnoAbbr(String partnoAbbr) {
        this.partnoAbbr = partnoAbbr == null ? null : partnoAbbr.trim();
    }

    public Integer getPartstatus() {
        return partstatus;
    }

    public void setPartstatus(Integer partstatus) {
        this.partstatus = partstatus;
    }

    public Float getE1PressForce() {
        return e1PressForce;
    }

    public void setE1PressForce(Float e1PressForce) {
        this.e1PressForce = e1PressForce;
    }

    public Float getE1EndPostion() {
        return e1EndPostion;
    }

    public void setE1EndPostion(Float e1EndPostion) {
        this.e1EndPostion = e1EndPostion;
    }

    public Float getE1FinalForce() {
        return e1FinalForce;
    }

    public void setE1FinalForce(Float e1FinalForce) {
        this.e1FinalForce = e1FinalForce;
    }

    public Float getE2PressForce() {
        return e2PressForce;
    }

    public void setE2PressForce(Float e2PressForce) {
        this.e2PressForce = e2PressForce;
    }

    public Float getE2EndPostion() {
        return e2EndPostion;
    }

    public void setE2EndPostion(Float e2EndPostion) {
        this.e2EndPostion = e2EndPostion;
    }

    public Float getE2FinalForce() {
        return e2FinalForce;
    }

    public void setE2FinalForce(Float e2FinalForce) {
        this.e2FinalForce = e2FinalForce;
    }

    public Float getStud1PressForce() {
        return stud1PressForce;
    }

    public void setStud1PressForce(Float stud1PressForce) {
        this.stud1PressForce = stud1PressForce;
    }

    public Float getStud1EndPostion() {
        return stud1EndPostion;
    }

    public void setStud1EndPostion(Float stud1EndPostion) {
        this.stud1EndPostion = stud1EndPostion;
    }

    public Float getStud1FinalForce() {
        return stud1FinalForce;
    }

    public void setStud1FinalForce(Float stud1FinalForce) {
        this.stud1FinalForce = stud1FinalForce;
    }

    public Float getStud2PressForce() {
        return stud2PressForce;
    }

    public void setStud2PressForce(Float stud2PressForce) {
        this.stud2PressForce = stud2PressForce;
    }

    public Float getStud2EndPostion() {
        return stud2EndPostion;
    }

    public void setStud2EndPostion(Float stud2EndPostion) {
        this.stud2EndPostion = stud2EndPostion;
    }

    public Float getStud2FinalForce() {
        return stud2FinalForce;
    }

    public void setStud2FinalForce(Float stud2FinalForce) {
        this.stud2FinalForce = stud2FinalForce;
    }

    public Float getStud3PressForce() {
        return stud3PressForce;
    }

    public void setStud3PressForce(Float stud3PressForce) {
        this.stud3PressForce = stud3PressForce;
    }

    public Float getStud3EndPostion() {
        return stud3EndPostion;
    }

    public void setStud3EndPostion(Float stud3EndPostion) {
        this.stud3EndPostion = stud3EndPostion;
    }

    public Float getStud3FinalForce() {
        return stud3FinalForce;
    }

    public void setStud3FinalForce(Float stud3FinalForce) {
        this.stud3FinalForce = stud3FinalForce;
    }

    public Date getE1E2CompletedTime() {
        return e1E2CompletedTime;
    }

    public void setE1E2CompletedTime(Date e1E2CompletedTime) {
        this.e1E2CompletedTime = e1E2CompletedTime;
    }

    public Date getLabelStickTime() {
        return labelStickTime;
    }

    public void setLabelStickTime(Date labelStickTime) {
        this.labelStickTime = labelStickTime;
    }

    public Integer getStudAssembleStatus() {
        return studAssembleStatus;
    }

    public void setStudAssembleStatus(Integer studAssembleStatus) {
        this.studAssembleStatus = studAssembleStatus;
    }

    public Date getPartCompletedTime() {
        return partCompletedTime;
    }

    public void setPartCompletedTime(Date partCompletedTime) {
        this.partCompletedTime = partCompletedTime;
    }

    public Integer getLastCycleSpentTime() {
        return lastCycleSpentTime;
    }

    public void setLastCycleSpentTime(Integer lastCycleSpentTime) {
        this.lastCycleSpentTime = lastCycleSpentTime;
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
}