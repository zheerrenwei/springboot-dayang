package com.dousiwei.springbootdayang.service.impl;

import com.dousiwei.springbootdayang.mapper.AdminTkMapper;
import com.dousiwei.springbootdayang.mapper.AdminTrMapper;
import com.dousiwei.springbootdayang.pojo.dto.PageDTO;
import com.dousiwei.springbootdayang.pojo.dto.TicketDTO;
import com.dousiwei.springbootdayang.pojo.eneity.Ticket;
import com.dousiwei.springbootdayang.result.PageResult;
import com.dousiwei.springbootdayang.service.AdminTkService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminTkServiceImpl implements AdminTkService {
    @Autowired
    private AdminTkMapper adminTkMapper;
    @Autowired
    private AdminTrMapper adminTrMapper;
    //添加门票
    public void add(TicketDTO ticketDTO) {
        Ticket ticket = new Ticket();
        BeanUtils.copyProperties(ticketDTO,ticket);
        adminTkMapper.add(ticket);
    }
    //分页查询门票
    public PageResult page(PageDTO pageDTO) {
        PageHelper.startPage(pageDTO.getPage(),pageDTO.getPagesize());
        Page<Ticket> page=adminTkMapper.page(pageDTO);
        return new PageResult(page.getTotal(),page.getResult());
    }
    //根据id查询门票信息
    public Ticket getById(Integer id) {
        Ticket ticket = adminTkMapper.getById(id);
        return ticket;
    }
    //修改门票信息
    public void update(Ticket ticket) {
        adminTkMapper.update(ticket);
    }

    //删除门票信息
    public void delete(Integer id) {

        adminTkMapper.delete(id);
        adminTrMapper.deleteTkId(id);
    }
}
