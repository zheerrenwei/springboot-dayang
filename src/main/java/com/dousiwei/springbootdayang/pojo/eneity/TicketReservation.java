package com.dousiwei.springbootdayang.pojo.eneity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketReservation {
    private int reservationId;
    private int userId;   // 可扩展为 User 对象引用
    private int ticketId; // 可扩展为 Ticket 对象引用
    private int quantity;
    private BigDecimal totalPrice;
    private String status;  // booked, cancelled 等
    private LocalDateTime createTime;
}
