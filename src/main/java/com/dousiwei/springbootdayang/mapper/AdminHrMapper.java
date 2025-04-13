package com.dousiwei.springbootdayang.mapper;

import com.dousiwei.springbootdayang.pojo.dto.HrPageDto;
import com.dousiwei.springbootdayang.pojo.eneity.HotelReservation;
import com.dousiwei.springbootdayang.pojo.vo.HrPageVO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AdminHrMapper {
    //根据酒店id删除酒店预约信息
    @Delete("delete from dayang_tourism.hotel_reservations where hotel_id = #{id}")
    void delete(Integer id);
    //分页查询
    Page<HrPageVO> page(HrPageDto hrPageDto);
    //完成预约
    @Update("update dayang_tourism.hotel_reservations set status = '已完成' where reservation_id = #{id}")
    void update(Integer id);
    //根据预约id删除预约信息
    @Delete("delete from dayang_tourism.hotel_reservations where reservation_id = #{id}")
    void deleteByReId(Integer id);
    //根据用户id删除预约信息
    @Delete("delete from dayang_tourism.hotel_reservations where user_id = #{id}")
    void deleteUserId(Integer id);
    //根据酒店房间id酒店预约信息
    @Delete("delete from dayang_tourism.hotel_reservations where room_id = #{id}")
    void deleteByRoomId(Integer id);
}
