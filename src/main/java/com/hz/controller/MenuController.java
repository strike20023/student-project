package com.oriri.controller;

import com.oriri.common.ResponseResult;
import com.oriri.entity.SysMenu;
import com.oriri.service.MenuService;
import com.oriri.until.EasyUIAdapterUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/menus")
public class MenuController {
    @Resource
    private MenuService menuService;

    @GetMapping("/getMenuList")
    public ResponseResult<?> getMenuList(){
        List<SysMenu> menus = menuService.getAll();
        menus = EasyUIAdapterUtil.convertMenu(menus);
        return ResponseResult.SUCCESS(menus);
    }
}
