package com.oriri.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oriri.dto.SubjectSearchDTO;
import com.oriri.entity.SysSubject;
import com.oriri.vo.ComboboxVO;
import com.oriri.vo.SubjectListVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SubjectMapper extends BaseMapper<SysSubject> {
    List<SubjectListVO> getSubjectList(@Param("dto") SubjectSearchDTO dto);

    List<ComboboxVO> getSubjectCombobox();
}
