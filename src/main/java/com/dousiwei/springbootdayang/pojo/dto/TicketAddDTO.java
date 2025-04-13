package com.dousiwei.springbootdayang.pojo.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class TicketAddDTO implements Serializable {
    // 用户id
    private Integer userId;
    // 门票id
    private Integer ticketId;
    // 购买数量
    private Integer quantity;
    // 总价
    private BigDecimal totalPrice;
}
