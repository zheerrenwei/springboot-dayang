package com.dousiwei.springbootdayang.pojo.eneity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelReservation {
    private int reservationId;
    private int userId;   // 可扩展为 User 对象引用
    private int hotelId;  // 可扩展为 Hotel 对象引用
    private int roomId;   // 可扩展为 HotelRoom 对象引用
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private BigDecimal totalPrice;
    private String status;  // booked, cancelled 等
    private LocalDateTime createTime;
}
