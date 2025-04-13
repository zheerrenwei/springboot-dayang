package com.dousiwei.springbootdayang.service;


import com.dousiwei.springbootdayang.pojo.dto.HotelAddDTO;
import com.dousiwei.springbootdayang.pojo.dto.ScenicReviewDTO;
import com.dousiwei.springbootdayang.pojo.dto.TicketAddDTO;
import com.dousiwei.springbootdayang.pojo.eneity.HotelReservation;
import com.dousiwei.springbootdayang.pojo.eneity.TicketReservation;
import com.dousiwei.springbootdayang.pojo.vo.UserHoVO;
import com.dousiwei.springbootdayang.pojo.vo.UserTkVO;

import java.util.List;

public interface CommonUService {
    //留言功能
    void scenic_reviews(ScenicReviewDTO scenicReviewDTO);
    //酒店预约
    void addHotel(HotelAddDTO hotelAddDTO);
    //门票预订
    void addTicket(TicketAddDTO ticketAddDTO);
    //酒店预约查询功能
    List<UserHoVO> getHotel(Integer userId);
    //门票预订查询功能
    List<UserTkVO> getTicket(Integer userId);
}
