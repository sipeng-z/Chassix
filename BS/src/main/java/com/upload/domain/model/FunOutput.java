package com.upload.domain.model;

import java.io.Serializable;

/**
 * 方法统一返参
 * @param <T>
 */
public class  FunOutput<T> implements Serializable {

    private boolean success=false;
    public boolean getSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }

    private String message="操作失败";
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    private T data;
    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
}
