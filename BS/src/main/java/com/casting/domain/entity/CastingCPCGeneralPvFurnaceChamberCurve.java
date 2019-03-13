package com.casting.domain.entity;

public class CastingCPCGeneralPvFurnaceChamberCurve {



    private Integer itemno;

    private String timeString;

    private String furnaceChamber;

    private Integer recordno;

    private byte[] pointMatrix;

    public Integer getItemno() {
        return itemno;
    }

    public void setItemno(Integer itemno) {
        this.itemno = itemno;
    }

    public String getTimeString() {
        return timeString;
    }

    public void setTimeString(String timeString) {
        this.timeString = timeString == null ? null : timeString.trim();
    }

    public String getFurnaceChamber() {
        return furnaceChamber;
    }

    public void setFurnaceChamber(String furnaceChamber) {
        this.furnaceChamber = furnaceChamber == null ? null : furnaceChamber.trim();
    }

    public Integer getRecordno() {
        return recordno;
    }

    public void setRecordno(Integer recordno) {
        this.recordno = recordno;
    }

    public byte[] getPointMatrix() {
        return pointMatrix;
    }

    public void setPointMatrix(byte[] pointMatrix) {
        this.pointMatrix = pointMatrix;
    }




}
