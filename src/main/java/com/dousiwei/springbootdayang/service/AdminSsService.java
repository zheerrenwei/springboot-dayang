package com.dousiwei.springbootdayang.service;

import com.dousiwei.springbootdayang.pojo.dto.PageDTO;
import com.dousiwei.springbootdayang.pojo.dto.SsDTO;
import com.dousiwei.springbootdayang.pojo.dto.SsPageDTO;
import com.dousiwei.springbootdayang.pojo.dto.SsUpdateDTO;
import com.dousiwei.springbootdayang.pojo.eneity.ScenicSpot;
import com.dousiwei.springbootdayang.result.PageResult;

public interface AdminSsService {
    // 新增景点
    void add(SsDTO ssDTO);
    // 分页查询
    PageResult page(SsPageDTO pageDTO);
    //根据id查询景点信息
    ScenicSpot getById(Integer id);
    // 修改景点信息
    void update(SsUpdateDTO ssUpdateDTO);
    // 删除景点
    void delete(Integer id);
}
