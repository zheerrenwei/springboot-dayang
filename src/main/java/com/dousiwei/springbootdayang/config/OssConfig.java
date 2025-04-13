package com.dousiwei.springbootdayang.config;

import com.dousiwei.springbootdayang.properties.AliOssProperties;
import com.dousiwei.springbootdayang.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类，用于创建AliOssUtil对象
 */
@Configuration
@Slf4j
public class OssConfig {

    @Bean
    @ConditionalOnMissingBean
    public AliOSSUtils aliOSSUtils(AliOssProperties aliOssProperties) {
        log.info("开始创建阿里云文件上传工具类对象：{}",aliOssProperties);
        return new AliOSSUtils(aliOssProperties.getEndpoint(),
                aliOssProperties.getAccessKeyId(),
                aliOssProperties.getAccessKeySecret(),
                aliOssProperties.getBucketName());
    }
}
