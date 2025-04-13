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
public class Hotel {
    private int hotelId;
    private String name;
    private String description;
    private String address;
    private String phone;
    private int stars; // 酒店星级，例如 3、4、5
    private String image;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
