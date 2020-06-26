package com.atguigu.springcloud2020.controller;

import com.atguigu.springcloud2020.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String payment_Ok(@PathVariable Integer id){
        String result = paymentService.paymentok(id);
        log.info("****result:"+result);
       return result;
    }
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String timeout(@PathVariable Integer id){
        String result = paymentService.paymentTimeOut(id);
        log.info("****result:"+result);
        return result;
    }
}
