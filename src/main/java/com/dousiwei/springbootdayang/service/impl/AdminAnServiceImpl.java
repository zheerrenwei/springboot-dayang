package com.dousiwei.springbootdayang.service.impl;


import com.dousiwei.springbootdayang.mapper.AdminAnMapper;
import com.dousiwei.springbootdayang.pojo.dto.AnnoDTO;
import com.dousiwei.springbootdayang.pojo.dto.AnnoUpdateDTO;
import com.dousiwei.springbootdayang.pojo.dto.PageDTO;
import com.dousiwei.springbootdayang.pojo.eneity.Announcement;
import com.dousiwei.springbootdayang.pojo.vo.AnPageVO;
import com.dousiwei.springbootdayang.result.PageResult;
import com.dousiwei.springbootdayang.service.AdminAnService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AdminAnServiceImpl implements AdminAnService {
    @Autowired
    private AdminAnMapper adminAnMapper;
    // 添加公告
    @Override
    public void add(AnnoDTO annoDTO) {
        Announcement announcement = new Announcement();
        BeanUtils.copyProperties(annoDTO,announcement);
        announcement.setPublishedTime(LocalDateTime.now());
        adminAnMapper.add(announcement);
    }

    // 分页公告

    @Override
    public PageResult page(PageDTO pageDTO) {
        PageHelper.startPage(pageDTO.getPage(),pageDTO.getPagesize());
        Page<AnPageVO> page=adminAnMapper.page(pageDTO);
        return new PageResult(page.getTotal(),page.getResult());
    }

    // 删除公告


    @Override
    public void deleteById(Integer id) {
        adminAnMapper.deleteById(id);
    }

    // 根据id查询公告信息

    @Override
    public Announcement getById(Integer id) {
        Announcement announcement = adminAnMapper.getById(id);
        return announcement;
    }

    // 修改公告

    @Override
    public void update(AnnoUpdateDTO annoUpdateDTO) {
        Announcement announcement = new Announcement();
        BeanUtils.copyProperties(annoUpdateDTO,announcement);
        adminAnMapper.update(announcement);
    }
}
