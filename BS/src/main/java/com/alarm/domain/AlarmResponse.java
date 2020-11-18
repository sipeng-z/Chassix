package com.alarm.domain;

public class AlarmResponse {

    private Long timeSum;

    private String alarmCode;

    public Long getTimeSum() {
        return timeSum;
    }

    public void setTimeSum(Long timeSum) {
        this.timeSum = timeSum;
    }

    public String getAlarmCode() {
        return alarmCode;
    }

    public void setAlarmCode(String alarmCode) {
        this.alarmCode = alarmCode;
    }
}
