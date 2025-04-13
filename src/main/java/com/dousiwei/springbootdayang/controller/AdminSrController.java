package com.dousiwei.springbootdayang.controller;

import com.dousiwei.springbootdayang.pojo.dto.SrPageDTO;
import com.dousiwei.springbootdayang.result.PageResult;
import com.dousiwei.springbootdayang.result.Result;
import com.dousiwei.springbootdayang.service.AdminSrService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin/scenic_reviews")
@Slf4j
@Tag(name = "3管理员评论管理")
public class AdminSrController {
    @Autowired
    private AdminSrService adminSrService;
    // 分页查询
    @GetMapping("/page")
    @Operation(summary = "分页查询")
    public Result<PageResult> page(@ParameterObject SrPageDTO srPageDTO) {
        log.info("分页查询数据为", srPageDTO);
        PageResult pageResult = adminSrService.page(srPageDTO);
        return Result.success(pageResult);
    }

    //删除评论
    @DeleteMapping("/{id}")
    @Operation(summary = "根据评论id删除评论")
    public Result delete(@PathVariable("id") Integer id) {
        log.info("删除评论id为", id);
        adminSrService.deleteById(id);
        return Result.success();
    }
}
