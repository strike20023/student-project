package com.oriri.service;

import com.github.pagehelper.PageInfo;
import com.oriri.dto.*;
import com.oriri.vo.ActivityListVO;
import com.oriri.vo.ActivityassessmentListVO;

public interface ActivityService {

    void addActivity(AddActivityDTO dto);
    void addActivityassessment(AddActivityassessmentDTO dto);

    void updateActivity(UpdateActivityDTO dto);

    PageInfo<ActivityListVO> getActivityListByPage(ActicitySearchDTO dto, Integer page, Integer rows);
    PageInfo<ActivityassessmentListVO>getActivityassessmentListByPage(ActivityassessmentSearchDTO dto, Integer page, Integer rows);
    void deleteActivity(ActivityIdDTO dto);
}
