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
public class Admin {
    private int adminId;
    private String adminName;
    private String password;
    private String email;
    private String phone;
    private String role; // super / normal，可用枚举优化
    private LocalDateTime createTime;
}
