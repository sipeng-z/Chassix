package com.casting.domain.model.output;

import com.casting.domain.entity.MaterialInspectionRecord;

public class MaterialInspectionRecordOutput extends MaterialInspectionRecord {






    private String stateName;

    public String getStateName() {
        if(this.getState()!=null)
        {
            switch (this.getState())
            {
                case 0:
                    stateName="In processing";
                    break;
                case 1:
                    stateName="Passed";
                    break;
                default:
                    stateName="";
                    break;
            }
        }
        return stateName;
    }
    public void setStateName()
    {
        this.stateName = stateName == null ? null : stateName.trim();
    }

}
