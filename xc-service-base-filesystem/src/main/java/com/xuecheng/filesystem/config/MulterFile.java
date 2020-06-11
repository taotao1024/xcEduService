package com.xuecheng.filesystem.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

/**
 * TODO
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/6/10
 */
@Configuration
public class MulterFile {
    /**
     * 文件上传配置
     *
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大
        factory.setMaxFileSize("3072KB"); //KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("3072KB");
        return factory.createMultipartConfig();
    }
}

