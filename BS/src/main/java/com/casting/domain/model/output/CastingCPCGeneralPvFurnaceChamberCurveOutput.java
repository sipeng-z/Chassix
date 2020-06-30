package com.casting.domain.model.output;

import com.casting.domain.entity.CastingCPCGeneralPvFurnaceChamberCurve;

public class CastingCPCGeneralPvFurnaceChamberCurveOutput extends CastingCPCGeneralPvFurnaceChamberCurve {
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
