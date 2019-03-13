package com.casting.domain.entity;

import java.util.Date;

public class DeviceWiseSession {
    private String orderid;

    private String sessionid;

    private Date lastActivityTime;

    private String lastActivityUser;

    private Date lastUpdateTime;

    private Integer state;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public String getSessionid() {
        return sessionid;
    }

    public void setSessionid(String sessionid) {
        this.sessionid = sessionid == null ? null : sessionid.trim();
    }

    public Date getLastActivityTime() {
        return lastActivityTime;
    }

    public void setLastActivityTime(Date lastActivityTime) {
        this.lastActivityTime = lastActivityTime;
    }

    public String getLastActivityUser() {
        return lastActivityUser;
    }

    public void setLastActivityUser(String lastActivityUser) {
        this.lastActivityUser = lastActivityUser == null ? null : lastActivityUser.trim();
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}