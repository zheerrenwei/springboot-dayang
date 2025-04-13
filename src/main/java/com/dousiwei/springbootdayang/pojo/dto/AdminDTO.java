package com.dousiwei.springbootdayang.pojo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AdminDTO implements Serializable {
    private String adminName;
    private String password;
    private String email;
    private String phone;
}
