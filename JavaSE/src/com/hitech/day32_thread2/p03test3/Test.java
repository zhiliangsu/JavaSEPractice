package com.hitech.day32_thread2.p03test3;

public class Test {
    public static void main(String[] args) {
        /*
           同时开启两个线程，共同获取1-100之间的所有数字。
           要求：将输出所有的奇数。
        */

        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.start();
        t2.start();
    }
}
