package com.xuecheng.test.fastdfs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试注解提炼
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/4/18
 */

@RequestMapping(value = "/a")
public interface api {
    /**
     * 测试注解升级
     *
     * @return
     */
    @GetMapping(value = "/testapi")
    public String testApi();
}
