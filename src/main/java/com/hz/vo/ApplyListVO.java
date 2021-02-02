package com.oriri.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ApplyListVO {
    private String assistantapplicationId;
    private String courseId;
    private String courseName;
    private String studentId;
    private String studentName;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date applyTime;

}
