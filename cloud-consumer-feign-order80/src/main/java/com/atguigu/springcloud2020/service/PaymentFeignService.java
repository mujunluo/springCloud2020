package com.atguigu.springcloud2020.service;

import com.atguigu.springcloud2020.entities.CommonResult;
import com.atguigu.springcloud2020.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Component
@FeignClient(value = "CLOUD-PROVIDER-SERVICE") //指定提供者注册的服务名
public interface PaymentFeignService {
    @GetMapping(value = "/payment/get/{id}")//提供者controller中接口请求地址
    CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/timeOut")
    String timeOut();
}
