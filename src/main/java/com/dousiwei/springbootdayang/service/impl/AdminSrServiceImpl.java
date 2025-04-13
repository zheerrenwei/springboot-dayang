package com.dousiwei.springbootdayang.service.impl;


import com.dousiwei.springbootdayang.mapper.AdminSrMapper;
import com.dousiwei.springbootdayang.pojo.dto.SrPageDTO;
import com.dousiwei.springbootdayang.pojo.eneity.ScenicReview;
import com.dousiwei.springbootdayang.pojo.vo.SrPageVO;
import com.dousiwei.springbootdayang.result.PageResult;
import com.dousiwei.springbootdayang.service.AdminSrService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminSrServiceImpl implements AdminSrService {

    @Autowired
    private AdminSrMapper adminSrMapper;
    // 分页查询
    @Override
    public PageResult page(SrPageDTO srPageDTO) {
        PageHelper.startPage(srPageDTO.getPage(),srPageDTO.getPagesize());
        Page<SrPageVO> page=adminSrMapper.page(srPageDTO);
        return new PageResult(page.getTotal(),page.getResult());
    }

    // 删除评论

    @Override
    public void deleteById(Integer id) {
        adminSrMapper.deleteById(id);
    }
}
