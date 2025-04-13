package com.dousiwei.springbootdayang.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class HrPageVO implements Serializable {
    private int reservationId;
    private String username;
    private String name;
    private String roomType;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private BigDecimal totalPrice;
    private String status;  // booked, cancelled 等
    private LocalDateTime createTime;
}
