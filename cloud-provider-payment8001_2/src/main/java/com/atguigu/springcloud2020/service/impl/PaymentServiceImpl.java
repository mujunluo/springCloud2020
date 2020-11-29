package com.atguigu.springcloud2020.service.impl;

import com.atguigu.springcloud2020.dao.PaymentDao;
import com.atguigu.springcloud2020.entities.Payment;
import com.atguigu.springcloud2020.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment){
        return 1;
    }
    public Payment getPaymentById(Long id){
        Payment payment = new Payment();
        payment.setId(1l);
        payment.setSerial("11111111111111111");
        return payment;
    }
}
