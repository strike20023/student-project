package com.oriri.vo;

import lombok.Data;

@Data
public class SubjectListVO {
    private String subjectId;
    private String subjectName;
    private Integer maxassistantNum;
    private Integer projectrequirementsMin;
    private Integer activityrequirementsMin;
}
