package com.quality.dto;

public class StatusDTO {
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StatusDTO{" +
                "status=" + status +
                '}';
    }
}
