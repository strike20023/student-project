package com.oriri.service;

import com.github.pagehelper.PageInfo;
import com.oriri.dto.AddSubjectDTO;
import com.oriri.dto.SubjectIdDTO;
import com.oriri.dto.SubjectSearchDTO;
import com.oriri.dto.UpdateSubjectDTO;
import com.oriri.vo.ComboboxVO;
import com.oriri.vo.SubjectListVO;

import java.util.List;

public interface SubjectService {
    void addSubject(AddSubjectDTO dto);

    void updateSubject(UpdateSubjectDTO dto);

    PageInfo<SubjectListVO> getActivityListByPage(SubjectSearchDTO dto, Integer page, Integer rows);

    void deleteSubject(SubjectIdDTO dto);

    List<ComboboxVO> getSubjectCombobox();
}
