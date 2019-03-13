package com.system.domain.model.output;

import com.model.AppConsts;

public class AuthorizeActionOutput {

	private String  actionid=AppConsts.defaultGuId;
	private  String name="";
	private String code="";
	
	public String getActionid() {
		return actionid;
	}
	public void setActionid(String actionid) {
		this.actionid = actionid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
