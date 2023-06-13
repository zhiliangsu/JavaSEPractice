package com.hitech.day31_thread1.a09threadsafe1;

public class MyThread extends Thread {
    // 表示这个类所有的对象,都共享ticket数据
    static int ticket = 0;

    // 锁的对象一定要是唯一的
    // static Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (MyThread.class) {
                if (ticket < 100) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    ticket++;
                    System.out.println(getName() + "正在卖票:" + ticket);
                } else {
                    break;
                }
            }
        }
    }
}
