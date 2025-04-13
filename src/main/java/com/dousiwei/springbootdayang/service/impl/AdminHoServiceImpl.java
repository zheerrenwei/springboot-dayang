package com.dousiwei.springbootdayang.service.impl;

import com.dousiwei.springbootdayang.mapper.AdminHoMapper;
import com.dousiwei.springbootdayang.mapper.AdminHrMapper;
import com.dousiwei.springbootdayang.mapper.AdminHroomMapper;
import com.dousiwei.springbootdayang.pojo.dto.HoDTO;
import com.dousiwei.springbootdayang.pojo.dto.HoUpdateDTO;
import com.dousiwei.springbootdayang.pojo.dto.PageDTO;
import com.dousiwei.springbootdayang.pojo.dto.SsPageDTO;
import com.dousiwei.springbootdayang.pojo.eneity.Hotel;
import com.dousiwei.springbootdayang.result.PageResult;
import com.dousiwei.springbootdayang.service.AdminHoService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AdminHoServiceImpl implements AdminHoService {
    @Autowired
    private AdminHoMapper adminHoMapper;
    @Autowired
    private AdminHrMapper adminHrMapper;
    @Autowired
    private AdminHroomMapper adminHroomMapper;
    // 添加酒店
    @Override
    public void add(HoDTO hoDTO) {
        Hotel hotel = new Hotel();
        BeanUtils.copyProperties(hoDTO,hotel);
        hotel.setCreatedTime(LocalDateTime.now());
        hotel.setUpdatedTime(LocalDateTime.now());
        adminHoMapper.add(hotel);
    }
    // 分页查询

    @Override
    public PageResult page(SsPageDTO pageDTO) {
        PageHelper.startPage(pageDTO.getPage(),pageDTO.getPagesize());
        Page<Hotel> page=adminHoMapper.page(pageDTO);
        return new PageResult(page.getTotal(),page.getResult());
    }

    // 根据id查询酒店信息

    @Override
    public Hotel getById(Integer id) {
        Hotel hotel = adminHoMapper.getById(id);
        return hotel;
    }

    // 修改酒店信息

    @Override
    public void update(HoUpdateDTO updateDTO) {
        Hotel hotel = new Hotel();
        BeanUtils.copyProperties(updateDTO,hotel);
        hotel.setUpdatedTime(LocalDateTime.now());
        adminHoMapper.update(hotel);
    }

    // 删除酒店

    @Override
    public void delete(Integer id) {
        //删除酒店信息
        adminHoMapper.delete(id);
        //删除酒店预约信息
        adminHrMapper.delete(id);

        adminHroomMapper.deleteByHoId(id);
    }
}
