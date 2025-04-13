package com.dousiwei.springbootdayang.service.impl;

import com.dousiwei.springbootdayang.mapper.AdminHrMapper;
import com.dousiwei.springbootdayang.pojo.dto.HrPageDto;
import com.dousiwei.springbootdayang.pojo.eneity.HotelReservation;
import com.dousiwei.springbootdayang.pojo.vo.HrPageVO;
import com.dousiwei.springbootdayang.result.PageResult;
import com.dousiwei.springbootdayang.service.AdminHrService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminHrServiceImpl implements AdminHrService {
    @Autowired
    private AdminHrMapper adminHrMapper;
    // 分页查询

    @Override
    public PageResult page(HrPageDto hrPageDto) {
        PageHelper.startPage(hrPageDto.getPage(),hrPageDto.getPagesize());
        Page<HrPageVO> page=adminHrMapper.page(hrPageDto);
        return new PageResult(page.getTotal(),page.getResult());
    }

    //完成预约
    @Override
    public void bookOrFinish(Integer id) {
        adminHrMapper.update(id);
    }

    // 删除预约
    @Override
    public void deleteByReId(Integer id) {
        adminHrMapper.deleteByReId(id);
    }
}
