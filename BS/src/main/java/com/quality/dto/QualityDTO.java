package com.quality.dto;

public class QualityDTO {

    private String insertTime;
    private String machineNo;
    private Integer status;

    public String getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(String insertTime) {
        this.insertTime = insertTime;
    }

    public String getMachineNo() {
        return machineNo;
    }

    public void setMachineNo(String machineNo) {
        this.machineNo = machineNo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "QualityDTO{" +
                "insertTime='" + insertTime + '\'' +
                ", machineNo='" + machineNo + '\'' +
                ", status=" + status +
                '}';
    }
}
