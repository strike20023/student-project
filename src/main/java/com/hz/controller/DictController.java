package com.oriri.controller;

import com.oriri.service.DictService;
import com.oriri.vo.ComboboxVO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class DictController {

    @Resource
    private DictService dictService;


    @PostMapping("/dict/{mark}")
    @ResponseBody
    public List<ComboboxVO> getDictCombobox(@PathVariable("mark")Integer mark ) {
        List<ComboboxVO> result = dictService.getDictCombobox(mark);
        return result;
    }
}
