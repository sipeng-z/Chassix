package com.alarm.domain;

public class MTTRResponse {

    private Integer MTTR;

    private Integer AlarmTimes;

    public Integer getMTTR() {
        return MTTR;
    }

    public void setMTTR(Integer MTTR) {
        this.MTTR = MTTR;
    }

    public Integer getAlarmTimes() {
        return AlarmTimes;
    }

    public void setAlarmTimes(Integer alarmTimes) {
        AlarmTimes = alarmTimes;
    }
}
