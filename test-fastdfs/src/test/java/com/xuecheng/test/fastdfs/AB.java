package com.xuecheng.test.fastdfs;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * TODO
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/6/1
 */
public class AB {
    static class HelloA {
        public HelloA() {
            System.out.println("HelloA");
        }

        {
            System.out.println("I'm A class");
        }

        static {
            System.out.println("static A");
        }
    }


    static class HelloB extends HelloA {
        public HelloB() {
            System.out.println("HelloB");
        }

        {
            System.out.println("I'm B class");
        }

        static {
            System.out.println("static B");
        }
    }

    public static void main(String[] args) {
        new HelloB();
        //float num1=0.63323;
        float num2 = 0.63323f;
        int a = 3 / 4;
        int b = 3 % 2;
        int c;
        System.out.println(a++);
        System.out.println(a + b);
    }

    public static void method(File file) {
        File[] fs = file.listFiles();// 得到File数组
        String fname;
        if (fs != null) {// 判断fs是否为null
            for (File f : fs) {
                fname = f.getName();
                if (f.isFile() && fname.contains(".xlsx")) {// 如果是zhi文件直接输出
                    System.out.println(f.getName());
                } else {
                    method(f);// 否则递归调用dao
                }
            }
        }
    }

    @Test
    public void selectCPan() {
        File file = new File("C:\\");// 指定文件目录
        method(file);
    }

}
