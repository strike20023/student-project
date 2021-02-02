package com.oriri.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ActicitySearchDTO {
    private  String activityId;
    private String activityName;
    private String activityLocation;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date activityDate;
}
