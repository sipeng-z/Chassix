package com.system.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class LoginLogs {
    private String loginLogsId;

    private String account;

    private String clientIp;

    private String clientDevice;

    private String clientDescription;

    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date loginTime;

    public String getLoginLogsId() {
        return loginLogsId;
    }

    public void setLoginLogsId(String loginLogsId) {
        this.loginLogsId = loginLogsId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp == null ? null : clientIp.trim();
    }

    public String getClientDevice() {
        return clientDevice;
    }

    public void setClientDevice(String clientDevice) {
        this.clientDevice = clientDevice == null ? null : clientDevice.trim();
    }

    public String getClientDescription() {
        return clientDescription;
    }

    public void setClientDescription(String clientDescription) {
        this.clientDescription = clientDescription == null ? null : clientDescription.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
}