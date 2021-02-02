package com.oriri.controller;

import com.github.pagehelper.PageInfo;
import com.oriri.common.ResponseResult;
import com.oriri.dto.AddAssistantapplicationDTO;
import com.oriri.dto.AssistantapplicationSearchDTO;
import com.oriri.entity.SysAssistantapplication;
import com.oriri.service.AssistantapplicationService;
import com.oriri.until.EasyUIAdapterUtil;
import com.oriri.until.SessionUntil;
import com.oriri.vo.ApplyListVO;
import com.oriri.vo.AssistantApplyListVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
public class AssistantApplyController {
    @Resource
    private AssistantapplicationService assistantapplicationService;
    @Resource
    private SessionUntil sessionUntil;

    @GetMapping("/assistantApply")
    public String assistantApplyPage() {
        return "assistantApply";
    }


    @PostMapping("/assistantApply/addAssistantApply")
    @ResponseBody
    public ResponseResult<?> addAssistantApply(@RequestBody AddAssistantapplicationDTO dto) {

        assistantapplicationService.addAssistantApply(dto);
        return ResponseResult.SUCCESS();
    }

    @PostMapping("assistantApply/getAssistantApplyListByPage")
    @ResponseBody
    public Map getAssistantApplyListByPage(AssistantapplicationSearchDTO dto, Integer page, Integer rows) {
        PageInfo<AssistantApplyListVO> result = assistantapplicationService.getAssistantApplyListByPage(dto, page, rows);
        Map map = EasyUIAdapterUtil.convertDatagridMap(result);
        return map;
    }



    @PostMapping("assistantApply/getApplyListByPage")
    @ResponseBody
    public Map getApplyListByPage(Integer page, Integer rows) {
        PageInfo<ApplyListVO> result = assistantapplicationService.getApplyListByPage( page, rows);
        Map map = EasyUIAdapterUtil.convertDatagridMap(result);
        return map;
    }

    @PostMapping("assistantApply/agreeApply")
    @ResponseBody
    public ResponseResult<?>  agreeApply(@RequestBody SysAssistantapplication dto) {
        assistantapplicationService.agreeApply(dto);
        return ResponseResult.SUCCESS();
    }

}
