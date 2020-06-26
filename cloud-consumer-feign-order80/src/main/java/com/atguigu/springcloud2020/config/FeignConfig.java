package com.atguigu.springcloud2020.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//OpenFeign日志增强
//openfeign提供了日志打印功能。
//Logger有四种类型：NONE(默认)、BASIC、HEADERS、FULL，通过注册Bean来设置日志记录级别
@Configuration
public class FeignConfig {
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
