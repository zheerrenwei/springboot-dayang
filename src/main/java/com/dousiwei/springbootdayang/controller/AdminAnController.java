package com.dousiwei.springbootdayang.controller;


import com.dousiwei.springbootdayang.pojo.dto.AnnoDTO;
import com.dousiwei.springbootdayang.pojo.dto.AnnoUpdateDTO;
import com.dousiwei.springbootdayang.pojo.dto.PageDTO;
import com.dousiwei.springbootdayang.pojo.eneity.Announcement;
import com.dousiwei.springbootdayang.result.PageResult;
import com.dousiwei.springbootdayang.result.Result;
import com.dousiwei.springbootdayang.service.AdminAnService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/announcements")
@Slf4j
@Tag(name = "3管理员管理公告")
public class AdminAnController {

    @Autowired
    private AdminAnService adminAnService;

    //添加公告
    @PostMapping
    @Operation(summary = "添加公告")
    public Result add(@RequestBody AnnoDTO annoDTO){
        log.info("添加公告：{}", annoDTO);
        adminAnService.add(annoDTO);
        return Result.success();
    }

    //分页查询
    @GetMapping("/page")
    @Operation(summary = "分页查询")
    public Result<PageResult> page(@ParameterObject PageDTO pageDTO){
        log.info("分页查询公告：{}", pageDTO);
        PageResult pageResult= adminAnService.page(pageDTO);
        return Result.success(pageResult);
    }

    //删除公告
    @DeleteMapping("/{id}")
    @Operation(summary = "删除公告")
    public Result delete(@PathVariable("id") Integer id){
        log.info("删除公告：{}", id);
        adminAnService.deleteById(id);
        return Result.success();
    }

    //修改公告
    //根据id回显
    @GetMapping("/{id}")
    @Operation(summary = "根据id查询公告信息")
    public Result<Announcement> getById(@PathVariable("id") Integer id){
        log.info("根据id查询公告信息：{}", id);
        Announcement announcement = adminAnService.getById(id);
        return Result.success(announcement);
    }

    //修改公告
    @PutMapping("/update")
    @Operation(summary = "修改公告信息")
    public Result update(@RequestBody AnnoUpdateDTO annoUpdateDTO){
        log.info("修改公告信息：{}", annoUpdateDTO);
        adminAnService.update(annoUpdateDTO);
        return Result.success();
    }
}
