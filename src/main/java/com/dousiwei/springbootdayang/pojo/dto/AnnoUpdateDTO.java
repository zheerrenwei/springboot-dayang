package com.dousiwei.springbootdayang.pojo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AnnoUpdateDTO implements Serializable {
    private int announcementId;
    private String title;
    private String content;
}
