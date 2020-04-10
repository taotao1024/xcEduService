package com.lsy.thread;

public class B {
    public static void main(String[] args) throws InterruptedException {
        A a = A.getA();
        int assignment = a.assignment();
        System.out.println("A执行结束，返回到方法B");
        System.out.println(assignment);
    }
}
