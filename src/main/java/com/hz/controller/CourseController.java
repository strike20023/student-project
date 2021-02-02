package com.oriri.controller;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageInfo;
import com.oriri.common.ResponseResult;
import com.oriri.dto.*;
import com.oriri.service.CourseService;
import com.oriri.until.EasyUIAdapterUtil;
import com.oriri.vo.CourseListVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
public class CourseController {
    @Resource
    private CourseService courseService;


    @GetMapping("/course")
    public String coursePage() {
        return "course";
    }


    @PostMapping("/course/getCourseListByPage")
    @ResponseBody
    public JSONObject getCourseListByPage(CourseSearchDTO dto, Integer page, Integer rows) {
        PageInfo<CourseListVO> result = courseService.getActivityListByPage(dto, page, rows);
        Map map = EasyUIAdapterUtil.convertDatagridMap(result);
        JSONObject jsObject = JSONUtil.parseObj(map);
        return jsObject;
    }
    
    @PostMapping("/course/addCourse")
    @ResponseBody
    public ResponseResult<?> addCourse(@RequestBody AddCourseDTO dto) {
        courseService.addCourse(dto);
        return ResponseResult.SUCCESS();
    }

    @PostMapping("/course/updateActivity")
    @ResponseBody
    public ResponseResult<?> updateCourse(@RequestBody UpdateCourseDTO dto) {
        courseService.updateCourse(dto);
        return ResponseResult.SUCCESS();
    }

    @PostMapping("/course/deleteActivity")
    @ResponseBody
    public ResponseResult<?> deleteCourse(@RequestBody CourseIdDTO dto) {
        courseService.deleteCourse(dto);
        return ResponseResult.SUCCESS();
    }

}
