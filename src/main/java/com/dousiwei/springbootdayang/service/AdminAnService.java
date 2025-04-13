package com.dousiwei.springbootdayang.service;

import com.dousiwei.springbootdayang.pojo.dto.AnnoDTO;
import com.dousiwei.springbootdayang.pojo.dto.AnnoUpdateDTO;
import com.dousiwei.springbootdayang.pojo.dto.PageDTO;
import com.dousiwei.springbootdayang.pojo.eneity.Announcement;
import com.dousiwei.springbootdayang.result.PageResult;

public interface AdminAnService {
    // 添加公告
    void add(AnnoDTO annoDTO);
    // 分页查询
    PageResult page(PageDTO pageDTO);
    // 删除公告
    void deleteById(Integer id);
    // 根据id查询公告信息
    Announcement getById(Integer id);
    // 修改公告
    void update(AnnoUpdateDTO annoUpdateDTO);
}
