package com.casting.domain.entity;

public class CastingOEE {

    private  Double A;
    private  Double P;
    private  Double Q;

    private  Double OEE;

    private Integer unplannedDownTime;

    private Integer actuallyRunningTime;

    private Integer target;
    private Integer produced;  //produced good parts


    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }

    public Integer getProduced() {
        return produced;
    }

    public void setProduced(Integer produced) {
        this.produced = produced;
    }

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




}
