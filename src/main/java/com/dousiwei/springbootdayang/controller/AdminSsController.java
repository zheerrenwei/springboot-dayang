package com.dousiwei.springbootdayang.controller;


import com.dousiwei.springbootdayang.pojo.dto.PageDTO;
import com.dousiwei.springbootdayang.pojo.dto.SsDTO;
import com.dousiwei.springbootdayang.pojo.dto.SsPageDTO;
import com.dousiwei.springbootdayang.pojo.dto.SsUpdateDTO;
import com.dousiwei.springbootdayang.pojo.eneity.ScenicSpot;
import com.dousiwei.springbootdayang.result.PageResult;
import com.dousiwei.springbootdayang.result.Result;
import com.dousiwei.springbootdayang.service.AdminService;
import com.dousiwei.springbootdayang.service.AdminSsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("admin/scenic_spots")
@Tag(name = "3景点管理相关接口")
public class AdminSsController {
    @Autowired
    private AdminSsService adminSsService;
    //新增景点
    @PostMapping
    @Operation(summary = "新增景点")
    public Result add(@RequestBody SsDTO ssDTO){
        log.info("新增景点：{}", ssDTO);
        adminSsService.add(ssDTO);
        return Result.success();
    }
    //分页查询
    @GetMapping ("/page")
    @Operation(summary = "分页查询")
    public Result<PageResult> page(@ParameterObject SsPageDTO pageDTO){
        log.info("分页查询数据为",pageDTO);
        PageResult pageResult = adminSsService.page(pageDTO);
        return Result.success(pageResult);
    }
    //修改景点
    //id回显
    @GetMapping("/{id}")
    @Operation(summary = "根据id查询景点信息")
    public Result<ScenicSpot> getById(@PathVariable Integer id){
        log.info("查询当前景点信息：{}", id);
        ScenicSpot scenicSpot = adminSsService.getById(id);
        return Result.success(scenicSpot);
    }
    //修改景点
    @PutMapping("/update")
    @Operation(summary = "修改景点信息")
    public Result update(@RequestBody SsUpdateDTO ssUpdateDTO){
        log.info("修改景点信息：{}", ssUpdateDTO);
        adminSsService.update(ssUpdateDTO);
        return Result.success();
    }
    //删除景点
    @DeleteMapping("/{id}")
    @Operation(summary = "删除景点")
    public Result delete(@PathVariable Integer id){
        log.info("删除景点：{}", id);
        adminSsService.delete(id);
        return Result.success();
    }
}
