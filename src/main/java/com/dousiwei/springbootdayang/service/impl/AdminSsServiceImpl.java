package com.dousiwei.springbootdayang.service.impl;

import com.dousiwei.springbootdayang.mapper.AdminSrMapper;
import com.dousiwei.springbootdayang.mapper.AdminSsMapper;
import com.dousiwei.springbootdayang.pojo.dto.PageDTO;
import com.dousiwei.springbootdayang.pojo.dto.SsDTO;
import com.dousiwei.springbootdayang.pojo.dto.SsPageDTO;
import com.dousiwei.springbootdayang.pojo.dto.SsUpdateDTO;
import com.dousiwei.springbootdayang.pojo.eneity.ScenicSpot;
import com.dousiwei.springbootdayang.result.PageResult;
import com.dousiwei.springbootdayang.service.AdminSsService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AdminSsServiceImpl implements AdminSsService {
    @Autowired
    private AdminSsMapper adminSsMapper;
    @Autowired
    private AdminSrMapper adminSrMapper;
    // 新增景点
    @Override
    public void add(SsDTO ssDTO) {
        ScenicSpot scenicSpot = new ScenicSpot();
        BeanUtils.copyProperties(ssDTO,scenicSpot);
        scenicSpot.setCreatedTime(LocalDateTime.now());
        scenicSpot.setUpdatedTime(LocalDateTime.now());
        adminSsMapper.add(scenicSpot);
    }
    // 分页查询

    @Override
    public PageResult page(SsPageDTO pageDTO) {
        PageHelper.startPage(pageDTO.getPage(),pageDTO.getPagesize());
        Page<ScenicSpot> page=adminSsMapper.page(pageDTO);
        return new PageResult(page.getTotal(),page.getResult());
    }
    // 根据id查询景点信息

    @Override
    public ScenicSpot getById(Integer id) {
        ScenicSpot scenicSpot = adminSsMapper.getById(id);
        return scenicSpot;
    }
    // 修改景点信息

    @Override
    public void update(SsUpdateDTO ssUpdateDTO) {
        ScenicSpot scenicSpot = new ScenicSpot();
        BeanUtils.copyProperties(ssUpdateDTO,scenicSpot);
        scenicSpot.setUpdatedTime(LocalDateTime.now());
        adminSsMapper.update(scenicSpot);
    }
    // 删除景点信息
    public void delete(Integer id) {
        // 删除景点信息
        adminSsMapper.delete(id);
        // 删除景点评论信息
        adminSrMapper.deleteReview(id);
    }
}
