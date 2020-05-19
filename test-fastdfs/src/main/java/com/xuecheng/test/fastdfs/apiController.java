package com.xuecheng.test.fastdfs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/4/18
 */
@RestController
public class apiController implements api {
    @Override
    public String testApi() {
        System.out.println("我被调用了");
        return "测试成功";
    }
}
