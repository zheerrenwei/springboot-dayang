package com.dousiwei.springbootdayang.service.impl;

import com.dousiwei.springbootdayang.mapper.AdminHoMapper;
import com.dousiwei.springbootdayang.mapper.AdminHrMapper;
import com.dousiwei.springbootdayang.mapper.AdminHroomMapper;
import com.dousiwei.springbootdayang.pojo.dto.HroomDTO;
import com.dousiwei.springbootdayang.pojo.dto.HroomPageDto;
import com.dousiwei.springbootdayang.pojo.eneity.HotelRoom;
import com.dousiwei.springbootdayang.pojo.vo.HroomPageVO;
import com.dousiwei.springbootdayang.result.PageResult;
import com.dousiwei.springbootdayang.service.AdminHroomService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminHroomServiceImpl implements AdminHroomService {
    @Autowired
    private AdminHroomMapper adminHroomMapper;
    @Autowired
    private AdminHrMapper adminHrMapper;
    @Autowired
    private AdminHoMapper adminHoMapper;
    //新增
    @Override
    public void add(HroomDTO hroomDTO) {
        int hotelId = adminHoMapper.getIdByName(hroomDTO.getName());
        HotelRoom hotelRoom = new HotelRoom();
        BeanUtils.copyProperties(hroomDTO,hotelRoom);
        hotelRoom.setHotelId(hotelId);
        adminHroomMapper.add(hotelRoom);
    }
    //分页查询

    @Override
    public PageResult page(HroomPageDto hroomPageDto) {
        PageHelper.startPage(hroomPageDto.getPage(),hroomPageDto.getPagesize());
        Page<HroomPageVO> page=adminHroomMapper.page(hroomPageDto);
        return new PageResult(page.getTotal(),page.getResult());
    }

    //根据id查询

    @Override
    public HroomPageVO getById(Integer id) {
        HroomPageVO hotelRoom = adminHroomMapper.getById(id);
        return hotelRoom;
    }

    //修改

    @Override
    public void update(HroomPageVO hotelRoom) {
        int hotelId = adminHoMapper.getIdByName(hotelRoom.getName());
        HotelRoom hroom = new HotelRoom();
        BeanUtils.copyProperties(hotelRoom,hroom);
        hroom.setHotelId(hotelId);
        adminHroomMapper.update(hroom);
    }

    //删除

    @Override
    public void delete(Integer id) {

        adminHroomMapper.delete(id);
        adminHrMapper.deleteByRoomId(id);

    }
}
