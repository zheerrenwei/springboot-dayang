package com.dousiwei.springbootdayang.pojo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class HoUpdateDTO implements Serializable {
    private int hotelId;
    private String name;
    private String description;
    private String address;
    private String phone;
    private int stars; // 酒店星级，例如 3、4、5
    private String image;
}
