package com.oriri.service;

import com.github.pagehelper.PageInfo;
import com.oriri.dto.*;
import com.oriri.entity.SysUser;
import com.oriri.vo.ComboboxVO;
import com.oriri.vo.StudentListVO;
import com.oriri.vo.TeacherListVO;
import com.oriri.vo.UserListVO;

import java.util.List;

public interface UserService {
    SysUser login(UserDTO dto);

    void addUser(AddUserDTO dto);

    void updateUser(UpdateDTO dto);

    void deleteUser(UserIdDTO dto);

    void updateTeacher(UpdateTeacherDTO dto);

    PageInfo<UserListVO> getUserListByPage(UserSearchDTO dto, Integer page, Integer rows);

    PageInfo<StudentListVO> getStudentListByPage(StudentSearchDTO dto, Integer page, Integer rows);

    PageInfo<TeacherListVO> getTeacherListByPage(TeacherSearchDTO dto, Integer page, Integer rows);

    List<ComboboxVO> getStudentCombobox();

}
