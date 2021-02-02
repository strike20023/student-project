package com.oriri.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oriri.entity.SysDict;
import com.oriri.mapper.DictMapper;
import com.oriri.service.DictService;
import com.oriri.vo.ComboboxVO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, SysDict> implements DictService {
    @Override
    public List<ComboboxVO> getDictCombobox(Integer mark) {
        List<ComboboxVO> dictCombobox = baseMapper.getDictCombobox( mark);
        return  dictCombobox;
    }
}
