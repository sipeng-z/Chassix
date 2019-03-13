package com.utils;

import java.io.Serializable;

public class ResponseObject implements Serializable{

	public interface Code{
		public final static int Success  = 200;
		public final static int Error  = 500;		
	}
	
	public static ResponseObject  SUCCESS = ResponseObject.SUCCESS(null);
	public static ResponseObject  PERMISSION_ERROR = ResponseObject.ERROR("您没有该权限", null);
	public static ResponseObject  PASSWORD_ERROR = ResponseObject.ERROR("账户密码不正确", null);
	/**
	 * 
	 */
	private static final long serialVersionUID = -5989148975314891993L;

	public static ResponseObject SUCCESS(Object data){
		ResponseObject ro = new ResponseObject();
		ro.setCode(Code.Success);
		ro.setMsg("success");
		ro.setData(data);
		return ro;
	}
	public static ResponseObject ERROR(String message,Object data){
		return ResponseObject.ERROR(Code.Error, message, data);
	}
	public static ResponseObject ERROR(int code,String message,Object data){
		ResponseObject ro = new ResponseObject();
		ro.setCode(code);
		ro.setMsg(message);
		ro.setData(data);
		return ro;
	}
	
	
	public ResponseObject() {

	}

	public ResponseObject(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public ResponseObject(int code, String msg, Object data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	private int code;

	private String msg;

	private Object data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "ResponseObject [code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}

}
