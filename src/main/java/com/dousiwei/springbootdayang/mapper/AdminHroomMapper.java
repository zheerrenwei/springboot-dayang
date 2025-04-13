package com.dousiwei.springbootdayang.mapper;

import com.dousiwei.springbootdayang.pojo.dto.HroomPageDto;
import com.dousiwei.springbootdayang.pojo.eneity.HotelRoom;
import com.dousiwei.springbootdayang.pojo.vo.HroomPageVO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Mapper
public interface AdminHroomMapper {
    // 新增酒店房型
    void add(HotelRoom hotelRoom);
    // 分页查询
    Page<HroomPageVO> page(HroomPageDto hroomPageDto);
    // 根据id查询酒店房型信息
    HroomPageVO getById(Integer id);
    // 修改酒店房型信息
    void update(HotelRoom hotelRoom);
    // 删除酒店房型
    @Delete("delete from dayang_tourism.hotel_rooms where room_id = #{id}")
    void delete(Integer id);
    //根据酒店id删除酒店房型
    @Delete("delete from dayang_tourism.hotel_rooms where hotel_id = #{id}")
    void deleteByHoId(Integer id);
}
