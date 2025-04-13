package com.dousiwei.springbootdayang.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserTkVO implements Serializable {
    private String ticketName;
    private int quantity;
    private BigDecimal totalPrice;
    private String status;  // booked, cancelled 等
    private LocalDateTime createTime;
}
