package com.dousiwei.springbootdayang.pojo.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class TicketDTO implements Serializable {
    private String ticketName;
    private BigDecimal price;
    private String description;
    private int availableCount;
}
