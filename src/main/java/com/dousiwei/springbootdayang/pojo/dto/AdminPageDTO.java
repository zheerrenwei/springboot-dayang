package com.dousiwei.springbootdayang.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema
public class AdminPageDTO implements Serializable {
    //管理员姓名
    @Schema
    private String adminName;
    //页码
    @Schema
    private int page;
    //每页条数
    @Schema
    private int pagesize;
}
