package com.oriri.service.Impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oriri.dto.AddAssistantapplicationDTO;
import com.oriri.dto.AssistantapplicationSearchDTO;
import com.oriri.entity.SysAssistantapplication;
import com.oriri.entity.SysAssistantassessment;
import com.oriri.entity.SysStudent;
import com.oriri.entity.SysUser;
import com.oriri.mapper.AssistantapplicationMapper;
import com.oriri.mapper.AssistantassessmentMapper;
import com.oriri.mapper.StudentMapper;
import com.oriri.service.AssistantapplicationService;
import com.oriri.until.SessionUntil;
import com.oriri.vo.ApplyListVO;
import com.oriri.vo.AssistantApplyListVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class AssistantapplicationServiceImpl extends ServiceImpl<AssistantapplicationMapper, SysAssistantapplication> implements AssistantapplicationService {
    @Resource
    private SessionUntil sessionUntil;

    @Resource
    private StudentMapper studentMapper;

    @Resource
    private AssistantassessmentMapper assistantassessmentMapper;

    @Override
    public void addAssistantApply(AddAssistantapplicationDTO dto) {
        SysUser user = sessionUntil.getUser();
        QueryWrapper<SysStudent> qwStudent = new QueryWrapper<>();
        qwStudent.eq("user_id",user.getUserId());
        SysStudent student = studentMapper.selectOne(qwStudent);
        if(student==null){
            throw  new RuntimeException();
        }

        SysAssistantapplication sysAssistantapplication = new SysAssistantapplication();
        sysAssistantapplication.setAssistantapplicationId(IdUtil.simpleUUID());
        sysAssistantapplication.setStudentId(student.getStudentId());
        sysAssistantapplication.setCourseId(dto.getCourseId());
        sysAssistantapplication.setApplyTime(new Date());
        this.save(sysAssistantapplication);
    }

    @Override
    @Transactional
    public void agreeApply(SysAssistantapplication dto) {
        SysAssistantapplication assistantapplication = this.getById(dto.getAssistantapplicationId());
        if(null == assistantapplication)
        {
            throw  new RuntimeException();
        }
        SysAssistantassessment assistantassessment = new SysAssistantassessment();
        assistantassessment.setAssistantassessmentId(IdUtil.simpleUUID());
        assistantassessment.setCourseId(dto.getCourseId());
        assistantassessment.setStudentId(dto.getStudentId());
        assistantassessmentMapper.insert(assistantassessment);

        this.removeById(assistantapplication.getAssistantapplicationId());

    }


    @Override
    public PageInfo<AssistantApplyListVO> getAssistantApplyListByPage(AssistantapplicationSearchDTO dto, Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<AssistantApplyListVO> assistantApplyList = baseMapper.getAssistantApplyList(dto);
        PageInfo<AssistantApplyListVO> pageInfo = new PageInfo<>(assistantApplyList);
        return pageInfo;
    }

    @Override
    public PageInfo<ApplyListVO> getApplyListByPage(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<ApplyListVO> applyList = baseMapper.getApplyList();
        PageInfo<ApplyListVO> pageInfo = new PageInfo<>(applyList);
        return pageInfo;
    }
}
