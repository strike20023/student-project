package com.oriri.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class SysCourse {
    @TableId
    private String courseId;
    private String courseName;
    private Integer studentNum;
    private String courseType;
    private String studentType;


}
