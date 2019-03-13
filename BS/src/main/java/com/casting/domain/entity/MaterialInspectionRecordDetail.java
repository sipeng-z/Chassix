package com.casting.domain.entity;

public class MaterialInspectionRecordDetail {
    private String detailId;

    private String batchNumber;

    private String urface;

    private String mustiness;

    private String clinker;

    private String inclusion;

    private String si;

    private String fe;

    private String mg;

    private String ti;

    private String mn;

    private String cu;

    private String othersSingle;

    private String othersTotal;

    private String shrinkage;

    private String rediation;

    public String getDetailId() {
        return detailId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId == null ? null : detailId.trim();
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber == null ? null : batchNumber.trim();
    }

    public String getUrface() {
        return urface;
    }

    public void setUrface(String urface) {
        this.urface = urface == null ? null : urface.trim();
    }

    public String getMustiness() {
        return mustiness;
    }

    public void setMustiness(String mustiness) {
        this.mustiness = mustiness == null ? null : mustiness.trim();
    }

    public String getClinker() {
        return clinker;
    }

    public void setClinker(String clinker) {
        this.clinker = clinker == null ? null : clinker.trim();
    }

    public String getInclusion() {
        return inclusion;
    }

    public void setInclusion(String inclusion) {
        this.inclusion = inclusion == null ? null : inclusion.trim();
    }

    public String getSi() {
        return si;
    }

    public void setSi(String si) {
        this.si = si == null ? null : si.trim();
    }

    public String getFe() {
        return fe;
    }

    public void setFe(String fe) {
        this.fe = fe == null ? null : fe.trim();
    }

    public String getMg() {
        return mg;
    }

    public void setMg(String mg) {
        this.mg = mg == null ? null : mg.trim();
    }

    public String getTi() {
        return ti;
    }

    public void setTi(String ti) {
        this.ti = ti == null ? null : ti.trim();
    }

    public String getMn() {
        return mn;
    }

    public void setMn(String mn) {
        this.mn = mn == null ? null : mn.trim();
    }

    public String getCu() {
        return cu;
    }

    public void setCu(String cu) {
        this.cu = cu == null ? null : cu.trim();
    }

    public String getOthersSingle() {
        return othersSingle;
    }

    public void setOthersSingle(String othersSingle) {
        this.othersSingle = othersSingle == null ? null : othersSingle.trim();
    }

    public String getOthersTotal() {
        return othersTotal;
    }

    public void setOthersTotal(String othersTotal) {
        this.othersTotal = othersTotal == null ? null : othersTotal.trim();
    }

    public String getShrinkage() {
        return shrinkage;
    }

    public void setShrinkage(String shrinkage) {
        this.shrinkage = shrinkage == null ? null : shrinkage.trim();
    }

    public String getRediation() {
        return rediation;
    }

    public void setRediation(String rediation) {
        this.rediation = rediation == null ? null : rediation.trim();
    }
}