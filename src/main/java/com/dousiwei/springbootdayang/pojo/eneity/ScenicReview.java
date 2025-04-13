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
public class ScenicReview {
    private int reviewId;
    private int scenicId;  // 可扩展为 ScenicSpot 对象
    private int userId;    // 可扩展为 User 对象
    private int rating;    // 1-5 分
    private String comment;
    private LocalDateTime reviewDate;
}
