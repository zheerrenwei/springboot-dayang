package com.dousiwei.springbootdayang.service;

import com.dousiwei.springbootdayang.pojo.dto.HoDTO;
import com.dousiwei.springbootdayang.pojo.dto.HoUpdateDTO;
import com.dousiwei.springbootdayang.pojo.dto.PageDTO;
import com.dousiwei.springbootdayang.pojo.dto.SsPageDTO;
import com.dousiwei.springbootdayang.pojo.eneity.Hotel;
import com.dousiwei.springbootdayang.result.PageResult;

public interface AdminHoService {
    // 添加酒店信息
    void add(HoDTO hoDTO);
    // 分页查询酒店信息
    PageResult page(SsPageDTO pageDTO);
    // 根据id查询酒店信息
    Hotel getById(Integer id);
    // 修改酒店信息
    void update(HoUpdateDTO updateDTO);
    // 删除酒店信息
    void delete(Integer id);
}
