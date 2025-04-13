package com.dousiwei.springbootdayang.mapper;

import com.dousiwei.springbootdayang.pojo.dto.PageDTO;
import com.dousiwei.springbootdayang.pojo.dto.SsPageDTO;
import com.dousiwei.springbootdayang.pojo.eneity.Hotel;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminHoMapper {
    // 添加酒店信息
    void add(Hotel hotel);
    // 分页查询
    Page<Hotel> page(SsPageDTO pageDTO);
    // 根据id查询酒店信息
    @Select("select * from dayang_tourism.hotels where hotel_id = #{id}")
    Hotel getById(Integer id);
    //根据酒店名称返回酒店id
    @Select("select hotel_id from dayang_tourism.hotels where name = #{name}")
    Integer getIdByName(String name);
    // 修改酒店信息
    void update(Hotel hotel);
    // 删除酒店信息
    @Delete("delete from dayang_tourism.hotels where hotel_id = #{id}")
    void delete(Integer id);
}
