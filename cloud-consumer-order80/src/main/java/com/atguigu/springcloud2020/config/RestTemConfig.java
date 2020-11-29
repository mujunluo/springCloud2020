package com.atguigu.springcloud2020.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemConfig {
    @Bean
    @LoadBalanced  // 现在对外暴露的不再是地址和端口，只认微服务名称了，可是微服务并不知道下面有几个，找不到这个主机名称，需要使用#LoadBalanced注解开启RestTemplate负载均衡功能。
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
