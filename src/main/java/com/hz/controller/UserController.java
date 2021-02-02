package com.oriri.controller;

import com.github.pagehelper.PageInfo;
import com.oriri.common.ResponseResult;
import com.oriri.dto.*;
import com.oriri.entity.SysUser;
import com.oriri.enums.SysCodeEnum;
import com.oriri.exception.BusinessException;
import com.oriri.service.UserService;
import com.oriri.until.EasyUIAdapterUtil;
import com.oriri.vo.ComboboxVO;
import com.oriri.vo.StudentListVO;
import com.oriri.vo.TeacherListVO;
import com.oriri.vo.UserListVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/index")
    public String indexPage() {
        return "index";
    }

    @GetMapping("/user")
    public String userPage() {
        return "user";
    }
    @GetMapping("/student")
    public String studentPage() {
        return "student";
    }
    @GetMapping("/teacher")
    public String teacherPage() {
        return "teacher";
    }
    @GetMapping("/workstation")
    public String workstationPage() {
        return "workstation";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseResult<?> login(@RequestBody UserDTO dto, HttpServletRequest request) {

        SysUser user = userService.login(dto);
        if(null==user){
            throw new BusinessException(SysCodeEnum.USER_LOGIN_ERROR);
        }

        request.getSession().setAttribute("userId",user.getUserId());
        return ResponseResult.SUCCESS();
    }

    @PostMapping("/getUserListByPage")
    @ResponseBody
    public Map getUserListByPage(UserSearchDTO dto,Integer page, Integer rows) {
        PageInfo<UserListVO>result= userService.getUserListByPage( dto, page,  rows);
        Map map = EasyUIAdapterUtil.convertDatagridMap(result);
        return map;
//        JSONObject jsObject = JSONUtil.parseObj(map);
//        return jsObject;
    }



    @PostMapping("/user/addUser")
    @ResponseBody
    public ResponseResult<?> addUser(@RequestBody AddUserDTO dto) {
        userService.addUser(dto);
        return ResponseResult.SUCCESS();
    }


    @PostMapping("/user/updateUser")
    @ResponseBody
    public ResponseResult<?> updateUser(@RequestBody UpdateDTO dto) {
        userService.updateUser(dto);
        return ResponseResult.SUCCESS();
    }

    @PostMapping("/user/deleteUser")
    @ResponseBody
    public ResponseResult<?> deleteUser(@RequestBody UserIdDTO dto) {
        userService.deleteUser(dto);
        return ResponseResult.SUCCESS();
    }


    @PostMapping("/user/updateTeacher")
    @ResponseBody
    public ResponseResult<?> updateTeacher(@RequestBody UpdateTeacherDTO dto) {
        userService.updateTeacher(dto);
        return ResponseResult.SUCCESS();
    }


    @PostMapping("/getStudentListByPage")
    @ResponseBody
    public Map getStudentListByPage( StudentSearchDTO dto,Integer page, Integer rows) {
        PageInfo<StudentListVO>result= userService.getStudentListByPage( dto, page,  rows);
        Map map = EasyUIAdapterUtil.convertDatagridMap(result);
        return map;
    }


    @PostMapping("/getTeacherListByPage")
    @ResponseBody
    public Map getTeacherListByPage( TeacherSearchDTO dto,Integer page, Integer rows) {
        PageInfo<TeacherListVO>result= userService.getTeacherListByPage( dto, page,  rows);
        Map map = EasyUIAdapterUtil.convertDatagridMap(result);
        return map;
    }
    @PostMapping("/user/getStudentCombobox")
    @ResponseBody
    public List<ComboboxVO> getStudentCombobox() {
        List<ComboboxVO> result = userService.getStudentCombobox();
        return result;
    }

}
