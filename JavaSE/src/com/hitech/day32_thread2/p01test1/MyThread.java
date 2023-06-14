package com.hitech.day32_thread2.p01test1;

public class MyThread extends Thread {

    // 第一种方式实现多线程,测试类中MyThread会创建多次,所以需要加static
    static int count = 1000;

    @Override
    public void run() {
        // 1.循环
        while (true) {
            // 2.同步代码块
            synchronized (MyThread.class) {
                // 3.判断共享数据(已经到末尾)
                if (count == 0) {
                    break;
                } else {
                    // 4.判断共享数据(没有到末尾)
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    count--;
                    System.out.println(getName() + "领取了1张票,当前剩余" + count + "张票");
                }
            }
        }
    }
}
