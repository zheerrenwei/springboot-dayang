package com.dousiwei.springbootdayang.pojo.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class HroomDTO implements Serializable {
    private String name;  // 可扩展为 Hotel 对象引用
    private String roomType;
    private String description;
    private BigDecimal price;
    private int bedCount;
    private int capacity;
    private int availableCount;
}
