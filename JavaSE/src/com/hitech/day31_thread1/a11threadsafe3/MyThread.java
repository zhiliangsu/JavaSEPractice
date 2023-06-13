package com.hitech.day31_thread1.a11threadsafe3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread extends Thread {
    // 表示这个类所有的对象,都共享ticket数据
    static int ticket = 0;

    // 锁的对象一定要是唯一的
    // static Object obj = new Object();
    static Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            //手动上锁
            lock.lock();
            try {
                if (ticket == 100) {
                    break;
                } else {
                    Thread.sleep(10);
                    ticket++;
                    System.out.println(getName() + "正在卖票:" + ticket);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                // 手动解锁
                lock.unlock();
            }
        }
    }
}
