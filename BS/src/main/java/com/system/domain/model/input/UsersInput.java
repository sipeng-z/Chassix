package com.system.domain.model.input;

import com.system.domain.entity.Users;

public class UsersInput extends Users{

    private String password;

    private String newPassword;

    private String userTypeResult;

    public String getUserTypeResult() {
        return userTypeResult;
    }

    public void setUserTypeResult(String userTypeResult) {
        this.userTypeResult = userTypeResult;
    }



    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
