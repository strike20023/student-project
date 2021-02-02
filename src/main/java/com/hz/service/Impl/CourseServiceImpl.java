package com.oriri.service.Impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oriri.dto.AddCourseDTO;
import com.oriri.dto.CourseIdDTO;
import com.oriri.dto.CourseSearchDTO;
import com.oriri.dto.UpdateCourseDTO;
import com.oriri.entity.SysCourse;
import com.oriri.mapper.CourseMapper;
import com.oriri.service.CourseService;
import com.oriri.vo.CourseListVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl  extends ServiceImpl<CourseMapper, SysCourse> implements CourseService {
    @Override
    public void addCourse(AddCourseDTO dto) {
        SysCourse sysCourse= new SysCourse();
        sysCourse.setCourseId(IdUtil.simpleUUID());
        sysCourse.setCourseName(dto.getCourseName());
        sysCourse.setCourseType(dto.getCourseType());
        sysCourse.setStudentNum(dto.getStudentNum());
        sysCourse.setStudentType(dto.getStudentType());
        this.save(sysCourse);
    }

    @Override
    public void updateCourse(UpdateCourseDTO dto) {
        SysCourse sysCourse= this.getById(dto.getCourseId());
        if(null == sysCourse){
            throw  new RuntimeException();
        }
        sysCourse.setCourseName(dto.getCourseName());
        sysCourse.setCourseType(dto.getCourseType());
        sysCourse.setStudentNum(dto.getStudentNum());
        sysCourse.setStudentType(dto.getStudentType());
        baseMapper.updateById(sysCourse);
    }

    @Override
    public PageInfo<CourseListVO> getActivityListByPage(CourseSearchDTO dto, Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<CourseListVO> courseList = baseMapper.getCourseList(dto);
        PageInfo<CourseListVO> pageInfo = new PageInfo<>(courseList);
        return pageInfo;
    }

    @Override
    public void deleteCourse(CourseIdDTO dto) {
        SysCourse sysCourse = this.getById(dto.getCourseId());
        if(null ==sysCourse){
            throw  new RuntimeException();
        }
        this.removeById(sysCourse.getCourseId());
    }
}
