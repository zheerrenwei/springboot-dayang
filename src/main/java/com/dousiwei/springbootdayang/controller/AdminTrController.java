package com.dousiwei.springbootdayang.controller;


import com.dousiwei.springbootdayang.pojo.dto.HrPageDto;
import com.dousiwei.springbootdayang.pojo.dto.TrPageDTO;
import com.dousiwei.springbootdayang.result.PageResult;
import com.dousiwei.springbootdayang.result.Result;
import com.dousiwei.springbootdayang.service.AdminTrService;
import com.github.pagehelper.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Past;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/ticket_reservations")
@Slf4j
@Tag(name = "3景点门票管理相关接口")
public class AdminTrController {
    @Autowired
    private AdminTrService adminTrService;

    // 分页查询
    @GetMapping("/page")
    @Operation(summary = "分页查询")
    public Result<PageResult> page(@ParameterObject TrPageDTO trPageDTO) {
        log.info("分页查询数据为",trPageDTO);
        log.info(String.valueOf(trPageDTO.getPage()));
        log.info(String.valueOf(trPageDTO.getPagesize()));
        PageResult pageResult = adminTrService.page(trPageDTO);
        return Result.success(pageResult);
    }

    // 修改预约状态
    @GetMapping("/{reservation_id}")
    @Operation(summary = "完成预约")
    public Result update(@PathVariable("reservation_id") Integer id) {
        log.info("修改预约状态为完成");
        adminTrService.bookOrFinish(id);
        return Result.success();
    }

    // 删除预约
    @DeleteMapping("/{reservation_id}")
    @Operation(summary = "删除预约")
    public Result delete(@PathVariable("reservation_id") Integer id) {
        log.info("删除预约");
        adminTrService.deleteByReId(id);
        return Result.success();
    }
}
