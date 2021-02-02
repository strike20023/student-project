package com.oriri.service.Impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oriri.dto.AddSubjectDTO;
import com.oriri.dto.SubjectIdDTO;
import com.oriri.dto.SubjectSearchDTO;
import com.oriri.dto.UpdateSubjectDTO;
import com.oriri.entity.SysSubject;
import com.oriri.mapper.SubjectMapper;
import com.oriri.service.SubjectService;
import com.oriri.vo.ComboboxVO;
import com.oriri.vo.SubjectListVO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SubjectServiceImpl  extends ServiceImpl<SubjectMapper, SysSubject> implements SubjectService {
    @Override
    public void addSubject(AddSubjectDTO dto) {
        SysSubject sysSubject= new SysSubject();
        sysSubject.setSubjectId(IdUtil.simpleUUID());
        sysSubject.setSubjectName(dto.getSubjectName());
        sysSubject.setActivityrequirementsMin(dto.getActivityrequirementsMin());
        sysSubject.setMaxassistantNum(dto.getMaxassistantNum());
        sysSubject.setProjectrequirementsMin(dto.getProjectrequirementsMin());
        this.save(sysSubject);
    }

    @Override
    public void updateSubject(UpdateSubjectDTO dto) {
        SysSubject sysSubject= this.getById(dto.getSubjectId());
        if(null == sysSubject){
            throw  new RuntimeException();
        }
        sysSubject.setSubjectName(dto.getSubjectName());
        sysSubject.setActivityrequirementsMin(dto.getActivityrequirementsMin());
        sysSubject.setMaxassistantNum(dto.getMaxassistantNum());
        sysSubject.setProjectrequirementsMin(dto.getProjectrequirementsMin());
        baseMapper.updateById(sysSubject);
    }

    @Override
    public PageInfo<SubjectListVO> getActivityListByPage(SubjectSearchDTO dto, Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<SubjectListVO> subjectList = baseMapper.getSubjectList(dto);
        PageInfo<SubjectListVO> pageInfo = new PageInfo<>(subjectList);
        return pageInfo;
    }

    @Override
    public void deleteSubject(SubjectIdDTO dto) {
        SysSubject sysSubject = this.getById(dto.getSubjectId());
        if(null ==sysSubject){
            throw  new RuntimeException();
        }
        this.removeById(sysSubject.getSubjectId());
    }


    @Override
    public List<ComboboxVO> getSubjectCombobox() {
        List<ComboboxVO> SubjectCombobox = baseMapper.getSubjectCombobox();
        return SubjectCombobox;
    }
}
