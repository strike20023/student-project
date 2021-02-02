package com.oriri.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oriri.dto.ProjectSearchDTO;
import com.oriri.dto.ProjectassessmentSearchDTO;
import com.oriri.entity.SysProject;
import com.oriri.vo.ComboboxVO;
import com.oriri.vo.ProjectListVO;
import com.oriri.vo.ProjectassessmentListVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectMapper extends BaseMapper<SysProject> {
    List<ProjectListVO> getProjectList(@Param("dto") ProjectSearchDTO dto);
    List<ProjectassessmentListVO> getProjectassessmentList(@Param("dto") ProjectassessmentSearchDTO dto);
    List<ComboboxVO> getProjectCombobox();
}
