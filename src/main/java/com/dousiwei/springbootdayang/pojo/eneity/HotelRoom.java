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
public class HotelRoom {
    private int roomId;
    private int hotelId;  // 可扩展为 Hotel 对象引用
    private String roomType;
    private String description;
    private BigDecimal price;
    private int bedCount;
    private int capacity;
    private int availableCount;
}
