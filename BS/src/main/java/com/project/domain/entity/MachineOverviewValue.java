package com.project.domain.entity;


public class MachineOverviewValue {

    private String name;
    private Integer status;
    private String shift1OEE;
    private Integer shift1QT;
    private String shift2OEE;
    private Integer shift2QT;
    private String shift3OEE;
    private Integer shift3QT;
    private String cycleTime;

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

    public Integer getShift1QT() {
        return shift1QT;
    }

    public void setShift1QT(Integer shift1QT) {
        this.shift1QT = shift1QT;
    }

    public String getShift2OEE() {
        return shift2OEE;
    }

    public void setShift2OEE(String shift2OEE) {
        this.shift2OEE = shift2OEE;
    }

    public Integer getShift2QT() {
        return shift2QT;
    }

    public void setShift2QT(Integer shift2QT) {
        this.shift2QT = shift2QT;
    }

    public String getShift3OEE() {
        return shift3OEE;
    }

    public void setShift3OEE(String shift3OEE) {
        this.shift3OEE = shift3OEE;
    }

    public Integer getShift3QT() {
        return shift3QT;
    }

    public void setShift3QT(Integer shift3QT) {
        this.shift3QT = shift3QT;
    }

    public String getCycleTime() {
        return cycleTime;
    }

    public void setCycleTime(String cycleTime) {
        this.cycleTime = cycleTime;
    }
}
