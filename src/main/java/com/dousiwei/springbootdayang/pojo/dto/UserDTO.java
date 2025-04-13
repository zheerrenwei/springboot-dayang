package com.dousiwei.springbootdayang.pojo.dto;

import lombok.Data;

import java.io.Serializable;
//用户注册
@Data
public class UserDTO implements Serializable {
    //private int userId;
    private String username;
    private String password;
    private String email;
    private String phone;
}
