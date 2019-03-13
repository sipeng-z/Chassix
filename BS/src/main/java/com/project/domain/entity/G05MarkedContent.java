package com.project.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class G05MarkedContent {
    private Integer itemno;

    private String dateString;

    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date producedTime;

    public Integer getItemno() {
        return itemno;
    }

    public void setItemno(Integer itemno) {
        this.itemno = itemno;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString == null ? null : dateString.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getProducedTime() {
        return producedTime;
    }

    public void setProducedTime(Date producedTime) {
        this.producedTime = producedTime;
    }
}