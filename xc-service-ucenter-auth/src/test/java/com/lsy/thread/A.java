package com.lsy.thread;

public class A {
    public static int init;
    private static A a = null;

    private A() {
        System.out.println("A正在执行");
    }

    public static A getA() {
        if (null == a) {
            a = new A();
            return a;
        }
        return null;
    }

    public int assignment() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                init = 20;
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
            }
        });

        thread1.run();
        System.out.println("这是thread1的结果：" + init);
        thread1.sleep(1000);
        thread2.run();
        System.out.println("这是thread2的结果：" + init);
        return init;
    }
}