package com.dousiwei.springbootdayang.service;


import com.dousiwei.springbootdayang.pojo.dto.UserDTO;
import com.dousiwei.springbootdayang.pojo.dto.UserLoginDTO;
import com.dousiwei.springbootdayang.pojo.dto.UserUpdateDTO;
import com.dousiwei.springbootdayang.pojo.eneity.User;

public interface UserService {
    //用户注册
    void register(UserDTO userDTO);
    //用户登录
    User login(UserLoginDTO userLoginDTO);
    //根据id查询用户信息
    User getById(int userId);
    //修改自己的信息
    void update(UserUpdateDTO userUpdateDTO);
}
