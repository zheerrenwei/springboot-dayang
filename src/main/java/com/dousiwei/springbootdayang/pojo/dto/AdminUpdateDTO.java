package com.dousiwei.springbootdayang.pojo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AdminUpdateDTO implements Serializable {
    private Integer adminId;
    private String adminName;
    private String password;
    private String email;
    private String phone;
}
