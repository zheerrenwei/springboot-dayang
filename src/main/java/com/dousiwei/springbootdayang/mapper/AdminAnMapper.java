package com.dousiwei.springbootdayang.mapper;

import com.dousiwei.springbootdayang.pojo.dto.PageDTO;
import com.dousiwei.springbootdayang.pojo.eneity.Announcement;
import com.dousiwei.springbootdayang.pojo.vo.AnPageVO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Mapper
public interface AdminAnMapper {
    // 添加公告
    @Insert("insert into dayang_tourism.announcements(title,content,published_time,admin_id) values(#{title},#{content},#{publishedTime},#{adminId})")
    void add(Announcement announcement);
    // 分页查询
    Page<AnPageVO> page(PageDTO pageDTO);
    // 删除公告
    @Delete("delete from dayang_tourism.announcements where announcement_id = #{id}")
    void deleteById(Integer id);
    // 根据id查询公告信息
    @Select("select * from dayang_tourism.announcements where announcement_id = #{id}")
    Announcement getById(Integer id);
    // 修改公告
    void update(Announcement announcement);
    // 根据管理员id查询公告信息
    @Delete("delete from dayang_tourism.announcements where admin_id = #{id}")
    void deleteByAdminId(Integer id);
}
