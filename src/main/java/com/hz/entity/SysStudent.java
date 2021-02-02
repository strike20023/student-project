package com.oriri.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class SysStudent {
    @TableId
    private String studentId;
    private String studentName;
    private String teacherId;
    private String userId;
    private String subjectId;

}
