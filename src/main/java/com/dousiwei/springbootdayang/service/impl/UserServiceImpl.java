package com.dousiwei.springbootdayang.service.impl;

import com.dousiwei.springbootdayang.mapper.UserMapper;
import com.dousiwei.springbootdayang.pojo.dto.UserDTO;
import com.dousiwei.springbootdayang.pojo.dto.UserLoginDTO;
import com.dousiwei.springbootdayang.pojo.dto.UserUpdateDTO;
import com.dousiwei.springbootdayang.pojo.eneity.User;
import com.dousiwei.springbootdayang.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper UserMapper;
    /**
     * 用户注册
     * @param userDTO
     */
    @Override
    public void register(UserDTO userDTO) {
        String username = userDTO.getUsername();
        //根据用户名查询是否已经存在
        User user1 = UserMapper.getByUsername(username);
        if (user1 != null) {
            //用户名已经存在
            throw new ArithmeticException("用户名已经存在");
        }
        User user =new User();
        // 将dto对象拷贝到entity对象中
        BeanUtils.copyProperties(userDTO,user);
        //设置帐号状态
        user.setStatus(1);
        // 添加插入时间
        user.setRegisterDate(LocalDateTime.now());
        // 插入数据库
        UserMapper.insert(user);
    }

    /**
     * 用户登录
     * @param userLoginDTO
     */
    @Override
    public User login(UserLoginDTO userLoginDTO) {
        String username = userLoginDTO.getUsername();
        String password = userLoginDTO.getPassword();
        // 根据用户名查询用户信息
        User user = UserMapper.getByUsername(username);
        // 判断用户是否存在
        if (user == null) {
            //用户不存在
            throw new ArithmeticException("用户不存在");
        }
        //判断用户名是否正确
        if (!user.getPassword().equals(password)) {
            //密码错误
            throw new ArithmeticException("密码错误");
        }
        //判断帐号状态
        if (user.getStatus() == 0) {
            //帐号被禁用
            throw new ArithmeticException("帐号被禁用");
        }
        //返回对象
        return user;
    }
    //查询用户信息
    @Override
    public User getById(int userId) {
        User user = UserMapper.getById(userId);
        return user;
    }
    //修改用户信息
    @Override
    public void update(UserUpdateDTO userUpdateDTO) {
        User user = new User();
        BeanUtils.copyProperties(userUpdateDTO,user);

        UserMapper.update(user);
    }
}
