package com.oriri.service;

import com.oriri.vo.ComboboxVO;

import java.util.List;

public interface DictService {
    List<ComboboxVO> getDictCombobox(Integer mark);
}
