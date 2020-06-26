package com.atguigu.springcloud2020.service.impl;

import com.atguigu.springcloud2020.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentok(Integer id) {
        return "线程池"+Thread.currentThread().getName()+"ok~~~~"+id;
    }

    @Override
    public String paymentTimeOut(Integer id) {
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "线程池"+Thread.currentThread().getName()+"timeOUT~~~~"+id+"耗时"+timeNumber;
    }
}
