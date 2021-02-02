package com.oriri.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class SysProject {
    @TableId
    private  String projectId;
    private String projectName;
    private String projectType;
    private Date projectStart;
    private Date projectEnd;

}
