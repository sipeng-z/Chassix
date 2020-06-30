package com.project.domain.entity;

import java.util.Date;

public class RawMaterialMonitoring {

    private Date rundate;

    private String site;

    private String house;

    private String item;

    private String itmdesc;

    private String fordesc;

    private String pgm;

    private String pgmdesc1;

    private String locn;

    private String batchlot;

    private String quantity;

    public Date getRundate() {
        return rundate;
    }

    public void setRundate(Date rundate) {
        this.rundate = rundate;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getItmdesc() {
        return itmdesc;
    }

    public void setItmdesc(String itmdesc) {
        this.itmdesc = itmdesc;
    }

    public String getFordesc() {
        return fordesc;
    }

    public void setFordesc(String fordesc) {
        this.fordesc = fordesc;
    }

    public String getPgm() {
        return pgm;
    }

    public void setPgm(String pgm) {
        this.pgm = pgm;
    }

    public String getPgmdesc1() {
        return pgmdesc1;
    }

    public void setPgmdesc1(String pgmdesc1) {
        this.pgmdesc1 = pgmdesc1;
    }

    public String getLocn() {
        return locn;
    }

    public void setLocn(String locn) {
        this.locn = locn;
    }

    public String getBatchlot() {
        return batchlot;
    }

    public void setBatchlot(String batchlot) {
        this.batchlot = batchlot;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
