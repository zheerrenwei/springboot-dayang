package com.dousiwei.springbootdayang.controller;



import com.dousiwei.springbootdayang.pojo.dto.HroomDTO;
import com.dousiwei.springbootdayang.pojo.dto.HroomPageDto;
import com.dousiwei.springbootdayang.pojo.eneity.HotelRoom;
import com.dousiwei.springbootdayang.pojo.vo.HroomPageVO;
import com.dousiwei.springbootdayang.result.PageResult;
import com.dousiwei.springbootdayang.result.Result;
import com.dousiwei.springbootdayang.service.AdminHroomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/rooms")
@Slf4j
@Tag(name = "3酒店房间管理相关接口")
public class AdminHroomController {
    @Autowired
    private AdminHroomService adminHroomService;
    //添加酒店房型
    @PostMapping
    @Operation(summary = "新增酒店房型")
    public Result add(@RequestBody HroomDTO hroomDTO){
        log.info("新增酒店房型：{}", hroomDTO);
        adminHroomService.add(hroomDTO);
        return Result.success();
    }
    //房间分页查询
    @GetMapping("/page")
    @Operation(summary = "分页查询")
    public Result<PageResult> page(@ParameterObject HroomPageDto hroomPageDto){
        log.info("分页查询数据为",hroomPageDto);
        PageResult pageResult = adminHroomService.page(hroomPageDto);
        return Result.success(pageResult);
    }

    //根据id查询酒店房型信息
    @GetMapping("/{id}")
    @Operation(summary = "根据id查询酒店房型信息")
    public Result<HroomPageVO> getById(@PathVariable Integer id){
        log.info("根据id查询酒店房型信息：{}",id);
        HroomPageVO hotelRoom = adminHroomService.getById(id);
        return Result.success(hotelRoom);
    }

    //修改酒店房型信息
    @PutMapping("/update")
    @Operation(summary = "修改酒店房型信息")
    public Result update(@RequestBody HroomPageVO hotelRoom){
        log.info("修改酒店房型信息：{}",hotelRoom);
        adminHroomService.update(hotelRoom);
        return Result.success();
    }

    //删除酒店房型信息
    @DeleteMapping("/{id}")
    @Operation(summary = "删除酒店房型信息")
    public Result delete(@PathVariable Integer id){
        log.info("删除酒店房型信息：{}",id);
        adminHroomService.delete(id);
        return Result.success();
    }
}
