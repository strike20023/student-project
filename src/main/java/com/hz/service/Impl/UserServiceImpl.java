package com.oriri.service.Impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oriri.dto.*;
import com.oriri.entity.SysStudent;
import com.oriri.entity.SysTeacher;
import com.oriri.entity.SysUser;
import com.oriri.mapper.StudentMapper;
import com.oriri.mapper.TeacherMapper;
import com.oriri.mapper.UserMapper;
import com.oriri.service.UserService;
import com.oriri.vo.ComboboxVO;
import com.oriri.vo.StudentListVO;
import com.oriri.vo.TeacherListVO;
import com.oriri.vo.UserListVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, SysUser> implements UserService {
    @Resource
    private StudentMapper studentMapper;
    @Resource
    private TeacherMapper teacherMapper;


    @Override
    public SysUser login(UserDTO dto) {
        QueryWrapper<SysUser> qwSysUser = new QueryWrapper<>();
        qwSysUser.eq("user_name", dto.getUserName()).eq("password", dto.getPassword());
        SysUser user = this.getOne(qwSysUser);
       return  user;
    }

    @Override
    @Transactional
    public void addUser(AddUserDTO dto) {
        SysUser newUser = new SysUser();
        newUser.setUserId(IdUtil.simpleUUID());
        newUser.setUserName(dto.getUserName());
        newUser.setPassword(dto.getPassword());
        newUser.setRole(dto.getRole());
        this.save(newUser);
        if(dto.getRole().equals("1001")){
            SysStudent sysStudent = new SysStudent();
            sysStudent.setStudentId(IdUtil.simpleUUID());
            sysStudent.setStudentName(dto.getName());
            sysStudent.setUserId(newUser.getUserId());
            sysStudent.setSubjectId("--");
            sysStudent.setTeacherId("--");
            studentMapper.insert(sysStudent);
        }else if(dto.getRole().equals("1002")){
            SysTeacher sysTeacher = new SysTeacher();
            sysTeacher.setTeacherId(IdUtil.simpleUUID());
            sysTeacher.setTeacherName(dto.getName());
            sysTeacher.setUserId(newUser.getUserId());
            teacherMapper.insert(sysTeacher);
        }


    }

    @Override
    public void updateUser(UpdateDTO dto) {
        SysUser user = this.getById(dto.getUserId());
        if(null==user){
            throw  new RuntimeException();
        }
        if(!dto.getUserName().equals(user.getUserName())){
            QueryWrapper<SysUser> qw1 = new QueryWrapper<>();
            qw1.eq("user_name",dto.getUserName()).ne("user_id",dto.getUserId());
            SysUser user1 = this.getOne(qw1);
            if(null!=user1){
                throw  new RuntimeException();
            }
        }
        user.setUserName(dto.getUserName());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());
        this.save(user);
    }
    @Override
    public void deleteUser(UserIdDTO dto) {
        SysUser user = this.getById(dto.getUserId());
        if(null==user){
            throw  new RuntimeException();
        }
       this.removeById(dto.getUserId());
    }

    @Override
    public void updateTeacher(UpdateTeacherDTO dto) {
        SysTeacher sysTeacher = teacherMapper.selectById(dto.getTeacherId());
        if(null ==sysTeacher){
            throw  new RuntimeException();
        }
        sysTeacher.setTeacherName(dto.getTeacherName());
        sysTeacher.setSubjectId(dto.getSubjectId());
        sysTeacher.setTeacherRole(dto.getRoleId());
        teacherMapper.updateById(sysTeacher);
    }

    @Override
    public PageInfo<UserListVO> getUserListByPage(UserSearchDTO dto, Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<UserListVO> userList = baseMapper.getUserList(dto);
        PageInfo<UserListVO> pageInfo = new PageInfo<>(userList);
        return pageInfo;
    }

    @Override
    public PageInfo<StudentListVO> getStudentListByPage(StudentSearchDTO dto, Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<StudentListVO> studentList = baseMapper.getStudentList(dto);
        PageInfo<StudentListVO> pageInfo = new PageInfo<>(studentList);
        return pageInfo;
    }

    @Override
    public PageInfo<TeacherListVO> getTeacherListByPage(TeacherSearchDTO dto, Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<TeacherListVO> studentList = baseMapper.getTeacherList(dto);
        PageInfo<TeacherListVO> pageInfo = new PageInfo<>(studentList);
        return pageInfo;
    }

    @Override
    public List<ComboboxVO> getStudentCombobox() {
        return baseMapper.getStudentCombobox();
    }

}
