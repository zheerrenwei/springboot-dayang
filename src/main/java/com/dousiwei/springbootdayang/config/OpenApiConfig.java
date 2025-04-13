package com.dousiwei.springbootdayang.config;


import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

//knife4j整合swgger相关配置
@Configuration
public class OpenApiConfig {

    @Bean
    public GroupedOpenApi defaultApi() {
        return GroupedOpenApi.builder()
                .group("default")
                .packagesToScan("com.dousiwei.springbootdayang") // 替换为您的包名
                .build();
    }

    @Bean
    public OpenApiCustomizer customOpenApiCustomizer() {
        return openApi -> openApi.info(new Info()
                .title("API 文档")
                .description("API 文档描述")
                .version("1.0.0")
                .contact(new Contact().name("API Team").email("api-team@example.com")));
    }
}
