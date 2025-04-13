package com.dousiwei.springbootdayang.service;

import com.dousiwei.springbootdayang.pojo.dto.AdminDTO;
import com.dousiwei.springbootdayang.pojo.dto.AdminLoginDTO;
import com.dousiwei.springbootdayang.pojo.dto.AdminPageDTO;
import com.dousiwei.springbootdayang.pojo.dto.AdminUpdateDTO;
import com.dousiwei.springbootdayang.pojo.eneity.Admin;
import com.dousiwei.springbootdayang.result.PageResult;

public interface AdminService {
    // 管理员登录
    Admin login(AdminLoginDTO adminLoginDTO);
    // 添加管理员
    void addAdmin(AdminDTO adminDTO);
    // 分页查询
    PageResult page(AdminPageDTO adminPageDTO);
    // 启用或禁用管理员
    void role(Integer status, int adminId);
    //根据id查询管理员信息
    Admin getById(int adminId);
    // 修改管理员信息
    void update(AdminUpdateDTO adminUpdateDTO);
    //删除管理员
    void delete(int adminId);
}
