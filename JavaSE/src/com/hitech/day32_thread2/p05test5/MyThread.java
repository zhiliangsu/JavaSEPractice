package com.hitech.day32_thread2.p05test5;

import java.util.ArrayList;
import java.util.Collections;

public class MyThread extends Thread {
    ArrayList<Integer> list;

    public MyThread(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        // 循环
        while (true) {
            // 同步代码块
            synchronized (MyThread.class) {
                if (list.size() == 0) {
                    // 判断,共享数据是否到了末尾(已经到了末尾)
                    break;
                } else {
                    // 判断,共享数据是否到了末尾(没有到末尾)
                    Collections.shuffle(list);
                    int number = list.remove(0);
                    System.out.println(getName() + " 又产生了一个 " + number + " 元大奖");
                }
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
