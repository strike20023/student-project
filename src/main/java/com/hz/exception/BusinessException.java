package com.oriri.exception;

import java.io.Serializable;

public class BusinessException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1017100175563909925L;
    private Object data;
    private String code;
    private String message;

    public BusinessException(String code, Object data, String message, Object... params) {
        this.data = data;
        this.code = code;
        this.message = message;
    }

    public BusinessException(ErrorInfo errorInfo, Object... params) {
        this.code = errorInfo.getCode();
        this.message = errorInfo.getMessage();
    }

    public BusinessException(Object data, ErrorInfo errorInfo, Object... params) {
        this.data = data;
        this.code = errorInfo.getCode();
        this.message = errorInfo.getMessage();
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return this.data;
    }
}
