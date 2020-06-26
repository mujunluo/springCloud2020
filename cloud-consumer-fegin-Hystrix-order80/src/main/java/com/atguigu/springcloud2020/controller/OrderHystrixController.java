package com.atguigu.springcloud2020.controller;

import com.atguigu.springcloud2020.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
@RestController
@Slf4j
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String payment_Ok(@PathVariable(value="id") Integer id){
        String result = paymentHystrixService.payment_Ok(id);
        return result;
    }
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String timeout(@PathVariable(value="id") Integer id){
        String result = paymentHystrixService.timeout(id);
        return result;
    }
}
