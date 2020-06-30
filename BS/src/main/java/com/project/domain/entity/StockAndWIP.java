package com.project.domain.entity;

/**
 *  Category In Stock and WIP
 */
public class StockAndWIP {

    private Long scrapStock;

    private Long scrapWIP;

    private Long sprueStock;

    private Long sprueWIP;

    private Long primaryStock;

    private Long primaryWIP;

    public Long getScrapStock() {
        return scrapStock;
    }

    public void setScrapStock(Long scrapStock) {
        this.scrapStock = scrapStock;
    }

    public Long getScrapWIP() {
        return scrapWIP;
    }

    public void setScrapWIP(Long scrapWIP) {
        this.scrapWIP = scrapWIP;
    }

    public Long getSprueStock() {
        return sprueStock;
    }

    public void setSprueStock(Long sprueStock) {
        this.sprueStock = sprueStock;
    }

    public Long getSprueWIP() {
        return sprueWIP;
    }

    public void setSprueWIP(Long sprueWIP) {
        this.sprueWIP = sprueWIP;
    }

    public Long getPrimaryStock() {
        return primaryStock;
    }

    public void setPrimaryStock(Long primaryStock) {
        this.primaryStock = primaryStock;
    }

    public Long getPrimaryWIP() {
        return primaryWIP;
    }

    public void setPrimaryWIP(Long primaryWIP) {
        this.primaryWIP = primaryWIP;
    }

    @Override
    public String toString() {
        return "StockAndWIP{" +
                "scrapStock=" + scrapStock +
                ", scrapWIP=" + scrapWIP +
                ", sprueStock=" + sprueStock +
                ", sprueWIP=" + sprueWIP +
                ", primaryStock=" + primaryStock +
                ", primaryWIP=" + primaryWIP +
                '}';
    }
}
