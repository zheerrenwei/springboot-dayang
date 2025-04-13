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
public class Announcement {
    private int announcementId;
    private String title;
    private String content;
    private LocalDateTime publishedTime;
    private int adminId; // 可扩展为 Admin 对象引用
}
