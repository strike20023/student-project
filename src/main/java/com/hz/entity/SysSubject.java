package com.oriri.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class SysSubject {
    @TableId
    private String subjectId;
    private String subjectName;
    private Integer maxassistantNum;
    private Integer projectrequirementsMin;
    private Integer activityrequirementsMin;

}
