package com.oriri.dto;

import lombok.Data;

@Data
public class AddCourseDTO {
    private String courseName;
    private Integer studentNum;
    private String courseType;
    private String studentType;
}
