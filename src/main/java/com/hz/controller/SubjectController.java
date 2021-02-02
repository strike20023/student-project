package com.oriri.controller;

import com.github.pagehelper.PageInfo;
import com.oriri.common.ResponseResult;
import com.oriri.dto.AddSubjectDTO;
import com.oriri.dto.SubjectIdDTO;
import com.oriri.dto.SubjectSearchDTO;
import com.oriri.dto.UpdateSubjectDTO;
import com.oriri.service.SubjectService;
import com.oriri.until.EasyUIAdapterUtil;
import com.oriri.vo.ComboboxVO;
import com.oriri.vo.SubjectListVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Controller
public class SubjectController {
    @Resource
    private SubjectService SubjectService;


    @GetMapping("/subject")
    public String SubjectPage() {
        return "subject";
    }


    @PostMapping("/subject/getSubjectListByPage")
    @ResponseBody
    public Map getSubjectListByPage(SubjectSearchDTO dto, Integer page, Integer rows) {
        PageInfo<SubjectListVO> result = SubjectService.getActivityListByPage(dto, page, rows);
        Map map = EasyUIAdapterUtil.convertDatagridMap(result);
        return map;
    }

    @PostMapping("/subject/getSubjectCombobox")
    @ResponseBody
    public List<ComboboxVO> getSubjectCombobox() {
        List<ComboboxVO>result = SubjectService.getSubjectCombobox();

        return result;
    }

    @PostMapping("/subject/addSubject")
    @ResponseBody
    public ResponseResult<?> addSubject(@RequestBody AddSubjectDTO dto) {
        SubjectService.addSubject(dto);
        return ResponseResult.SUCCESS();
    }

    @PostMapping("/subject/updateActivity")
    @ResponseBody
    public ResponseResult<?> updateSubject(@RequestBody UpdateSubjectDTO dto) {
        SubjectService.updateSubject(dto);
        return ResponseResult.SUCCESS();
    }

    @PostMapping("/subject/deleteActivity")
    @ResponseBody
    public ResponseResult<?> deleteSubject(@RequestBody SubjectIdDTO dto) {
        SubjectService.deleteSubject(dto);
        return ResponseResult.SUCCESS();
    }



}
