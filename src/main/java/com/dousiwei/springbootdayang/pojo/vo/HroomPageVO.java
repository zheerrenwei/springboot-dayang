package com.dousiwei.springbootdayang.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class HroomPageVO implements Serializable {
    private int roomId;
    private String name;
    private String roomType;
    private String description;
    private BigDecimal price;
    private int bedCount;
    private int capacity;
    private int availableCount;
}
