package com.oriri.enums;

public enum RoleTypeEnum {
    ROLE_STUDENT("S","学生"),
    ROLE_TEACHER("T","老师"),
    ;

    private String code;
    private String msg;

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    RoleTypeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
