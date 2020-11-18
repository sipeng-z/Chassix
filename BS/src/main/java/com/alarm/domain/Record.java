package com.alarm.domain;

public class Record {

    private Integer inspector;
    private Integer operator;
    private String lineRadio;
    private Integer stationRadio;
    private Integer Crucible;
    private double Density;
    private double Temperature;
    private Integer mold;
    private double Silicon;
    private double Titanium;
    private double Copper;
    private double Iron;
    private double Stronium;
    private double Manganese;
    private double Magnesium;
    private double Zinc;
    private String batch;

    public Integer getInspector() {
        return inspector;
    }

    public void setInspector(Integer inspector) {
        this.inspector = inspector;
    }

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
        this.operator = operator;
    }

    public String getLineRadio() {
        return lineRadio;
    }

    public void setLineRadio(String lineRadio) {
        this.lineRadio = lineRadio;
    }

    public Integer getStationRadio() {
        return stationRadio;
    }

    public void setStationRadio(Integer stationRadio) {
        this.stationRadio = stationRadio;
    }

    public Integer getCrucible() {
        return Crucible;
    }

    public void setCrucible(Integer crucible) {
        Crucible = crucible;
    }

    public double getDensity() {
        return Density;
    }

    public void setDensity(double density) {
        Density = density;
    }

    public double getTemperature() {
        return Temperature;
    }

    public void setTemperature(double temperature) {
        Temperature = temperature;
    }

    public Integer getMold() {
        return mold;
    }

    public void setMold(Integer mold) {
        this.mold = mold;
    }

    public double getSilicon() {
        return Silicon;
    }

    public void setSilicon(double silicon) {
        Silicon = silicon;
    }

    public double getTitanium() {
        return Titanium;
    }

    public void setTitanium(double titanium) {
        Titanium = titanium;
    }

    public double getCopper() {
        return Copper;
    }

    public void setCopper(double copper) {
        Copper = copper;
    }

    public double getIron() {
        return Iron;
    }

    public void setIron(double iron) {
        Iron = iron;
    }

    public double getStronium() {
        return Stronium;
    }

    public void setStronium(double stronium) {
        Stronium = stronium;
    }

    public double getManganese() {
        return Manganese;
    }

    public void setManganese(double manganese) {
        Manganese = manganese;
    }

    public double getMagnesium() {
        return Magnesium;
    }

    public void setMagnesium(double magnesium) {
        Magnesium = magnesium;
    }

    public double getZinc() {
        return Zinc;
    }

    public void setZinc(double zinc) {
        Zinc = zinc;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    @Override
    public String toString() {
        return "Record{" +
                "inspector=" + inspector +
                ", operator=" + operator +
                ", lineRadio='" + lineRadio + '\'' +
                ", stationRadio=" + stationRadio +
                ", Crucible=" + Crucible +
                ", Density=" + Density +
                ", Temperature=" + Temperature +
                ", mold=" + mold +
                ", Silicon=" + Silicon +
                ", Titanium=" + Titanium +
                ", Copper=" + Copper +
                ", Iron=" + Iron +
                ", Stronium=" + Stronium +
                ", Manganese=" + Manganese +
                ", Magnesium=" + Magnesium +
                ", Zinc=" + Zinc +
                '}';
    }
}
