package com.dousiwei.springbootdayang.controller;

import com.dousiwei.springbootdayang.pojo.dto.HrPageDto;
import com.dousiwei.springbootdayang.pojo.eneity.HotelReservation;
import com.dousiwei.springbootdayang.result.PageResult;
import com.dousiwei.springbootdayang.result.Result;
import com.dousiwei.springbootdayang.service.AdminHrService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/hotel_reservations")
@Slf4j
@Tag(name = "3酒店预订管理相关接口")
public class AdminHrController {
    @Autowired
    private AdminHrService adminHrService;
    //分页查询预约
    @GetMapping("/page")
    @Operation(summary = "分页查询预约")
    public Result<PageResult> page(@ParameterObject HrPageDto hrPageDto) {
        log.info("分页查询预约：{}", hrPageDto);
        PageResult page= adminHrService.page(hrPageDto);
        return Result.success(page);
    }

    //修改预约状态
    @PostMapping("/{reservation_id}")
    @Operation(summary = "完成预约")
    public Result update(@PathVariable("reservation_id") Integer id) {
        log.info("修改预约状态：{}", id);
        adminHrService.bookOrFinish(id);
        return Result.success();
    }

    //删除预约
    @DeleteMapping("/{reservation_id}")
    @Operation(summary = "删除预约")
    public Result delete(@PathVariable("reservation_id") Integer id) {
        log.info("删除预约：{}", id);
        adminHrService.deleteByReId(id);
        return Result.success();
    }
}
