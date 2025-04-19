package com.dousiwei.springbootdayang.controller;


import com.dousiwei.springbootdayang.pojo.dto.AdminUserPageDTO;
import com.dousiwei.springbootdayang.pojo.dto.UserUpdateDTO;
import com.dousiwei.springbootdayang.pojo.eneity.User;
import com.dousiwei.springbootdayang.result.PageResult;
import com.dousiwei.springbootdayang.result.Result;
import com.dousiwei.springbootdayang.service.AdminUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/admin/users")
@Tag(name = "3用户管理相关接口")
public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;
    // 用户分页查询
    @GetMapping("/page")
    @Operation(summary = "用户分页查询")
    public Result<PageResult> getUsers(@ParameterObject AdminUserPageDTO adminUserPageDTO) {
        log.info("用户分页查询：{}", adminUserPageDTO);
        PageResult pageResult = adminUserService.page(adminUserPageDTO);
        return Result.success(pageResult);
    }

    //修改用户信息
    //根据id回显用户信息
    @GetMapping("/{user_id}")
    @Operation(summary = "根据id查询用户信息")
    public Result<User> getById(@PathVariable int user_id){
        log.info("查询当前用户信息：{}", user_id);
        User user = adminUserService.getById(user_id);
        return Result.success(user);
    }
    //修改用户信息
    @PutMapping("/update")
    @Operation(summary = "修改用户信息")
    public Result update(@RequestBody UserUpdateDTO userUpdateDTO){
        log.info("修改用户的信息：{}", userUpdateDTO);
        adminUserService.update(userUpdateDTO);
        return Result.success();
    }

    //删除用户
    @DeleteMapping("/{user_id}")
    @Operation(summary = "删除用户")
    public Result delete(@PathVariable int user_id){
        log.info("删除用户：{}", user_id);
        adminUserService.delete(user_id);
        return Result.success();
    }

    // 修改用户状态
    @PostMapping("/status")
    @Operation(summary = "修改用户状态")
    public Result status(int status, int userId) {
        log.info("修改用户状态：{},{}", status, userId);
        adminUserService.updateStatus(status, userId);
        return Result.success();
    }
}
