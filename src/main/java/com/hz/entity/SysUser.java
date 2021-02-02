package com.oriri.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;


@Data
public class SysUser {
    @TableId
    private  String userId;
    private  String userName;
    private String password;
    private String role;
}
