package com.oriri.service;

import com.oriri.dto.UserDTO;
import com.oriri.entity.SysMenu;

import java.util.List;

public interface MenuService {
    List<SysMenu> getAll();
}
