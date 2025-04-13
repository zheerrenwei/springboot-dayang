package com.dousiwei.springbootdayang.pojo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PageDTO implements Serializable {
    private int page;
    private int pagesize;
}
