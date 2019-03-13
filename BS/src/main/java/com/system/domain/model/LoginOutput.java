package com.system.domain.model;

import com.model.AppConsts;

public class LoginOutput {

	
	private String authorization="";
	private String userid= AppConsts.defaultGuId;
	private String  userinfo;
	private String openid ="";

	
	private String cookieName="";
	private String cookieValue="";
	private Integer cookieExpires=0;
	
	

	public String getAuthorization() {
		return authorization;
	}

	public void setAuthorization(String authorization) {
		this.authorization = authorization;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getCookieName() {
		return cookieName;
	}

	public void setCookieName(String cookieName) {
		this.cookieName = cookieName;
	}

	public String getCookieValue() {
		return cookieValue;
	}

	public void setCookieValue(String cookieValue) {
		this.cookieValue = cookieValue;
	}

	public Integer getCookieExpires() {
		return cookieExpires;
	}

	public void setCookieExpires(Integer cookieExpires) {
		this.cookieExpires = cookieExpires;
	}

	public String getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(String userinfo) {
		this.userinfo = userinfo;
	}

	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
}
