package com.hitech.day31_thread1.itheima.a06threadmethod3;

public class MyThread2 extends Thread{

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(getName() + "@" + i);
        }
    }
}