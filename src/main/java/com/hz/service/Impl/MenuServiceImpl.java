package com.oriri.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oriri.entity.SysMenu;

import com.oriri.mapper.MenuMapper;

import com.oriri.service.MenuService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, SysMenu> implements MenuService {

    @Override
    public List<SysMenu> getAll() {
        List<SysMenu> menus = this.list();
        return  menus;
    }
}
