package com.oriri.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oriri.entity.SysDict;
import com.oriri.vo.ComboboxVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DictMapper extends BaseMapper<SysDict> {
    List<ComboboxVO> getDictCombobox(@Param("mark") Integer mark);
}
