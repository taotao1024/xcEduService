package com.xuecheng.govern.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 网关测试
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/5/15
 */
@SpringBootApplication
@EnableZuulProxy
public class TestGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestGatewayApplication.class, args);
    }
}
