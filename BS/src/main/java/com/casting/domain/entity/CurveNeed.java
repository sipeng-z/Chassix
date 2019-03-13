package com.casting.domain.entity;

import java.util.List;

// for curve display
public class CurveNeed {


    private List<String> F;  //Furnace
    private List<String> C;  //Chamber
    private List<String> R;  //Result = for each(Furnace -Chamber)

    public List<String> getF() {
        return F;
    }

    public void setF(List<String> f) {
        F = f;
    }

    public List<String> getC() {
        return C;
    }

    public void setC(List<String> c) {
        C = c;
    }

    public List<String> getR() {
        return R;
    }

    public void setR(List<String> r) {
        R = r;
    }
}
