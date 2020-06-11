package com.xuecheng.govern.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import javax.swing.table.TableRowSorter;

/**
 * Zuul网关
 *
 * @author yuanYuan
 * @version 1.0
 * @EnableZuulProxy 网关注解
 * @SpringBootApplication SpringBoot启动类
 **/
@SpringBootApplication
@EnableZuulProxy
public class GatewayApplication {


    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

}
