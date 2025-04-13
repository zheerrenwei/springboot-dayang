package com.dousiwei.springbootdayang.pojo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class HroomPageDto implements Serializable {
    private String name;
    private int page;
    private int pagesize;
}
