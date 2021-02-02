package com.oriri.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class SysActivity {
    @TableId
    private String activityId;
    private String activityName;
    private String activityLocation;
    private Date activityDate;


}
