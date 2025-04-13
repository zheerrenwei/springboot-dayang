package com.dousiwei.springbootdayang.mapper;

import com.dousiwei.springbootdayang.pojo.dto.PageDTO;
import com.dousiwei.springbootdayang.pojo.dto.SsPageDTO;
import com.dousiwei.springbootdayang.pojo.eneity.ScenicSpot;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminSsMapper {
    // 新增景点
    void add(ScenicSpot scenicSpot);
    // 分页查询
    Page<ScenicSpot> page(SsPageDTO pageDTO);
    //根据id查询景点信息
    @Select("select * from dayang_tourism.scenic_spots where scenic_id = #{id}")
    ScenicSpot getById(Integer id);
    // 修改景点信息
    void update(ScenicSpot scenicSpot);
    // 删除景点
    @Delete("delete from dayang_tourism.scenic_spots where scenic_id = #{id}")
    void delete(Integer id);
}
