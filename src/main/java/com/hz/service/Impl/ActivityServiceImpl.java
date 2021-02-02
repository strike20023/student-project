package com.oriri.service.Impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oriri.dto.*;
import com.oriri.entity.SysActivity;
import com.oriri.entity.SysActivityassessment;
import com.oriri.mapper.ActicityMapper;
import com.oriri.mapper.ActivityassessmentMapper;
import com.oriri.service.ActivityService;
import com.oriri.vo.ActivityListVO;
import com.oriri.vo.ActivityassessmentListVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ActivityServiceImpl extends ServiceImpl<ActicityMapper, SysActivity> implements ActivityService {


    @Resource
    private ActivityassessmentMapper activityassessmentMapper;

    @Override
    public void addActivity(AddActivityDTO dto) {
        SysActivity sysActivity = new SysActivity();
        sysActivity.setActivityId(IdUtil.simpleUUID());
        sysActivity.setActivityName(dto.getActivityName());
        sysActivity.setActivityDate(dto.getActivityDate());
        sysActivity.setActivityLocation(dto.getActivityLocation());
        this.save(sysActivity);
    }

    @Override
    public void addActivityassessment(AddActivityassessmentDTO dto) {
        SysActivityassessment sysActivityassessment = new SysActivityassessment();
        sysActivityassessment.setActivityassessmentId(IdUtil.simpleUUID());
        sysActivityassessment.setActivityId(dto.getActivityId());
        sysActivityassessment.setStudentId(dto.getStudentId());
        sysActivityassessment.setActivityassessmentName(dto.getActivityassessmentName());
        sysActivityassessment.setComment(dto.getComment());
        sysActivityassessment.setPhotograph(dto.getPhotograph());
        activityassessmentMapper.insert(sysActivityassessment);
    }

    @Override
    public void updateActivity(UpdateActivityDTO dto) {
        SysActivity sysActivity = this.getById(dto.getActivityId());
        if (null == sysActivity) {
            throw new RuntimeException();
        }
        sysActivity.setActivityName(dto.getActivityName());
        sysActivity.setActivityLocation(dto.getActivityLocation());
        sysActivity.setActivityDate(dto.getActivityDate());
        baseMapper.updateById(sysActivity);
    }

    @Override
    public PageInfo<ActivityListVO> getActivityListByPage(ActicitySearchDTO dto, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<ActivityListVO> activityList = baseMapper.getActivityList(dto);
        PageInfo<ActivityListVO> pageInfo = new PageInfo<>(activityList);
        return pageInfo;
    }

    @Override
    public PageInfo<ActivityassessmentListVO> getActivityassessmentListByPage(ActivityassessmentSearchDTO dto, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<ActivityassessmentListVO> activityassessmentList = baseMapper.getActivityassessmentList(dto);
        PageInfo<ActivityassessmentListVO> pageInfo = new PageInfo<>(activityassessmentList);
        return pageInfo;
    }

    @Override
    public void deleteActivity(ActivityIdDTO dto) {
        SysActivity sysActivity = this.getById(dto.getActivityId());
        if (null == sysActivity) {
            throw new RuntimeException();
        }
        this.removeById(sysActivity.getActivityId());
    }
}
