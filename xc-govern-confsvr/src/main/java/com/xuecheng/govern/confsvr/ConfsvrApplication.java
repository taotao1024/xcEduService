package com.xuecheng.govern.confsvr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


/**
 * 配置管理服务器
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/5/15
 * @EnableConfigServer 标记此类是Confsvr类
 * @SpringBootApplication 标记Spring Boot 启动类
 */
@SpringBootApplication
@EnableConfigServer
public class ConfsvrApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfsvrApplication.class, args);
    }
}
