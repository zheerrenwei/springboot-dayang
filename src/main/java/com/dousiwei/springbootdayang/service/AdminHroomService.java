package com.dousiwei.springbootdayang.service;

import com.dousiwei.springbootdayang.pojo.dto.HroomDTO;
import com.dousiwei.springbootdayang.pojo.dto.HroomPageDto;
import com.dousiwei.springbootdayang.pojo.eneity.HotelRoom;
import com.dousiwei.springbootdayang.pojo.vo.HroomPageVO;
import com.dousiwei.springbootdayang.result.PageResult;

public interface AdminHroomService {
    // 添加
    void add(HroomDTO hroomDTO);
    // 分页查询
    PageResult page(HroomPageDto hroomPageDto);
    // 根据id查询
    HroomPageVO getById(Integer id);
    // 修改
    void update(HroomPageVO hotelRoom);
    // 删除
    void delete(Integer id);
}
