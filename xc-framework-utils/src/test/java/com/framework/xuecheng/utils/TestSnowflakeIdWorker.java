package com.framework.xuecheng.utils;

import com.xuecheng.framework.utils.SnowflakeIdWorker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * TODO
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/4/24
 */
@RunWith(value = JUnit4.class)
public class TestSnowflakeIdWorker {


    @Test
    public static void test() {
        System.out.println(Long.toBinaryString(5));
        SnowflakeIdWorker idWorker = new SnowflakeIdWorker(1, 1);
        for (int i = 0; i < 1000; i++) {
            long id = idWorker.nextId();
            System.out.println(Long.toBinaryString(id));
            System.out.println(id);
        }
    }
}
