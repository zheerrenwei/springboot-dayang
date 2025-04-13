package com.dousiwei.springbootdayang.controller;

import com.dousiwei.springbootdayang.pojo.dto.HotelAddDTO;
import com.dousiwei.springbootdayang.pojo.dto.ScenicReviewDTO;
import com.dousiwei.springbootdayang.pojo.dto.TicketAddDTO;
import com.dousiwei.springbootdayang.pojo.eneity.HotelReservation;
import com.dousiwei.springbootdayang.pojo.eneity.TicketReservation;
import com.dousiwei.springbootdayang.pojo.vo.UserHoVO;
import com.dousiwei.springbootdayang.pojo.vo.UserTkVO;
import com.dousiwei.springbootdayang.result.Result;
import com.dousiwei.springbootdayang.service.CommonUService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "2用户通用接口")
@RequestMapping("/users")
@Slf4j
public class CommonUController {
    @Autowired
    private CommonUService commonUService;
    //留言功能
    @PostMapping("/scenic_reviews")
    @Operation(summary = "用户留言功能")
    public Result scenic_reviews(@RequestBody ScenicReviewDTO scenicReviewDTO){
        log.info("用户留言：{}", scenicReviewDTO);
        commonUService.scenic_reviews(scenicReviewDTO);
        return Result.success();
    }
    //酒店预约
    @PostMapping("/hotel_reservations")
    @Operation(summary = "用户酒店预约功能")
    public Result addHotel(@RequestBody HotelAddDTO hotelAddDTO){
        log.info("用户酒店预约：{}", hotelAddDTO);
        commonUService.addHotel(hotelAddDTO);
        return Result.success();
    }
    //门票预约
    @PostMapping("/ticket_reservations")
    @Operation(summary = "用户门票预约功能")
    public Result addTicket(@RequestBody TicketAddDTO ticketAddDTO){
        log.info("用户门票预约：{}", ticketAddDTO);
        commonUService.addTicket(ticketAddDTO);
        return Result.success();
    }
    //酒店预约查询
    @GetMapping("/hotel_reservations/{user_id}")
    @Operation(summary = "用户酒店预约查询功能")
    public Result getHotel(@PathVariable Integer user_id){
        Integer userId = user_id;
        log.info("用户酒店预约查询：{}", userId);
        List<UserHoVO> list = commonUService.getHotel(userId);
        return Result.success(list);
    }
    //门票预约查询
    @GetMapping("/ticket_reservations/{user_id}")
    @Operation(summary = "用户门票预约查询功能")
    public Result getTicket(@PathVariable Integer user_id){
        Integer userId = user_id;
        log.info("用户门票预约查询：{}", userId);
        List<UserTkVO> list = commonUService.getTicket(userId);
        return Result.success(list);
    }
}
