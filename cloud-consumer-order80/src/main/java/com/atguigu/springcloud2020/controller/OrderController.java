package com.atguigu.springcloud2020.controller;

import com.atguigu.springcloud2020.entities.CommonResult;
import com.atguigu.springcloud2020.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
    //单机版写死是没有问题的，但是现在有8001、8002了，所有不应该再关注具体的IP和端口，而是只认服务名称
    //private static final String PAYMENT_URL="http://localhost:8001";  单机版
    private static final String PAYMENT_URL="http://CLOUD-PROVIDER-SERVICE";  //集群版   地址为提供者服务名称
    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    /**
     * getForObject 返回的是json串，推荐用这个
     * getForEntity 返回的是对象 包含header body等内容
     * @param id
     * @return
     */

    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (forEntity.getStatusCode().is2xxSuccessful()){
            log.info("aaaaaaaaaaaaaaaaaaaaaa",forEntity.getHeaders().toString());
            return forEntity.getBody();

        }else{
            return new CommonResult(444,"操作失败："+id,null);
        }
    }
}