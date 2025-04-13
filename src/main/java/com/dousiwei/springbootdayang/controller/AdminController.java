package com.dousiwei.springbootdayang.controller;


import com.dousiwei.springbootdayang.pojo.dto.AdminDTO;
import com.dousiwei.springbootdayang.pojo.dto.AdminLoginDTO;
import com.dousiwei.springbootdayang.pojo.dto.AdminPageDTO;
import com.dousiwei.springbootdayang.pojo.dto.AdminUpdateDTO;
import com.dousiwei.springbootdayang.pojo.eneity.Admin;
import com.dousiwei.springbootdayang.pojo.vo.AdminLoginVO;
import com.dousiwei.springbootdayang.result.PageResult;
import com.dousiwei.springbootdayang.result.Result;
import com.dousiwei.springbootdayang.service.AdminService;
import com.dousiwei.springbootdayang.utils.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/admin")
@Tag(name = "3管理员管理相关接口")
@Slf4j
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    // 管理员登录
    @PostMapping("/login")
    @Operation(summary = "管理员登录")
    public Result<AdminLoginVO> login(@RequestBody AdminLoginDTO adminLoginDTO){
        log.info("管理员登录：{}", adminLoginDTO);
        Admin admin = adminService.login(adminLoginDTO);
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", admin.getAdminId());
        claims.put("username", admin.getAdminName());
        String role = "ADMIN";
        String token = JwtUtil.generateToken(admin.getAdminName(),role);
        AdminLoginVO adminLoginVO = AdminLoginVO.builder()
                .adminId(admin.getAdminId())
                .adminName(admin.getAdminName())
                .password(admin.getPassword())
                .token(token)
                .build();
        return Result.success(adminLoginVO);
    }
    //管理员登出
    @PostMapping("/logout")
    @Operation(summary = "管理员登出")
    public Result<String> logout(){
        return Result.success("退出成功");
    }
    //添加管理员
    @PostMapping("/add")
    @Operation(summary = "添加管理员")
    public Result addAdmin(@RequestBody AdminDTO adminDTO){
        log.info("添加管理员：{}", adminDTO);
        adminService.addAdmin(adminDTO);
        return Result.success();
    }
    //分页查询
    @GetMapping("/page")
    @Operation(summary = "分页查询")
    public Result<PageResult> page(@ParameterObject AdminPageDTO adminPageDTO){
        log.info("分页查询数据为",adminPageDTO);
        PageResult pageResult = adminService.page(adminPageDTO);
        return Result.success(pageResult);
    }
    //启用或禁用管理员
    @PostMapping("/role")
    @Operation(summary = "启用或禁用管理员")
    public Result role(Integer status,int adminId){
        log.info("启用或禁用管理员：{}", status);
        adminService.role(status,adminId);
        return Result.success();
    }
    //修改管理员信息
    //根据id查询管理员信息
    @GetMapping("/{id}")
    @Operation(summary = "根据id查询管理员信息")
    public Result<Admin> getById(@PathVariable("id") int adminId){
        log.info("根据id查询管理员信息：{}", adminId);
        Admin admin = adminService.getById(adminId);
        return Result.success(admin);
    }
    //修改管理员信息
    @PutMapping("/update")
    @Operation(summary = "修改管理员信息")
    public Result update(@RequestBody AdminUpdateDTO adminUpdateDTO){
        log.info("修改管理员信息：{}", adminUpdateDTO);
        adminService.update(adminUpdateDTO);
        return Result.success();
    }
    //删除管理员
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "删除管理员")
    public Result delete(@PathVariable("id") int adminId){
        log.info("删除管理员：{}", adminId);
        adminService.delete(adminId);
        return Result.success();
    }
}
