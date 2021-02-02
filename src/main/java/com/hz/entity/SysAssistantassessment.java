package com.oriri.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class SysAssistantassessment {
    @TableId
    private String assistantassessmentId;
    private String studentId;
    private String courseId;
    private String stuAssessment;
    private Date stuDate;
    private String teaAssessment;
    private Date teaDate;
    private String qualified;
}
