package com.dousiwei.springbootdayang.pojo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "管理员登陆返回数据格式")
public class AdminLoginVO implements Serializable {
    @Schema(description = "主键")
    private Integer adminId;
    @Schema(description = "用户名")
    private String adminName;
    @Schema(description = "密码")
    private String password;
    @Schema(description = "jwt令牌")
    private String token;
}
