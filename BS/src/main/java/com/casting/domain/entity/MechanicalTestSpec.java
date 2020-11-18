package com.casting.domain.entity;

public class MechanicalTestSpec {

    private Integer id;

    private String partname;

    private String ys;

    private String uts;

    private String elongation;

    private String hb;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPartname() {
        return partname;
    }

    public void setPartname(String partname) {
        this.partname = partname;
    }

    public String getYs() {
        return ys;
    }

    public void setYs(String ys) {
        this.ys = ys;
    }

    public String getUts() {
        return uts;
    }

    public void setUts(String uts) {
        this.uts = uts;
    }

    public String getElongation() {
        return elongation;
    }

    public void setElongation(String elongation) {
        this.elongation = elongation;
    }

    public String getHb() {
        return hb;
    }

    public void setHb(String hb) {
        this.hb = hb;
    }
}
