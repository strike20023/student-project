package com.oriri.dto;

import lombok.Data;

@Data
public class UpdateProjectassessmentDTO {
    private String projectassessmentId;
    private String projectId;
    private String studentId;
    private String stuWork;
    private String expenditure;
    private String stuSignature;
    private String teaSignature;
}
