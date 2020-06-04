package com.xuecheng.test.fastdfs;

/**
 * TODO
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/6/1
 */
public class test {
    public static void main(String args[]) {
        Thread t = new Thread() {
            public void run() {
                pong();
            }
        };

        t.run();

        System.out.print("ping");
    }

    static void pong() {
        System.out.print("pong");
    }

}
