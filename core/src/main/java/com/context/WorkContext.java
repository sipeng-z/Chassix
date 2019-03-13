package com.context;

import com.model.AppConsts;

import java.util.ArrayList;
import java.util.List;

public class WorkContext {
	
	private  String userId= AppConsts.defaultGuId;
	private String account="";
	private String nickname="";
	private String name="";
	private List<Integer> organIdList;
	private boolean isSuperAdministrator=false;




	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean isSuperAdministrator() {
		return isSuperAdministrator;
	}

	public void setSuperAdministrator(boolean isSuperAdministrator) {
		this.isSuperAdministrator = isSuperAdministrator;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
