package com.oriri.enums;

public enum DeletedEnum {

    DELETED_Y(1,"已删除"),
    DELETED_N(0,"未删除"),
    ;

    private int code;
    private String msg;

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    DeletedEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
