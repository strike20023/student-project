package com.oriri.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class AssistantApplyListVO {
    private String courseId;
    private String assistantassessmentId;
    private String courseName;
    private String studentId;
    private String studentName;
    private String stuAssessment;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date stuDate;
    private String teaAssessment;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date teaDate;
    private String qualified;
}
