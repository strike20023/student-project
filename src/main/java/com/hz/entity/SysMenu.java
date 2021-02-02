package com.oriri.entity;

import lombok.Data;

@Data
public class SysMenu {
    private Integer id;
    private String name;
    private String parentNode;
    private String node;
    private String url;
}