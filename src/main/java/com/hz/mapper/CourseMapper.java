package com.oriri.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oriri.dto.CourseSearchDTO;
import com.oriri.entity.SysCourse;
import com.oriri.vo.CourseListVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper extends BaseMapper<SysCourse> {
    List<CourseListVO> getCourseList(@Param("dto") CourseSearchDTO dto);
}
