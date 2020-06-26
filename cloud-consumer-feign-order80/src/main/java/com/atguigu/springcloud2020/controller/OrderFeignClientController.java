package com.atguigu.springcloud2020.controller;

import com.atguigu.springcloud2020.entities.CommonResult;
import com.atguigu.springcloud2020.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class OrderFeignClientController {
    @Autowired
    private PaymentFeignService paymentFeignService;
    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        log.info("aaa","bbbbbbbbbbbbbbb");
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/timeOut")
    public String timeOut() {
        return paymentFeignService.timeOut();
    }
}
