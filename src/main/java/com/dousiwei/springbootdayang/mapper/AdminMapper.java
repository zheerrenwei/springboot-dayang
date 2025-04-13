package com.dousiwei.springbootdayang.mapper;

import com.dousiwei.springbootdayang.pojo.dto.AdminPageDTO;
import com.dousiwei.springbootdayang.pojo.eneity.Admin;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminMapper {
    //根据用户名查询管理员信息
    @Select("select * from dayang_tourism.admins where admin_name = #{adminName}")
    Admin getByAdminName(String adminName);
    //插入管理员信息
    @Insert("insert into dayang_tourism.admins(admin_name,password,email,phone,role,create_time) values(#{adminName},#{password},#{email},#{phone},#{role},#{createTime})")
    void insert(Admin admin);
    //分页查询管理员信息
    Page<Admin> page(AdminPageDTO adminPageDTO);
    //修改管理员信息
    void update(Admin admin);
    //根据id查询管理员信息
    @Select("select * from dayang_tourism.admins where admin_id = #{adminId}")
    Admin getById(int adminId);
    @Delete("delete from dayang_tourism.admins where admin_id = #{adminId}")
    void delete(int adminId);
}
