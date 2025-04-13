package com.dousiwei.springbootdayang.mapper;


import com.dousiwei.springbootdayang.pojo.dto.HrPageDto;
import com.dousiwei.springbootdayang.pojo.dto.TrPageDTO;
import com.dousiwei.springbootdayang.pojo.eneity.TicketReservation;
import com.dousiwei.springbootdayang.pojo.vo.TrPageVO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface AdminTrMapper {
    //分页查询
    Page<TrPageVO> page(TrPageDTO trPageDTO);
    //完成预约
    @Update("update dayang_tourism.ticket_reservations set status = '已完成' where reservation_id = #{id}")
    void bookOrFinish(Integer id);
    //删除预约
    @Update("delete from dayang_tourism.ticket_reservations where reservation_id = #{id}")
    void deleteByReId(Integer id);
    //根据用户id删除预约
    @Delete("delete from dayang_tourism.ticket_reservations where user_id = #{id}")
    void deleteByUserId(Integer id);
    //根据门票id删除预约
    @Delete("delete from dayang_tourism.ticket_reservations where ticket_id = #{id}")
    void deleteTkId(Integer id);
}
