package com.authorize;

import com.model.AppConsts;

public class CurrentUserInfo {

	private String userId = AppConsts.defaultGuId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
