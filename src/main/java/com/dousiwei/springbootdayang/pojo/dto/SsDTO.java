package com.dousiwei.springbootdayang.pojo.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class SsDTO implements Serializable {
    private String name;
    private String description;
    private String address;
    private String phone;
    private String openTime; // 如 "08:00-18:00"
    private String image;
}
