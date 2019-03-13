package com.project.domain.entity;

public class MachOEE {

    private  Double A;
    private  Double P;
    private  Double Q;

    public Double getA() {
        return A;
    }

    public void setA(Double a) {
        A = a;
    }

    public Double getP() {
        return P;
    }

    public void setP(Double p) {
        P = p;
    }

    public Double getQ() {
        return Q;
    }

    public void setQ(Double q) {
        Q = q;
    }

    public Double getOEE() {
        return OEE;
    }

    public void setOEE(Double OEE) {
        this.OEE = OEE;
    }

    private  Double OEE;





    private Integer unplannedDownTime;

    private Integer actuallyRunningTime;

    public Integer getUnplannedDownTime() {
        return unplannedDownTime;
    }

    public void setUnplannedDownTime(Integer unplannedDownTime) {
        this.unplannedDownTime = unplannedDownTime;
    }

    public Integer getActuallyRunningTime() {
        return actuallyRunningTime;
    }

    public void setActuallyRunningTime(Integer actuallyRunningTime) {
        this.actuallyRunningTime = actuallyRunningTime;
    }
}
