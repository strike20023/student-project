package com.oriri.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class SysTeacher {

    @TableId
    private  String teacherId;
    private  String teacherName;
    private String subjectId;
    private String userId;
    private String teacherRole;

}
