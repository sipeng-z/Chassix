package com.system.domain.entity;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.system.utils.DataSerializerUtils;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Size;

public class CastingChemistryUse {

  private Integer checkno;
  private Integer inspector;
  private Integer operator;
  private String line;
  private Integer station;
  private String crucibleId;
  private Float density;
  private double temperature;
  private Integer kmold;
  private Float silicon;
  private Float titanium;
  private Float copper;
  private Float iron;
  private Float stronium;
  private Float manganese;
  private Float magnesium;
  private Float zinc;
  private String insertTime;
  private String dateString;
  private String batchId;
  private Integer used;
  private String usedStation;
  private String usedTime;


  public Integer getCheckno() {
    return checkno;
  }

  public void setCheckno(Integer checkno) {
    this.checkno = checkno;
  }

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

  public String getLine() {
    return line;
  }

  public void setLine(String line) {
    this.line = line;
  }

  public Integer getStation() {
    return station;
  }

  public void setStation(Integer station) {
    this.station = station;
  }

  public String getCrucibleId() {
    return crucibleId;
  }

  public void setCrucibleId(String crucibleId) {
    this.crucibleId = crucibleId;
  }

  public Float getDensity() {
    return density;
  }

  public void setDensity(Float density) {
    this.density = density;
  }

  public double getTemperature() {
    return temperature;
  }

  public void setTemperature(double temperature) {
    this.temperature = temperature;
  }

  public Integer getKmold() {
    return kmold;
  }

  public void setKmold(Integer kmold) {
    this.kmold = kmold;
  }

  public Float getSilicon() {
    return silicon;
  }

  public void setSilicon(Float silicon) {
    this.silicon = silicon;
  }

  public Float getTitanium() {
    return titanium;
  }

  public void setTitanium(Float titanium) {
    this.titanium = titanium;
  }

  public Float getCopper() {
    return copper;
  }

  public void setCopper(Float copper) {
    this.copper = copper;
  }

  public Float getIron() {
    return iron;
  }

  public void setIron(Float iron) {
    this.iron = iron;
  }

  public Float getStronium() {
    return stronium;
  }

  public void setStronium(Float stronium) {
    this.stronium = stronium;
  }

  public Float getManganese() {
    return manganese;
  }

  public void setManganese(Float manganese) {
    this.manganese = manganese;
  }

  public Float getMagnesium() {
    return magnesium;
  }

  public void setMagnesium(Float magnesium) {
    this.magnesium = magnesium;
  }

  public Float getZinc() {
    return zinc;
  }

  public void setZinc(Float zinc) {
    this.zinc = zinc;
  }

  public String getInsertTime() {
    return insertTime;
  }

  public void setInsertTime(String insertTime) {
    this.insertTime = insertTime;
  }

  public String getDateString() {
    return dateString;
  }

  public void setDateString(String dateString) {
    this.dateString = dateString;
  }

  public String getBatchId() {
    return batchId;
  }

  public void setBatchId(String batchId) {
    this.batchId = batchId;
  }

  public Integer getUsed() {
    return used;
  }

  public void setUsed(Integer used) {
    this.used = used;
  }

  public String getUsedStation() {
    return usedStation;
  }

  public void setUsedStation(String usedStation) {
    this.usedStation = usedStation;
  }

  public String getUsedTime() {
    return usedTime;
  }

  public void setUsedTime(String usedTime) {
    this.usedTime = usedTime;
  }
}
