package com.dousiwei.springbootdayang.pojo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SsUpdateDTO implements Serializable {
    private int scenicId;
    private String name;
    private String description;
    private String address;
    private String phone;
    private String openTime; // 如 "08:00-18:00"
    private String link;
    private String image;
}
