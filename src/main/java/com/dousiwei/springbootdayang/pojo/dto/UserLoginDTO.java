package com.dousiwei.springbootdayang.pojo.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
@Data
@Schema(description = "用户登录信息")
public class UserLoginDTO implements Serializable {
    @Schema(description = "用户名")
    private String username;
    @Schema(description = "密码")
    private String password;
}
