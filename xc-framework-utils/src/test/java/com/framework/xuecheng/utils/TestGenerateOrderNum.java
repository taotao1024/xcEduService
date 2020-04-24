package com.framework.xuecheng.utils;

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
public class TestGenerateOrderNum {
    @Test
    public void test() {
        // 测试多线程调用订单号生成工具
        /*try {
            for (int i = 0; i < 200; i++) {
                Thread t1 = new Thread(new Runnable() {
                    public void run() {
                        GenerateOrderNum generateOrderNum = new GenerateOrderNum();
                        generateOrderNum.generate("a");
                    }
                }, "at" + i);
                t1.start();

                Thread t2 = new Thread(new Runnable() {
                    public void run() {
                        GenerateOrderNum generateOrderNum = new GenerateOrderNum();
                        generateOrderNum.generate("b");
                    }
                }, "bt" + i);
                t2.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        System.out.println(System.currentTimeMillis());
    }
}
