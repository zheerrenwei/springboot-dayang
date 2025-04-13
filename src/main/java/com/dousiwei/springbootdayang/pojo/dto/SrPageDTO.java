package com.dousiwei.springbootdayang.pojo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SrPageDTO implements Serializable {
    private String name;
    private String comment;
    private int page;
    private int pagesize;
}
