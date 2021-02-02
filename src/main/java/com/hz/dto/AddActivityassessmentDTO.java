package com.oriri.dto;

import lombok.Data;

@Data
public class AddActivityassessmentDTO {
    private String activityId;
    private String studentId;
    private String activityassessmentName;
    private String photograph;
    private String comment;
}
