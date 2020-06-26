package com.atguigu.springcloud2020.service;

import com.atguigu.springcloud2020.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
