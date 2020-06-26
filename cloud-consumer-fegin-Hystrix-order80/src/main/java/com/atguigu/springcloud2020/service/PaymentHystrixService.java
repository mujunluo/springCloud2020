package com.atguigu.springcloud2020.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-SERVICE") //指定提供者注册的服务名
public interface PaymentHystrixService {
    @GetMapping("/payment/hystrix/ok/{id}")
    public String payment_Ok(@PathVariable(value="id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String timeout(@PathVariable(value="id") Integer id);
}
