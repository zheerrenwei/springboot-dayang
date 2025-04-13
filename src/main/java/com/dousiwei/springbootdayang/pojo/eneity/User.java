package com.dousiwei.springbootdayang.pojo.eneity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private int userId;
    private String username;
    private String password;
    private String email;
    private String phone;
    private LocalDateTime registerDate;
    private int status; // 1: 正常, 0: 禁用
}
