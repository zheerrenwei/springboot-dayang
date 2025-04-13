package com.dousiwei.springbootdayang.pojo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserUpdateDTO implements Serializable {
    private Integer userId;
    private String username;
    private String password;
    private String email;
    private String phone;
}
