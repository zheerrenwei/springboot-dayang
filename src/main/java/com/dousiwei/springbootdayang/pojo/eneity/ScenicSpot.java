package com.dousiwei.springbootdayang.pojo.eneity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScenicSpot {
    private int scenicId;
    private String name;
    private String description;
    private String address;
    private String phone;
    private String openTime; // 如 "08:00-18:00"
    private String image;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
