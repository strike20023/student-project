package com.oriri.vo;

import lombok.Data;

@Data
public class UserListVO {
    private  String userId;
    private  String userName;
    private String password;
    private String role;
    private String type;
}
