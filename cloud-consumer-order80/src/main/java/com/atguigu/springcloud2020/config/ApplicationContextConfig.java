package com.atguigu.springcloud2020.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {
    // 默认轮询
    @LoadBalanced   //开启RestTemplate负载均衡，必须加这个注解，提供者同一个服务名下可能有好多机器，不加这个注解，消费者不知道去找那台机器
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
