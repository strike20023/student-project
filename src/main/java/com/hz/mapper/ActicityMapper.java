package com.oriri.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oriri.dto.ActicitySearchDTO;
import com.oriri.dto.ActivityassessmentSearchDTO;
import com.oriri.entity.SysActivity;
import com.oriri.vo.ActivityListVO;
import com.oriri.vo.ActivityassessmentListVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActicityMapper extends BaseMapper<SysActivity> {
    List<ActivityListVO> getActivityList(@Param("dto") ActicitySearchDTO dto);
    List<ActivityassessmentListVO> getActivityassessmentList(@Param("dto") ActivityassessmentSearchDTO dto);
}
