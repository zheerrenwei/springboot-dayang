package com.dousiwei.springbootdayang.utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
//Jwt工具类
public class JwtUtil {
    private static final String SECRET_KEY = "yourSecretKey"; // 你的密钥
    private static final long EXPIRATION_TIME = 84000000; // 1小时
    // 生成JWT令牌
    public static String generateToken(String username,String role) {
        log.info("返回角色：{}", role);
        // 生成JWT令牌
        return JWT.create()
                .withSubject(username)
                .withClaim("role", role)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC256(SECRET_KEY));
    }

    //解析token
    public static Map<String, Object> parseToken(String token) {
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(SECRET_KEY))
                .build()
                .verify(token);

        Map<String, Object> claims = new HashMap<>();
        claims.put("username", decodedJWT.getSubject());
        claims.put("role", decodedJWT.getClaim("role").asString()); // 解析角色
        return claims;
    }
}
