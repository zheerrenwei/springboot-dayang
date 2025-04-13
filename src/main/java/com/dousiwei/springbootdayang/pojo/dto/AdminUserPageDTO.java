package com.dousiwei.springbootdayang.pojo.dto;

import com.dousiwei.springbootdayang.pojo.eneity.User;
import com.github.pagehelper.Page;
import lombok.Data;

import java.io.Serializable;

@Data
public class AdminUserPageDTO implements Serializable {
    //用户名
    private String username;
    //页码
    private int page;
    //每页条数
    private int pagesize;

}
