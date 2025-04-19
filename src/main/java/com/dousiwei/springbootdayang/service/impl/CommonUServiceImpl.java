package com.dousiwei.springbootdayang.service.impl;

import com.dousiwei.springbootdayang.mapper.CommonUMapper;
import com.dousiwei.springbootdayang.pojo.dto.HotelAddDTO;
import com.dousiwei.springbootdayang.pojo.dto.ScenicReviewDTO;
import com.dousiwei.springbootdayang.pojo.dto.TicketAddDTO;
import com.dousiwei.springbootdayang.pojo.eneity.HotelReservation;
import com.dousiwei.springbootdayang.pojo.eneity.ScenicReview;
import com.dousiwei.springbootdayang.pojo.eneity.TicketReservation;
import com.dousiwei.springbootdayang.pojo.vo.UserHoVO;
import com.dousiwei.springbootdayang.pojo.vo.UserTkVO;
import com.dousiwei.springbootdayang.service.AdminSsService;
import com.dousiwei.springbootdayang.service.CommonUService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommonUServiceImpl implements CommonUService {
    @Autowired
    private CommonUMapper commonUMapper;
    //留言功能
    @Override
    public void scenic_reviews(ScenicReviewDTO scenicReviewDTO) {
        ScenicReview scenicReview = new ScenicReview();

        BeanUtils.copyProperties(scenicReviewDTO,scenicReview);

        scenicReview.setReviewDate(LocalDateTime.now().now());

        commonUMapper.scenic_reviews(scenicReview);
    }
    //酒店预约
    @Override
    public void addHotel(HotelAddDTO hotelAddDTO) {
        HotelReservation hotelReservation = new HotelReservation();

        BeanUtils.copyProperties(hotelAddDTO,hotelReservation);
        //默认预约
        hotelReservation.setStatus("booked");
        //添加创建时
        hotelReservation.setCreateTime(LocalDateTime.now());

        commonUMapper.addHotel(hotelReservation);
    }
    //门票预约

    @Override
    public void addTicket(TicketAddDTO ticketAddDTO) {
        TicketReservation ticketReservation = new TicketReservation();

        BeanUtils.copyProperties(ticketAddDTO,ticketReservation);
        //默认预约
        ticketReservation.setStatus("booked");
        //添加创建时
        ticketReservation.setCreateTime(LocalDateTime.now());

        commonUMapper.addTicket(ticketReservation);
    }
    //酒店预约查看
    @Override
    public List<UserHoVO> getHotel(Integer userId) {
        HotelReservation hotelReservation = HotelReservation.builder()
                .userId(userId)
                .build();
        return commonUMapper.getHotel(userId);
    }
    //门票预约查看
    @Override
    public List<UserTkVO> getTicket(Integer userId) {
        TicketReservation ticketReservation = TicketReservation.builder()
                .userId(userId)
                .build();
        return commonUMapper.getTicket(userId);
    }
}
