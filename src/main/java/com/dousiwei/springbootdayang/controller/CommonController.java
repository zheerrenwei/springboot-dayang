package com.dousiwei.springbootdayang.controller;

import com.dousiwei.springbootdayang.pojo.dto.HroomPageDto;
import com.dousiwei.springbootdayang.pojo.dto.PageDTO;
import com.dousiwei.springbootdayang.pojo.dto.SrPageDTO;
import com.dousiwei.springbootdayang.pojo.dto.SsPageDTO;
import com.dousiwei.springbootdayang.result.PageResult;
import com.dousiwei.springbootdayang.result.Result;
import com.dousiwei.springbootdayang.service.*;
import com.dousiwei.springbootdayang.utils.AliOSSUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/common")
@Slf4j
@Tag(name = "通用接口")
public class CommonController {
    @Autowired
    private AliOSSUtils aliOssUtils;
    @Autowired
    private AdminSsService adminSsService;
    @Autowired
    private AdminTkService adminTkService;
    @Autowired
    private AdminAnService adminAnService;
    @Autowired
    private AdminHoService adminHoService;
    @Autowired
    private AdminHroomService adminHroomService;
    @Autowired
    private AdminSrService adminSrService;

    @PostMapping ("/upload")
    @Operation(summary = "上传图片")
    public Result<String> upload(MultipartFile file) {
        log.info("开始上传图片：{}",file);

        try {
            //原始文件名
            String originalFilename = file.getOriginalFilename();
            //截取原始文件名的后缀   dfdfdf.png
            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            //构造新文件名称
            String objectName = UUID.randomUUID().toString() + extension;
            log.info("新文件名称：{}",objectName);
            //文件的请求路径
            String filePath = aliOssUtils.upload(file.getBytes(), objectName);
            return Result.success(filePath);
        } catch (IOException e) {
            log.error("文件上传失败：{}", e);
        }

        return Result.error("文件上传失败");
    }

    //景点分页查询
    @GetMapping ("/scenic/page")
    @Operation(summary = "景点分页查询")
    public Result<PageResult> page(@ParameterObject SsPageDTO pageDTO){
        log.info("分页查询数据为",pageDTO);
        PageResult pageResult = adminSsService.page(pageDTO);
        return Result.success(pageResult);
    }

    //门票分页查询
    @GetMapping("/ticket/page")
    @Operation(summary = "分页查询门票")
    public Result<PageResult> page(@ParameterObject PageDTO pageDTO){
        log.info("分页查询门票：{}", pageDTO);
        PageResult pageResult = adminTkService.page(pageDTO);
        return Result.success(pageResult);
    }

    //公告分页查询
    @GetMapping("/announcements/page")
    @Operation(summary = "分页查询公告")
    public Result<PageResult> page1(@ParameterObject PageDTO pageDTO){
        log.info("分页查询公告：{}", pageDTO);
        PageResult pageResult= adminAnService.page(pageDTO);
        return Result.success(pageResult);
    }

    //酒店分页查询
    @GetMapping ("/hotel/page")
    @Operation(summary = "分页查询酒店")
    public Result<PageResult> page2(@ParameterObject SsPageDTO pageDTO){
        log.info("分页查询数据为",pageDTO);
        PageResult pageResult = adminHoService.page(pageDTO);
        return Result.success(pageResult);
    }

    //查询酒店房间
    @GetMapping("/room/page")
    @Operation(summary = "分页查询房间")
    public Result<PageResult> page(@ParameterObject HroomPageDto hroomPageDto){
        log.info("分页查询数据为",hroomPageDto);
        PageResult pageResult = adminHroomService.page(hroomPageDto);
        return Result.success(pageResult);
    }

    //分页查询留言
    @GetMapping("/review/page")
    @Operation(summary = "分页查询留言")
    public Result<PageResult> page(@ParameterObject SrPageDTO srPageDTO) {
        log.info("分页查询数据为", srPageDTO);
        PageResult pageResult = adminSrService.page(srPageDTO);
        return Result.success(pageResult);
    }
}
