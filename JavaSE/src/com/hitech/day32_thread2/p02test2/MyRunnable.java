package com.hitech.day32_thread2.p02test2;

public class MyRunnable implements Runnable {
    //第二种方式实现多线程，测试类中MyRunable只创建一次，所以不需要加static
    int gifts = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (MyRunnable.class) {
                if (gifts < 10) {
                    System.out.println("礼物还剩下" + gifts + "不再赠送");
                    break;
                } else {
                    gifts--;
                    System.out.println(Thread.currentThread().getName() + "发送了1份礼品,当前剩余" + gifts + "份礼品");
                }
            }
        }
    }
}
