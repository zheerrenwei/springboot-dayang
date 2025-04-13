package com.dousiwei.springbootdayang.service.impl;

import com.dousiwei.springbootdayang.mapper.AdminHrMapper;
import com.dousiwei.springbootdayang.mapper.AdminSrMapper;
import com.dousiwei.springbootdayang.mapper.AdminTrMapper;
import com.dousiwei.springbootdayang.mapper.AdminUserMapper;
import com.dousiwei.springbootdayang.pojo.dto.AdminUserPageDTO;
import com.dousiwei.springbootdayang.pojo.dto.UserUpdateDTO;
import com.dousiwei.springbootdayang.pojo.eneity.User;
import com.dousiwei.springbootdayang.result.PageResult;
import com.dousiwei.springbootdayang.service.AdminUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    private AdminUserMapper adminUserMapper;
    @Autowired
    private AdminSrMapper adminSrMapper;
    @Autowired
    private AdminTrMapper adminTrMapper;
    @Autowired
    private AdminHrMapper adminHrMapper;
    // 分页查询
    @Override
    public PageResult page(AdminUserPageDTO adminUserPageDTO) {
        PageHelper.startPage(adminUserPageDTO.getPage(),adminUserPageDTO.getPagesize());
        Page<User> page=adminUserMapper.page(adminUserPageDTO);
        return new PageResult(page.getTotal(),page.getResult());
    }

    // 根据id查询用户信息

    @Override
    public User getById(int userId) {
        User user = adminUserMapper.getById(userId);
        return user;
    }
    // 修改用户信息
    @Override
    public void update(UserUpdateDTO userUpdateDTO) {
        User user = new User();
        BeanUtils.copyProperties(userUpdateDTO,user);
        adminUserMapper.update(user);
    }

    // 删除用户
    @Override
    public void delete(int userId) {
        adminUserMapper.delete(userId);
        adminHrMapper.deleteUserId(userId);
        adminTrMapper.deleteByUserId(userId);
        adminSrMapper.deleteByUserId(userId);
    }

    //启用或禁用用户
    @Override
    public void updateStatus(Integer status, int userId) {
        User user = User.builder()
                .userId(userId)
                .status(status)
                .build();
        adminUserMapper.update(user);
    }
}
