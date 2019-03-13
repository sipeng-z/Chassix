package com.project.domain.workbench;


// request domain
public class forapi {

    public com.project.domain.workbench.params getParams() {
        return params;
    }

    public void setParams(com.project.domain.workbench.params params) {
        this.params = params;
    }

    private  params params;

    private String command;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
