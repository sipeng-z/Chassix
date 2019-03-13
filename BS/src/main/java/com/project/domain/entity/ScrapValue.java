package com.project.domain.entity;

public class ScrapValue {

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    private  String Name;  //reason description
    private  Integer value;//quantity
    private  String Line ; //item number
    private String entrydate; //input date

    public String getLine() {
        return Line;
    }

    public void setLine(String Line) {
        this.Line = Line;
    }

    public String getEntrydate() {
        return entrydate;
    }

    public void setEntrydate(String entrydate) {
        this.entrydate = entrydate;
    }
}
