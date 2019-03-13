package com.system.domain.model.output;

import com.model.AppConsts;
import com.system.domain.entity.Users;

public class UsersOutput extends Users {
    private String  stateName;

    public String getStateName() {
        if (getState() != null) {
            if (getState() == AppConsts.State_Yes) {
                stateName = "已开户";
            } else if (getState() == AppConsts.IsDelete_No) {
                stateName = "未开户";
            }
        }
        return stateName;
    }

    private String hrStateName;


    private String newPassword;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }


}
