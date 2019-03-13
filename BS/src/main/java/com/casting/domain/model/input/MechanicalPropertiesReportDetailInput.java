package com.casting.domain.model.input;

import com.casting.domain.entity.MechanicalPropertiesReportDetail;

import java.util.List;

public class MechanicalPropertiesReportDetailInput extends MechanicalPropertiesReportDetail {


    private List<MechanicalPropertiesReportDetailInput> contents;

    public List<MechanicalPropertiesReportDetailInput> getContents() {
        return contents;
    }

    public void setContents(List<MechanicalPropertiesReportDetailInput> contents) {
        this.contents = contents;
    }


}
