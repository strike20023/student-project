package com.oriri.controller;

import com.github.pagehelper.PageInfo;
import com.oriri.common.ResponseResult;
import com.oriri.dto.*;
import com.oriri.service.ProjectService;
import com.oriri.until.EasyUIAdapterUtil;
import com.oriri.vo.ComboboxVO;
import com.oriri.vo.ProjectListVO;
import com.oriri.vo.ProjectassessmentListVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class ProjectController {

    @Resource
    private ProjectService projectService;

    @GetMapping("/project")
    public String projectPage() {
        return "project";
    }

    @GetMapping("/projectassessment")
    public String projectassessmentPage() {
        return "projectassessment";
    }


    @PostMapping("/project/getProjectListByPage")
    @ResponseBody
    public Map getProjectListByPage(ProjectSearchDTO dto, Integer page, Integer rows) {
        PageInfo<ProjectListVO> result = projectService.getProjectListByPage(dto, page, rows);
        Map map = EasyUIAdapterUtil.convertDatagridMap(result);
        return map;
    }

    @PostMapping("/project/getProjectassessmentListPage")
    @ResponseBody
    public Map getProjectassessmentListPage(ProjectassessmentSearchDTO dto, Integer page, Integer rows) {
        PageInfo<ProjectassessmentListVO> result = projectService.getProjectassessmentListPage(dto, page, rows);
        Map map = EasyUIAdapterUtil.convertDatagridMap(result);
        return map;
    }

    @PostMapping("/project/addProject")
    @ResponseBody
    public ResponseResult<?> addProject(@RequestBody AddProjectDTO dto) {
        projectService.addProject(dto);
        return ResponseResult.SUCCESS();
    }

    @PostMapping("/project/updateProject")
    @ResponseBody
    public ResponseResult<?> updateProject(@RequestBody UpdateProjectDTO dto) {
        projectService.updateProject(dto);
        return ResponseResult.SUCCESS();
    }

    @PostMapping("/project/deleteProject")
    @ResponseBody
    public ResponseResult<?> deleteProject(@RequestBody ProjectIdDTO dto) {
        projectService.deleteProject(dto);
        return ResponseResult.SUCCESS();
    }


    @PostMapping("/project/getProjectCombobox")
    @ResponseBody
    public List<ComboboxVO> getProjectCombobox() {
        List<ComboboxVO> result = projectService.getProjectCombobox();
        return result;
    }

    @PostMapping("/project/addProjectassessment")
    @ResponseBody
    public ResponseResult<?> addProjectassessment(@RequestBody AddProjectassessmentDTO dto) {
        projectService.addProjectassessment(dto);
        return ResponseResult.SUCCESS();
    }

    @PostMapping("/project/updateProjectassessment")
    @ResponseBody
    public ResponseResult<?> updateProjectassessment(@RequestBody UpdateProjectassessmentDTO dto) {
        projectService.updateProjectassessment(dto);
        return ResponseResult.SUCCESS();
    }
}
