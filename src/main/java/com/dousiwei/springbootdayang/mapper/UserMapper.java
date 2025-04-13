package com.dousiwei.springbootdayang.mapper;

import com.dousiwei.springbootdayang.pojo.eneity.User;
import io.swagger.v3.oas.annotations.media.Schema;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    @Select("select * from users where username = #{username}")
    User getByUsername(String username);

    /**
     * 用户注册
     * @param user
     */
    @Insert("insert into users(username,password,email,phone,register_date,status) values(#{username},#{password},#{email},#{phone},#{registerDate},#{status})")
    void insert(User user);
    // 根据id查询用户
    @Select("select * from users where user_id = #{userId}")
    User getById(int userId);
    // 修改用户信息
    void update(User user);
}
