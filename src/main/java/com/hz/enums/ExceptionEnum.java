package com.oriri.enums;

public enum ExceptionEnum {
    SYSTEM(0, "系统异常"),
    BUSINESS(1, "业务异常");

    private int code;
    private String msg;

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    private ExceptionEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
