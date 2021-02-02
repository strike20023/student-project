package com.oriri.service;

import com.github.pagehelper.PageInfo;
import com.oriri.dto.AddCourseDTO;
import com.oriri.dto.CourseIdDTO;
import com.oriri.dto.CourseSearchDTO;
import com.oriri.dto.UpdateCourseDTO;
import com.oriri.vo.CourseListVO;

public interface CourseService {

    void addCourse(AddCourseDTO dto);

    void updateCourse(UpdateCourseDTO dto);

    PageInfo<CourseListVO> getActivityListByPage(CourseSearchDTO dto, Integer page, Integer rows);

    void deleteCourse(CourseIdDTO dto);

}
