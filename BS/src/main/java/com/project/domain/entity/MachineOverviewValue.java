package com.project.domain.entity;


public class MachineOverviewValue {

    private String name;
    private Integer status;
    private String shift1OEE;
    private String shift2OEE;
    private String shift3OEE;
    private String remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getShift1OEE() {
        return shift1OEE;
    }

    public void setShift1OEE(String shift1OEE) {
        this.shift1OEE = shift1OEE;
    }

    public String getShift2OEE() {
        return shift2OEE;
    }

    public void setShift2OEE(String shift2OEE) {
        this.shift2OEE = shift2OEE;
    }

    public String getShift3OEE() {
        return shift3OEE;
    }

    public void setShift3OEE(String shift3OEE) {
        this.shift3OEE = shift3OEE;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
