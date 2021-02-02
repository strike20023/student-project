package com.oriri.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class SysProjectassessment {
    @TableId
    private String projectassessmentId;
    private String projectId;
    private String studentId;
    private String stuWork;
    private String expenditure;
    private String stuSignature;
    private String teaSignature;
}
