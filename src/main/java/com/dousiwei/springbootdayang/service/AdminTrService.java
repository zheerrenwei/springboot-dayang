package com.dousiwei.springbootdayang.service;

import com.dousiwei.springbootdayang.pojo.dto.HrPageDto;
import com.dousiwei.springbootdayang.pojo.dto.TrPageDTO;
import com.dousiwei.springbootdayang.result.PageResult;

public interface AdminTrService {
    // 分页查询
    PageResult page(TrPageDTO trPageDTO);
    // 完成预约
    void bookOrFinish(Integer id);
    // 删除预约
    void deleteByReId(Integer id);
}
