package com.dousiwei.springbootdayang.service;

import com.dousiwei.springbootdayang.pojo.dto.HrPageDto;
import com.dousiwei.springbootdayang.result.PageResult;

public interface AdminHrService {
    // 分页查询
    PageResult page(HrPageDto hrPageDto);
    // 完成预约
    void bookOrFinish(Integer id);
    // 删除预约
    void deleteByReId(Integer id);
}
