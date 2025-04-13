package com.dousiwei.springbootdayang.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;

@Data

public class TrPageDTO implements Serializable {

    private String ticketName;

    private int page;

    private int pagesize;
}
