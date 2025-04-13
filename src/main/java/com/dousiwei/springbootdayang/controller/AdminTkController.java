package com.dousiwei.springbootdayang.controller;


import com.dousiwei.springbootdayang.pojo.dto.PageDTO;
import com.dousiwei.springbootdayang.pojo.dto.TicketDTO;
import com.dousiwei.springbootdayang.pojo.eneity.Ticket;
import com.dousiwei.springbootdayang.result.PageResult;
import com.dousiwei.springbootdayang.result.Result;
import com.dousiwei.springbootdayang.service.AdminTkService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/admin/tickets")
@RestController
@Slf4j
@Tag(name = "3门票管理相关接口")
public class AdminTkController {
    @Autowired
    private AdminTkService adminTkService;
    //添加门票
    @PostMapping("/add")
    @Operation(summary = "添加门票")
    public Result add(@RequestBody TicketDTO ticketDTO){
        log.info("添加门票：{}", ticketDTO);
        adminTkService.add(ticketDTO);
        return Result.success();
    }
    //分页查询
    @GetMapping("/page")
    @Operation(summary = "分页查询门票")
    public Result<PageResult> page(@ParameterObject PageDTO pageDTO){
        log.info("分页查询门票：{}", pageDTO);
        PageResult pageResult= adminTkService.page(pageDTO);
        return Result.success(pageResult);
    }

    //修改门票
    //按id 回显
    @GetMapping("/{id}")
    @Operation(summary = "根据id查询门票信息")
    public Result<Ticket> getById(@PathVariable Integer id){
        log.info("查询当前门票信息：{}", id);
        Ticket ticket = adminTkService.getById(id);
        return Result.success(ticket);
    }
    //修改门票
    @PutMapping("/update")
    @Operation(summary = "修改门票信息")
    public Result update(@RequestBody Ticket ticket){
        log.info("修改门票信息：{}", ticket);
        adminTkService.update(ticket);
        return Result.success();
    }

    //删除门票
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "删除门票")
    public Result delete(@PathVariable Integer id){
        log.info("删除门票：{}", id);
        adminTkService.delete(id);
        return Result.success();
    }
}
