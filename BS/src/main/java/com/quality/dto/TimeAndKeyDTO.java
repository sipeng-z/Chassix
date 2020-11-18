package com.quality.dto;

public class TimeAndKeyDTO {
    private String insertTime;
    private String machineNo;

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

    @Override
    public String toString() {
        return "TimeAndKeyDTO{" +
                "insertTime='" + insertTime + '\'' +
                ", machineNo='" + machineNo + '\'' +
                '}';
    }
}
