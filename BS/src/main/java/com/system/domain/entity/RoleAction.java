package com.system.domain.entity;

public class RoleAction {
    private String roleActionId;

    private String roleId;

    private String menuId;

    private String actionId;

    public String getRoleActionId() {
        return roleActionId;
    }

    public void setRoleActionId(String roleActionId) {
        this.roleActionId = roleActionId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }
}