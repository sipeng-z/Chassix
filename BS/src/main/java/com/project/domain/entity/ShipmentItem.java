package com.project.domain.entity;

public class ShipmentItem {
    private String shipmentId;

    private String plant;

    private String warhouse;

    private String status;

    private String item;

    private String name;

    private String defaultStatus;

    private String recentSituation;

    public String getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(String shipmentId) {
        this.shipmentId = shipmentId == null ? null : shipmentId.trim();
    }

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant == null ? null : plant.trim();
    }

    public String getWarhouse() {
        return warhouse;
    }

    public void setWarhouse(String warhouse) {
        this.warhouse = warhouse == null ? null : warhouse.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item == null ? null : item.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDefaultStatus() {
        return defaultStatus;
    }

    public void setDefaultStatus(String defaultStatus) {
        this.defaultStatus = defaultStatus == null ? null : defaultStatus.trim();
    }

    public String getRecentSituation() {
        return recentSituation;
    }

    public void setRecentSituation(String recentSituation) {
        this.recentSituation = recentSituation == null ? null : recentSituation.trim();
    }
}