package com.model;


import java.util.Date;

public class AuditModel {

	private Integer auditstate;
	private String auditbyuserid;
	private String auditbyusername;
	private Date auditdatetime;
	private String id;
	
	
	private String lastupdatedbyuserid;
	private String lastupdatedbyusername;
	private Date lastupdateddatetime;
	

	public Integer getAuditstate() {
		return auditstate;
	}

	public void setAuditstate(Integer auditstate) {
		this.auditstate = auditstate;
	}

	public String getAuditbyuserid() {
		return auditbyuserid;
	}

	public void setAuditbyuserid(String auditbyuserid) {
		this.auditbyuserid = auditbyuserid;
	}

	public String getAuditbyusername() {
		return auditbyusername;
	}

	public void setAuditbyusername(String auditbyusername) {
		this.auditbyusername = auditbyusername;
	}

	public Date getAuditdatetime() {
		return auditdatetime;
	}

	public void setAuditdatetime(Date auditdatetime) {
		this.auditdatetime = auditdatetime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	
	
}
