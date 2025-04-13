package com.dousiwei.springbootdayang.pojo.dto;


import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;


@Data
public class HotelAddDTO implements Serializable {
    //用户id
    private Integer userId;
    //酒店id
    private Integer hotelId;
    //房间id
    private Integer roomId;
    //入住时间
    private LocalDate checkInDate;
    //退房时间
    private LocalDate checkOutDate;
    //价格
    private BigDecimal totalPrice;
}
