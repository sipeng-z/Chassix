package com.system.domain.model.output;

import com.system.domain.entity.SystemDataLogs;

public class SystemDataLogsOutput extends SystemDataLogs {

    private String actionsTypeName;

    public String getActionsTypeName() {
        if(this.getActionType()!=null){
            switch (this.getActionType()) {
                case 0:
                    return "";
                case 1:
                    return "新增";

                case 3:
                    return "修改";

                case 5:
                    return "删除";

                default:
                    return "";
            }
        }
        return actionsTypeName;
    }



    public void setActionsTypeName(String actionName) {
        this.actionsTypeName = actionName == null ? null : actionName.trim();
    }
}
