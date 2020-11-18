package com.board.model;

public class TableDTO {

    private String equipment;

    private String product;

    private Integer planProduct;

    private Integer realProduct;

    private Integer badProduct;

    private double failureRate;

    private double finishRate;

    private Integer status;

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getPlanProduct() {
        return planProduct;
    }

    public void setPlanProduct(Integer planProduct) {
        this.planProduct = planProduct;
    }

    public Integer getRealProduct() {
        return realProduct;
    }

    public void setRealProduct(Integer realProduct) {
        this.realProduct = realProduct;
    }

    public Integer getBadProduct() {
        return badProduct;
    }

    public void setBadProduct(Integer badProduct) {
        this.badProduct = badProduct;
    }

    public double getFailureRate() {
        return failureRate;
    }

    public void setFailureRate(double failureRate) {
        this.failureRate = failureRate;
    }

    public double getFinishRate() {
        return finishRate;
    }

    public void setFinishRate(double finishRate) {
        this.finishRate = finishRate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
