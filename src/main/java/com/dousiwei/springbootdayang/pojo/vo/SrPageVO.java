package com.dousiwei.springbootdayang.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class SrPageVO implements Serializable {
    private int reviewId;
    private String name;
    private String username;
    private int rating;    // 1-5 分
    private String comment;
    private LocalDateTime reviewDate;
}
