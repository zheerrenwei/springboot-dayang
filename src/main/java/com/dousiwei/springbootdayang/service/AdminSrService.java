package com.dousiwei.springbootdayang.service;

import com.dousiwei.springbootdayang.pojo.dto.SrPageDTO;
import com.dousiwei.springbootdayang.result.PageResult;

public interface AdminSrService {
    // 分页查询
    PageResult page(SrPageDTO srPageDTO);
    // 删除评论
    void deleteById(Integer id);
}
