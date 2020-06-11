package com.xuecheng.filesystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * TODO
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/6/10
 */
@RunWith(JUnit4.class)
public class TestCheck {

    @Test
    public void testCheckFileName() {
        String fileName = "36.jp11g";
        if (fileName.contains("jpg") || fileName.contains("png")) {
            System.out.println("通过校验");
        }
    }
}
