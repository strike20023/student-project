package com.oriri.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oriri.dto.StudentSearchDTO;
import com.oriri.dto.TeacherSearchDTO;
import com.oriri.dto.UserSearchDTO;
import com.oriri.entity.SysUser;
import com.oriri.vo.ComboboxVO;
import com.oriri.vo.StudentListVO;
import com.oriri.vo.TeacherListVO;
import com.oriri.vo.UserListVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper  extends BaseMapper<SysUser> {
    List<UserListVO> getUserList(@Param("dto") UserSearchDTO dto);
    List<StudentListVO> getStudentList(@Param("dto") StudentSearchDTO dto);

    List<TeacherListVO> getTeacherList(@Param("dto") TeacherSearchDTO dto);

    List<ComboboxVO> getStudentCombobox();

}
