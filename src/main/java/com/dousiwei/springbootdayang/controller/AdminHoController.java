package com.dousiwei.springbootdayang.controller;


import com.dousiwei.springbootdayang.pojo.dto.HoDTO;
import com.dousiwei.springbootdayang.pojo.dto.HoUpdateDTO;
import com.dousiwei.springbootdayang.pojo.dto.PageDTO;
import com.dousiwei.springbootdayang.pojo.dto.SsPageDTO;
import com.dousiwei.springbootdayang.pojo.eneity.Hotel;
import com.dousiwei.springbootdayang.result.PageResult;
import com.dousiwei.springbootdayang.result.Result;
import com.dousiwei.springbootdayang.service.AdminHoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/admin/hotels")
@Slf4j
@Tag(name = "3酒店管理相关接口")
@RestController
public class AdminHoController {
    @Autowired
    private AdminHoService adminHoService;
    //新增酒店
    @PostMapping
    @Operation(summary = "新增酒店")
    public Result add(@RequestBody HoDTO hoDTO) {
        log.info("新增酒店：{}", hoDTO);
        adminHoService.add(hoDTO);
        return Result.success();
    }
    //分页查询
    @GetMapping ("/page")
    @Operation(summary = "分页查询")
    public Result<PageResult> page(@ParameterObject SsPageDTO pageDTO){
        log.info("分页查询数据为",pageDTO);
        PageResult pageResult = adminHoService.page(pageDTO);
        return Result.success(pageResult);
    }
    //根据id查询酒店信息
    @GetMapping("/{id}")
    @Operation(summary = "根据id查询酒店信息")
    public Result<Hotel> getById(@PathVariable Integer id){
        log.info("根据id查询酒店信息：{}",id);
        Hotel hotel = adminHoService.getById(id);
        return Result.success(hotel);
    }
    //修改酒店信息
    @PutMapping("/update")
    @Operation(summary = "修改酒店信息")
    public Result update(@RequestBody HoUpdateDTO updateDTO){
        log.info("修改酒店信息：{}",updateDTO);
        adminHoService.update(updateDTO);
        return Result.success();
    }
    //删除酒店
    @DeleteMapping("/{id}")
    @Operation(summary = "删除酒店")
    public Result delete(@PathVariable Integer id){
        log.info("删除酒店：{}",id);
        adminHoService.delete(id);
        return Result.success();
    }
}

