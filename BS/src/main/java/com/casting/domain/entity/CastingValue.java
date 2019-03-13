package com.casting.domain.entity;

public class CastingValue {
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

    private  String Name;
    private  Integer value;
}
