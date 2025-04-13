package com.dousiwei.springbootdayang.interceptor;

import com.dousiwei.springbootdayang.result.Result;
import com.dousiwei.springbootdayang.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断当前拦截到的是Controller的方法还是其他资源
        if (!(handler instanceof HandlerMethod)) {
            //当前拦截到的不是动态方法，直接放行
            return true;
        }
        // 获取请求头中的token
        String token = request.getHeader("token");
        if (token == null || token.isEmpty()) {
            response.setStatus(401);
            response.getWriter().write("未提供token");
        }
        // 解析token
//        try {
//            Map<String, Object> map = JwtUtil.parseToken(token);
//            // 解析成功，放行
//            return true;
//        } catch (Exception e) {
//            response.setStatus(401);
//            // 解析失败，拦截
//            return false;
//        }
        try {
            //从redis中获取token
//            String redisToken = stringRedisTemplate.opsForValue().get(token);
//            if (redisToken == null || redisToken.isEmpty()) {
//                response.setStatus(401);
//                response.getWriter().write("token已过期");
//                return false;
//            }
            // 解析token
            Map<String, Object> map = JwtUtil.parseToken(token);
            log.info(map.toString());
            //获取角色
            String role = (String) map.get("role");
            if (role == null) {
                response.setStatus(401);
                response.getWriter().write("未提供角色");
                log.info("未提供角色");
                return false;
            }

            //获取请求路径
            String requestURI = request.getRequestURI();
            if (role.equals("USER") && requestURI.startsWith("/admin")) {
                response.setStatus(403);
                response.getWriter().write("无权限访问管理员界面");
                log.info("无权限访问管理员界面");
                return false;
            }
            if (role.equals("ADMIN") && requestURI.startsWith("/users")){
                response.setStatus(403);
                response.getWriter().write("无权限访问用户界面");
                log.info("无权限访问用户界面");
                return false;
            }

            // 存入 request 方便 Controller 获取
            request.setAttribute("role", role);
            return true;
        } catch (Exception e) {
            response.setStatus(401);
            // 解析失败，拦截
            response.getWriter().write("token解析失败");
            return false;
        }
    }
}


