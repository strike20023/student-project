package com.oriri.controller;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageInfo;
import com.oriri.common.ResponseResult;
import com.oriri.dto.*;
import com.oriri.service.ActivityService;
import com.oriri.until.EasyUIAdapterUtil;
import com.oriri.vo.ActivityListVO;
import com.oriri.vo.ActivityassessmentListVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
public class ActivityController {

    @Resource
    private ActivityService activityService;

    @GetMapping("/activity")
    public String activityPage() {
        return "activity";
    }
    @GetMapping("/activityassessment")
    public String activityassessmentPage() {
        return "activityassessment";
    }


    @PostMapping("/activity/getActivityListByPage")
    @ResponseBody
    public JSONObject getActivityListByPage(ActicitySearchDTO dto, Integer page, Integer rows) {
        PageInfo<ActivityListVO> result = activityService.getActivityListByPage(dto, page, rows);
        Map map = EasyUIAdapterUtil.convertDatagridMap(result);
        JSONObject jsObject = JSONUtil.parseObj(map);
        return jsObject;
    }


    @PostMapping("/activity/addActivity")
    @ResponseBody
    public ResponseResult<?> addActivity(@RequestBody AddActivityDTO dto) {
        activityService.addActivity(dto);
        return ResponseResult.SUCCESS();
    }

    @PostMapping("/activity/updateActivity")
    @ResponseBody
    public ResponseResult<?> updateActivity(@RequestBody UpdateActivityDTO dto) {
        activityService.updateActivity(dto);
        return ResponseResult.SUCCESS();
    }

    @PostMapping("/activity/deleteActivity")
    @ResponseBody
    public ResponseResult<?> deleteActivity(@RequestBody ActivityIdDTO dto) {
        activityService.deleteActivity(dto);
        return ResponseResult.SUCCESS();
    }


    @PostMapping("/activity/addActivityassessment")
    @ResponseBody
    public ResponseResult<?> addActivityassessment(@RequestBody AddActivityassessmentDTO dto) {
        activityService.addActivityassessment(dto);
        return ResponseResult.SUCCESS();
    }


    @PostMapping("/activity/getActivityassessmentListByPage")
    @ResponseBody
    public Map getActivityassessmentListByPage(ActivityassessmentSearchDTO dto, Integer page, Integer rows) {
        PageInfo<ActivityassessmentListVO> result = activityService.getActivityassessmentListByPage(dto, page, rows);
        Map map = EasyUIAdapterUtil.convertDatagridMap(result);
        return map;
    }

}
