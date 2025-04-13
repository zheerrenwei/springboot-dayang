package com.dousiwei.springbootdayang.service;

import com.dousiwei.springbootdayang.pojo.dto.PageDTO;
import com.dousiwei.springbootdayang.pojo.dto.TicketDTO;
import com.dousiwei.springbootdayang.pojo.eneity.Ticket;
import com.dousiwei.springbootdayang.result.PageResult;

public interface AdminTkService {
    // 添加门票
    void add(TicketDTO ticketDTO);
    // 分页查询门票
    PageResult page(PageDTO pageDTO);
    // 根据id查询门票
    Ticket getById(Integer id);
    // 修改门票
    void update(Ticket ticket);
    // 删除门票
    void delete(Integer id);
}
