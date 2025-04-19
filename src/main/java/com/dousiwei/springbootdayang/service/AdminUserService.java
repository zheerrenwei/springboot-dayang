package com.dousiwei.springbootdayang.service;

import com.dousiwei.springbootdayang.pojo.dto.AdminUserPageDTO;
import com.dousiwei.springbootdayang.pojo.dto.UserUpdateDTO;
import com.dousiwei.springbootdayang.pojo.eneity.User;
import com.dousiwei.springbootdayang.result.PageResult;

public interface AdminUserService {
    // 分页查询
    PageResult page(AdminUserPageDTO adminUserPageDTO);
    // 根据id查询用户信息
    User getById(int userId);
    // 修改用户信息
    void update(UserUpdateDTO userUpdateDTO);
    // 删除用户
    void delete(int userId);
    // 修改用户状态
    void updateStatus(int status, int userId);
}
