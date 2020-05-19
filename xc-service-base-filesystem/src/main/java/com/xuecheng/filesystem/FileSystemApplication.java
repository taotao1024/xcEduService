package com.xuecheng.filesystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * 基础分布式文件系统
 *
 * @author yuanYuan
 * @version 1.0-SNAPSHOT
 * @ComponentScan 组件扫描注解
 * @EntityScan 实体扫描注解
 * @SpringBootApplication SpringCloud注解
 * @date 2020/4/24
 */
@SpringBootApplication//扫描所在包及子包的bean，注入到ioc中
@EntityScan(value = "com.xuecheng.framework.domain.filesystem")//扫描实体类
@ComponentScan(basePackages = {"com.xuecheng.api"})//扫描接口
@ComponentScan(basePackages = {"com.xuecheng.framework"})//扫描framework中通用类
@ComponentScan(basePackages = {"com.xuecheng.filesystem"})//扫描本项目下的所有类
public class FileSystemApplication {
    /**
     * 启动方法
     *
     * @param args 字符串数组
     */
    public static void main(String[] args) {
        SpringApplication.run(FileSystemApplication.class, args);
    }
}
