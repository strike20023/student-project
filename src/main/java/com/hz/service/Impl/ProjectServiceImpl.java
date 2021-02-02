package com.oriri.service.Impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oriri.dto.*;
import com.oriri.entity.SysProject;
import com.oriri.entity.SysProjectassessment;
import com.oriri.mapper.ProjectMapper;
import com.oriri.mapper.ProjectassessmentMapper;
import com.oriri.service.ProjectService;
import com.oriri.vo.ComboboxVO;
import com.oriri.vo.ProjectListVO;
import com.oriri.vo.ProjectassessmentListVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, SysProject> implements ProjectService {
    @Resource
    private ProjectassessmentMapper projectassessmentMapper;


    @Override
    public void addProject(AddProjectDTO dto) {
        SysProject  sysProject= new SysProject();
        sysProject.setProjectId(IdUtil.simpleUUID());
        sysProject.setProjectName(dto.getProjectName());
        sysProject.setProjectType(dto.getProjectType());
        sysProject.setProjectStart(dto.getProjectStart());
        sysProject.setProjectEnd(dto.getProjectEnd());
        this.save(sysProject);
    }

    @Override
    public void addProjectassessment(AddProjectassessmentDTO dto) {
        SysProjectassessment projectassessment = new SysProjectassessment();
        projectassessment.setProjectassessmentId(IdUtil.simpleUUID());
        projectassessment.setProjectId(dto.getProjectId());
        projectassessment.setStudentId(dto.getStudentId());
        projectassessment.setExpenditure(dto.getExpenditure());
        projectassessment.setStuSignature(dto.getStuSignature());
        projectassessment.setStuWork(dto.getStuWork());
        projectassessment.setTeaSignature(dto.getTeaSignature());
        projectassessmentMapper.insert(projectassessment);
    }

    @Override
    public void updateProject(UpdateProjectDTO dto) {
        SysProject sysProject= this.getById(dto.getProjectId());
        if(null == sysProject){
            throw  new RuntimeException();
        }
        sysProject.setProjectName(dto.getProjectName());
        sysProject.setProjectType(dto.getProjectType());
        sysProject.setProjectStart(dto.getProjectStart());
        sysProject.setProjectStart(dto.getProjectEnd());
        baseMapper.updateById(sysProject);
    }

    @Override
    public void updateProjectassessment(UpdateProjectassessmentDTO dto) {
        SysProjectassessment projectassessment= projectassessmentMapper.selectById(dto.getProjectassessmentId());
        if(null == projectassessment){
            throw  new RuntimeException();
        }
        projectassessment.setProjectId(dto.getProjectId());
        projectassessment.setStudentId(dto.getStudentId());
        projectassessment.setExpenditure(dto.getExpenditure());
        projectassessment.setStuSignature(dto.getStuSignature());
        projectassessment.setStuWork(dto.getStuWork());
        projectassessment.setTeaSignature(dto.getTeaSignature());
        projectassessmentMapper.updateById(projectassessment);
    }

    @Override
    public PageInfo<ProjectListVO> getProjectListByPage(ProjectSearchDTO dto, Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<ProjectListVO> projectList = baseMapper.getProjectList(dto);
        PageInfo<ProjectListVO> pageInfo = new PageInfo<>(projectList);
        return pageInfo;
    }

    @Override
    public PageInfo<ProjectassessmentListVO> getProjectassessmentListPage(ProjectassessmentSearchDTO dto, Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<ProjectassessmentListVO> projectassessmentList = baseMapper.getProjectassessmentList(dto);
        PageInfo<ProjectassessmentListVO> pageInfo = new PageInfo<>(projectassessmentList);
        return pageInfo;
    }

    @Override
    public void deleteProject(ProjectIdDTO dto) {
        SysProject sysProject = this.getById(dto.getProjectId());
        if(null ==sysProject){
            throw  new RuntimeException();
        }
        this.removeById(sysProject.getProjectId());
    }

    @Override
    public List<ComboboxVO> getProjectCombobox() {
        return baseMapper.getProjectCombobox();
    }
}
