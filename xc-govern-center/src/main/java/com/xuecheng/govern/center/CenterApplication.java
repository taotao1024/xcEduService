package com.xuecheng.govern.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka 服务器
 *
 * @author yuanYuan
 * @version 1.0
 * @EnableEurekaServer Eureka服务端注解
 * @SpringBootApplication SpringBoot启动类
 **/
@EnableEurekaServer
@SpringBootApplication
public class CenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(CenterApplication.class, args);
    }
}
