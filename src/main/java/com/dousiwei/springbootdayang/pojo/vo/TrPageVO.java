package com.dousiwei.springbootdayang.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class TrPageVO implements Serializable {
    private int reservationId;
    private String username;
    private String ticketName;
    private int quantity;
    private BigDecimal totalPrice;
    private String status;  // booked, cancelled 等
}
