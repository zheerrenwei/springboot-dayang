package com.dousiwei.springbootdayang.controller;

import com.dousiwei.springbootdayang.result.Result;
import com.dousiwei.springbootdayang.utils.AliOSSUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
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
}
