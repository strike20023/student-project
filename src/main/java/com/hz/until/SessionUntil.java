package com.oriri.until;

import com.github.pagehelper.StringUtil;
import com.oriri.entity.SysUser;
import com.oriri.mapper.UserMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Component
public class SessionUntil {
    @Resource
    private UserMapper userMapper;
    @Resource
    private HttpServletRequest request;

    public SysUser getUser() {
        String userId = (String) request.getSession().getAttribute("userId");
        if (StringUtil.isEmpty(userId)) {
            return null;
        } else {
            SysUser user = userMapper.selectById(userId);
            return user;
        }

    }
}
