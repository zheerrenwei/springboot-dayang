package com.dousiwei.springbootdayang.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class AnPageVO implements Serializable {
    private int announcementId;
    private String title;
    private String content;
    private LocalDateTime publishedTime;
    private String adminName;
}
