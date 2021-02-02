package com.oriri.dto;

import lombok.Data;

@Data
public class AddSubjectDTO {
    private String subjectName;
    private Integer maxassistantNum;
    private Integer projectrequirementsMin;
    private Integer activityrequirementsMin;
}
