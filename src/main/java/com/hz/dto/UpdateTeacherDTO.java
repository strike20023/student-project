package com.oriri.dto;

import lombok.Data;

@Data
public class UpdateTeacherDTO {
    private String teacherId;
    private String teacherName;
    private String subjectId;
    private String roleId;
}
