package com.oriri.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class SysDict {
    @TableId
    private String key;
    private String value;
    private Integer mark;
}
