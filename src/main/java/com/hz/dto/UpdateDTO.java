package com.oriri.dto;

import lombok.Data;

@Data
public class UpdateDTO {
    private String userId;
    private String userName;
    private String password;
    private String role;
}
