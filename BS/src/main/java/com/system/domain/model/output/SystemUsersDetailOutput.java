package com.system.domain.model.output;

import com.system.domain.entity.SystemUsersDetail;

import java.math.BigDecimal;

public class SystemUsersDetailOutput extends SystemUsersDetail {


    private BigDecimal lineLimit;

    public BigDecimal getLineLimit() {
        return lineLimit;
    }

    public void setLineLimit(BigDecimal lineLimit) {
        this.lineLimit = lineLimit;
    }



    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    private Integer state;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    private String stateName;

    public String getStateName() {

        if(this.getState()!=null){
            switch (this.getState()){
                case 0: stateName="未审核";
                break;
                case 1: stateName="审核通过";
                    break;
                case 3: stateName="审核不通过";
                    break;
                    default:
                        break;
            }
        }


        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
}
