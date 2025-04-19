package com.dousiwei.springbootdayang.pojo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ScenicReviewDTO implements Serializable {
    // 景点id
    private String name;
    // 用户id
    private Integer userId;
    // 评分
    private Integer rating;
    //品论
    private String comment;
}
