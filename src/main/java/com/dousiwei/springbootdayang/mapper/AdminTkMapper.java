package com.dousiwei.springbootdayang.mapper;


import com.dousiwei.springbootdayang.pojo.dto.PageDTO;
import com.dousiwei.springbootdayang.pojo.eneity.Ticket;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminTkMapper {
    // 添加门票
    void add(Ticket ticket);
    //分页查询
    Page<Ticket> page(PageDTO pageDTO);
    //根据id查询门票信息
    @Select("select * from dayang_tourism.tickets where ticket_id = #{id}")
    Ticket getById(Integer id);
    //更新门票信息
    void update(Ticket ticket);
    //删除门票
    @Delete("delete from dayang_tourism.tickets where ticket_id = #{id}")
    void delete(Integer id);
}
