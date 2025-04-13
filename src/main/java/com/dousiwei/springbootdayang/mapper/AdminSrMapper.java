package com.dousiwei.springbootdayang.mapper;

import com.dousiwei.springbootdayang.pojo.dto.SrPageDTO;
import com.dousiwei.springbootdayang.pojo.eneity.ScenicReview;
import com.dousiwei.springbootdayang.pojo.vo.SrPageVO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminSrMapper {
    //删除景点相关评论
    @Delete("delete from dayang_tourism.scenic_reviews where scenic_id = #{id}")
    void deleteReview(Integer id);
    //分页查询
    Page<SrPageVO> page(SrPageDTO srPageDTO);
    //根据id删除评论
    @Delete("delete from dayang_tourism.scenic_reviews where review_id = #{id}")
    void deleteById(Integer id);
    //根据用户id删除评论
    @Delete("delete from dayang_tourism.scenic_reviews where user_id = #{id}")
    void deleteByUserId(Integer id);
}
