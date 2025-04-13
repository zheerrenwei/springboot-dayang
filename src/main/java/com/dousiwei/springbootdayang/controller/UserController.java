package com.dousiwei.springbootdayang.controller;

import com.dousiwei.springbootdayang.pojo.dto.UserDTO;
import com.dousiwei.springbootdayang.pojo.dto.UserLoginDTO;
import com.dousiwei.springbootdayang.pojo.dto.UserUpdateDTO;
import com.dousiwei.springbootdayang.pojo.eneity.User;
import com.dousiwei.springbootdayang.pojo.vo.UserLoginVO;
import com.dousiwei.springbootdayang.result.Result;
import com.dousiwei.springbootdayang.service.UserService;
import com.dousiwei.springbootdayang.utils.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/users")
@Slf4j
@Tag(name = "2用户个人管理相关接口")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    /**
     * 用户注册
     * @param userDTO
     * @return
     */
    @PostMapping("/register")
    @Operation(summary = "用户注册")
    public Result register(@RequestBody UserDTO userDTO){
        log.info("用户注册：{}", userDTO);
        userService.register(userDTO);
        return Result.success();
    }

    /**
     * 用户登录
     * @param userLoginDTO
     * @return
     */
    @Operation(summary = "用户登录")
    @PostMapping("/login")
    public Result<UserLoginVO> login(@RequestBody UserLoginDTO userLoginDTO){
        log.info("用户登录：{}", userLoginDTO);
        User user = userService.login(userLoginDTO);
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", user.getUserId());
        claims.put("username", user.getUsername());
        String role = "USER";
        String token = JwtUtil.generateToken(user.getUsername(),role);
        UserLoginVO userLoginVO = UserLoginVO.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .password(user.getPassword())
                .token(token)
                .build();
        return Result.success(userLoginVO);
    }
    //个人用户管理
    //获取个人信息
    @GetMapping("/{user_id}")
    @Operation(summary = "查询当前用户信息")
    public Result<User> getById(@PathVariable int user_id){
        log.info("查询当前用户信息：{}", user_id);
        User user = userService.getById(user_id);
        return Result.success(user);
    }
    //修改个人信息
    @PutMapping("/update")
    @Operation(summary = "修改自己的信息")
    public Result update(@RequestBody UserUpdateDTO userUpdateDTO){
        log.info("修改自己的信息：{}", userUpdateDTO);
        userService.update(userUpdateDTO);
        return Result.success();
    }

}
