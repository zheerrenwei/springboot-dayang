package com.dousiwei.springbootdayang.service.impl;

import com.dousiwei.springbootdayang.mapper.AdminTrMapper;
import com.dousiwei.springbootdayang.pojo.dto.HrPageDto;
import com.dousiwei.springbootdayang.pojo.dto.TrPageDTO;
import com.dousiwei.springbootdayang.pojo.eneity.TicketReservation;
import com.dousiwei.springbootdayang.pojo.vo.TrPageVO;
import com.dousiwei.springbootdayang.result.PageResult;
import com.dousiwei.springbootdayang.service.AdminTrService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AdminTrServiceImpl implements AdminTrService {
    @Autowired
    private AdminTrMapper adminTrMapper;
    // 分页查询
    @Override
    public PageResult page(TrPageDTO trPageDTO) {
        PageHelper.startPage(trPageDTO.getPage(),trPageDTO.getPagesize());
        Page<TrPageVO> page=adminTrMapper.page(trPageDTO);
        log.info("PageHelper 是否可用: {}", PageHelper.getLocalPage());
        System.out.println(page);
        return new PageResult(page.getTotal(), page.getResult());
    }

    // 完成预约

    @Override
    public void bookOrFinish(Integer id) {
        adminTrMapper.bookOrFinish(id);
    }

    // 删除预约

    @Override
    public void deleteByReId(Integer id) {
        adminTrMapper.deleteByReId(id);
    }
}
