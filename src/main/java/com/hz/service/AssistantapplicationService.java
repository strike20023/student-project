package com.oriri.service;

import com.github.pagehelper.PageInfo;
import com.oriri.dto.AddAssistantapplicationDTO;
import com.oriri.dto.AssistantapplicationSearchDTO;
import com.oriri.entity.SysAssistantapplication;
import com.oriri.vo.ApplyListVO;
import com.oriri.vo.AssistantApplyListVO;

public interface AssistantapplicationService {
    void addAssistantApply(AddAssistantapplicationDTO dto);

    void agreeApply(SysAssistantapplication dto);

    PageInfo<AssistantApplyListVO> getAssistantApplyListByPage(AssistantapplicationSearchDTO dto, Integer page, Integer rows);


    PageInfo<ApplyListVO> getApplyListByPage( Integer page, Integer rows);
}
