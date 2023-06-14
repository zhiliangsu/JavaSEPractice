package com.hitech.day32_thread2.p03test3;

public class MyThread extends Thread {
    static int number = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (MyThread.class) {
                if (number > 100) {
                    break;
                } else {
                    if (number % 2 == 1) {
                        System.out.println(getName() + "打印数字" + number);
                    }
                    number++;
                }
            }
        }
    }
}
