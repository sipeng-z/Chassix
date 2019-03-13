package com.casting.domain.entity;

//for cpc real time value, status,cycle time,stand by ,positon
public class CPCValue {

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private  String Name;
    private  String value;
}
