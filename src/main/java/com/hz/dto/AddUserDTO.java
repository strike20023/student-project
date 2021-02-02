package com.oriri.dto;

import lombok.Data;

@Data
public class AddUserDTO {
    private String userName;
    private String name;
    private String password;
    private String role;
}
