package com.oriri.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oriri.dto.AssistantapplicationSearchDTO;
import com.oriri.entity.SysAssistantapplication;
import com.oriri.vo.ApplyListVO;
import com.oriri.vo.AssistantApplyListVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AssistantapplicationMapper extends BaseMapper<SysAssistantapplication> {
    List<AssistantApplyListVO> getAssistantApplyList(@Param("dto") AssistantapplicationSearchDTO dto);

    List<ApplyListVO> getApplyList();

}
