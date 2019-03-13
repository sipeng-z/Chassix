package com.casting.domain.model.output;

import com.casting.domain.entity.CastingCPCB7PvFurnaceChamberCurve;

import java.util.Base64;

public class CastingCPCB7PvFurnaceChamberCurveOutput extends CastingCPCB7PvFurnaceChamberCurve {

    private  String pointMatrixString;



    public String getPointMatrixString()  throws Exception{

        if (this.getPointMatrix()!=null){




            pointMatrixString = new String(this.getPointMatrix(),"utf-16");
        }

        return pointMatrixString;
    }

    public void setPointMatrixString(String pointMatrixString) {


        this.pointMatrixString = pointMatrixString == null ? null : pointMatrixString.trim();
    }




}
