package com.atguigu.myRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 负载规则替换，注意，不能与主启动类在同一个包下！
 * 在启动类加上 @RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MySelfRule.class)
 *
 * 不想用代码的话 也可以用配置文件的形式  见Fegin工程配置文件
 */

@Configuration
public class MySelfRule {
    @Bean
    public IRule myRulr(){
        return new RandomRule();// 随机规则
    }
}
