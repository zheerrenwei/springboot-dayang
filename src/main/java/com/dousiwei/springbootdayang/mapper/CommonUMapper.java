package com.dousiwei.springbootdayang.mapper;


import com.dousiwei.springbootdayang.pojo.dto.HotelAddDTO;
import com.dousiwei.springbootdayang.pojo.eneity.HotelReservation;
import com.dousiwei.springbootdayang.pojo.eneity.ScenicReview;
import com.dousiwei.springbootdayang.pojo.eneity.TicketReservation;
import com.dousiwei.springbootdayang.pojo.vo.UserHoVO;
import com.dousiwei.springbootdayang.pojo.vo.UserTkVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommonUMapper {
    //添加留言
    void scenic_reviews(ScenicReview scenicReview);
    //添加酒店预约
    void addHotel(HotelReservation hotelReservation);
    //添加门票预约
    void addTicket(TicketReservation ticketReservation);
    //查询酒店预约
    List<UserHoVO> getHotel(int userId);
    //查询门票预约
    List<UserTkVO> getTicket(int userId);
}
