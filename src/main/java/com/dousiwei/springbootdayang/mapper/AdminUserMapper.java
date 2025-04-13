package com.dousiwei.springbootdayang.mapper;

import com.dousiwei.springbootdayang.pojo.dto.AdminUserPageDTO;
import com.dousiwei.springbootdayang.pojo.eneity.User;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminUserMapper {
    // 分页查询
    Page<User> page(AdminUserPageDTO adminUserPageDTO);
    // 根据id查询用户信息
    @Select("select * from dayang_tourism.users where user_id = #{userId}")
    User getById(int userId);
    // 修改用户信息
    void update(User user);
    // 删除用户
    @Delete("delete from dayang_tourism.users where user_id = #{userId}")
    void delete(int userId);
}
