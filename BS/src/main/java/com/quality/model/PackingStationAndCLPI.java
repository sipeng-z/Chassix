package com.quality.model;

import java.util.Date;

public class PackingStationAndCLPI {
    private Integer itemno;

    private String partType;

    private String soNumber;

    private String dmContent;

    private String lotNo;

    private Integer countBaseOnBox;

    private Integer layerNo;

    private Date insertTime;

    private Date updatedTime;

    private String dataSource;

    private Integer readerNo;

    private Integer lastProcessState;

    public Integer getItemno() {
        return itemno;
    }

    public void setItemno(Integer itemno) {
        this.itemno = itemno;
    }

    public String getPartType() {
        return partType;
    }

    public void setPartType(String partType) {
        this.partType = partType == null ? null : partType.trim();
    }

    public String getSoNumber() {
        return soNumber;
    }

    public void setSoNumber(String soNumber) {
        this.soNumber = soNumber == null ? null : soNumber.trim();
    }

    public String getDmContent() {
        return dmContent;
    }

    public void setDmContent(String dmContent) {
        this.dmContent = dmContent == null ? null : dmContent.trim();
    }

    public String getLotNo() {
        return lotNo;
    }

    public void setLotNo(String lotNo) {
        this.lotNo = lotNo == null ? null : lotNo.trim();
    }

    public Integer getCountBaseOnBox() {
        return countBaseOnBox;
    }

    public void setCountBaseOnBox(Integer countBaseOnBox) {
        this.countBaseOnBox = countBaseOnBox;
    }

    public Integer getLayerNo() {
        return layerNo;
    }

    public void setLayerNo(Integer layerNo) {
        this.layerNo = layerNo;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource == null ? null : dataSource.trim();
    }

    public Integer getReaderNo() {
        return readerNo;
    }

    public void setReaderNo(Integer readerNo) {
        this.readerNo = readerNo;
    }

    public Integer getLastProcessState() {
        return lastProcessState;
    }

    public void setLastProcessState(Integer lastProcessState) {
        this.lastProcessState = lastProcessState;
    }

}