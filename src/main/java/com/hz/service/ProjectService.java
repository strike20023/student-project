package com.oriri.service;

import com.github.pagehelper.PageInfo;
import com.oriri.dto.*;
import com.oriri.vo.ComboboxVO;
import com.oriri.vo.ProjectListVO;
import com.oriri.vo.ProjectassessmentListVO;

import java.util.List;

public interface ProjectService {
    void addProject(AddProjectDTO dto);
    void addProjectassessment(AddProjectassessmentDTO dto);

    void updateProject(UpdateProjectDTO dto);
    void updateProjectassessment(UpdateProjectassessmentDTO dto);
    PageInfo<ProjectListVO> getProjectListByPage(ProjectSearchDTO dto, Integer page, Integer rows);

    PageInfo<ProjectassessmentListVO> getProjectassessmentListPage(ProjectassessmentSearchDTO dto, Integer page, Integer rows);

    void deleteProject(ProjectIdDTO dto);

    List<ComboboxVO> getProjectCombobox();
}
