package com.project.domain.model.input;

import com.project.domain.entity.G38V21Shift;

public class G38V21ShiftInput extends G38V21Shift {




    private String shift1;

    private String shift2;

    private String shift3;

    private Integer isDefault;


    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }



    public String getShift2() {
        return shift2;
    }

    public void setShift2(String shift2) {
        this.shift2 = shift2;
    }

    public String getShift3() {
        return shift3;
    }

    public void setShift3(String shift3) {
        this.shift3 = shift3;
    }

    public String getShift1() {

        return shift1;
    }

    public void setShift1(String shift1) {
        this.shift1 = shift1;
    }
}
