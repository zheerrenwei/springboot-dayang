package com.dousiwei.springbootdayang.pojo.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class AnnoDTO implements Serializable {
    private String title;
    private String content;
    private int adminId; // 可扩展为 Admin 对象引用
}
