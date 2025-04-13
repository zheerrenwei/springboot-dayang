package com.dousiwei.springbootdayang.pojo.eneity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {
    private int ticketId;
    private String ticketName;
    private BigDecimal price;
    private String description;
    private int availableCount;
}
