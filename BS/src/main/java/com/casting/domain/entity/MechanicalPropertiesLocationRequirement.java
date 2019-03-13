package com.casting.domain.entity;

public class MechanicalPropertiesLocationRequirement {
    private String requirementId;

    private String partName;

    private Integer requireQuantity;

    private String ysa;

    private String ysb;

    private String ysc;

    private String ysd;

    private String utsa;

    private String utsb;

    private String utsc;

    private String utsd;

    private String elongationa;

    private String elongationb;

    private String elongationc;

    private String elongationd;

    private Integer hb;

    public String getRequirementId() {
        return requirementId;
    }

    public void setRequirementId(String requirementId) {
        this.requirementId = requirementId == null ? null : requirementId.trim();
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName == null ? null : partName.trim();
    }

    public Integer getRequireQuantity() {
        return requireQuantity;
    }

    public void setRequireQuantity(Integer requireQuantity) {
        this.requireQuantity = requireQuantity;
    }

    public String getYsa() {
        return ysa;
    }

    public void setYsa(String ysa) {
        this.ysa = ysa == null ? null : ysa.trim();
    }

    public String getYsb() {
        return ysb;
    }

    public void setYsb(String ysb) {
        this.ysb = ysb == null ? null : ysb.trim();
    }

    public String getYsc() {
        return ysc;
    }

    public void setYsc(String ysc) {
        this.ysc = ysc == null ? null : ysc.trim();
    }

    public String getYsd() {
        return ysd;
    }

    public void setYsd(String ysd) {
        this.ysd = ysd == null ? null : ysd.trim();
    }

    public String getUtsa() {
        return utsa;
    }

    public void setUtsa(String utsa) {
        this.utsa = utsa == null ? null : utsa.trim();
    }

    public String getUtsb() {
        return utsb;
    }

    public void setUtsb(String utsb) {
        this.utsb = utsb == null ? null : utsb.trim();
    }

    public String getUtsc() {
        return utsc;
    }

    public void setUtsc(String utsc) {
        this.utsc = utsc == null ? null : utsc.trim();
    }

    public String getUtsd() {
        return utsd;
    }

    public void setUtsd(String utsd) {
        this.utsd = utsd == null ? null : utsd.trim();
    }

    public String getElongationa() {
        return elongationa;
    }

    public void setElongationa(String elongationa) {
        this.elongationa = elongationa == null ? null : elongationa.trim();
    }

    public String getElongationb() {
        return elongationb;
    }

    public void setElongationb(String elongationb) {
        this.elongationb = elongationb == null ? null : elongationb.trim();
    }

    public String getElongationc() {
        return elongationc;
    }

    public void setElongationc(String elongationc) {
        this.elongationc = elongationc == null ? null : elongationc.trim();
    }

    public String getElongationd() {
        return elongationd;
    }

    public void setElongationd(String elongationd) {
        this.elongationd = elongationd == null ? null : elongationd.trim();
    }

    public Integer getHb() {
        return hb;
    }

    public void setHb(Integer hb) {
        this.hb = hb;
    }
}