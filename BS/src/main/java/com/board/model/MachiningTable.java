package com.board.model;

public class MachiningTable {

    private Integer id;

    private String equipment;

    private String product;

    private Integer planProduct;

    private Integer badProduct;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getBadProduct() {
        return badProduct;
    }

    public void setBadProduct(Integer badProduct) {
        this.badProduct = badProduct;
    }

    @Override
    public String toString() {
        return "MachiningTable{" +
                "id=" + id +
                ", equipment='" + equipment + '\'' +
                ", product='" + product + '\'' +
                ", planProduct=" + planProduct +
                ", badProduct=" + badProduct +
                '}';
    }
}
