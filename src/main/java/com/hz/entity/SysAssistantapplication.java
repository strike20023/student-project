package com.oriri.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class SysAssistantapplication {
    @TableId
    private  String assistantapplicationId;
    private String courseId;
    private String studentId;
    private Date applyTime;
}
