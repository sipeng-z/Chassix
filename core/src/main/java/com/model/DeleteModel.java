package com.model;


import java.util.Date;

public class DeleteModel {

	private String lastupdatedbyuserid;
	private String lastupdatedbyusername;
	private Date lastupdateddatetime;
	private String id;
	private Integer isDelete;
	

	public String getLastupdatedbyuserid() {
		return lastupdatedbyuserid;
	}

	public void setLastupdatedbyuserid(String lastupdatedbyuserid) {
		this.lastupdatedbyuserid = lastupdatedbyuserid;
	}

	public String getLastupdatedbyusername() {
		return lastupdatedbyusername;
	}

	public void setLastupdatedbyusername(String lastupdatedbyusername) {
		this.lastupdatedbyusername = lastupdatedbyusername;
	}

	public Date getLastupdateddatetime() {
		return lastupdateddatetime;
	}

	public void setLastupdateddatetime(Date lastupdateddatetime) {
		this.lastupdateddatetime = lastupdateddatetime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
}
