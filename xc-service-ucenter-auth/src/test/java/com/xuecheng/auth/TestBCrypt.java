package com.xuecheng.auth;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestBCrypt {
    @Test
    public void testPasswrodEncoder() {
        //原始密码
        String password = "testBCrypt";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        //使用BCrypt加密，每次加密使用一个随机盐
        for (int i = 0; i < 10; i++) {
            //加密
            String encode = bCryptPasswordEncoder.encode(password);
            System.out.println("加密后值 ： " + encode);

            //校验
            boolean matches = bCryptPasswordEncoder.matches(password, encode);
            System.out.println("校验通过 ： " + matches);
        }
    }
}
