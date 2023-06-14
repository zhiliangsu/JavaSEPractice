package com.hitech.day32_thread2.p06test6case2;

import java.util.ArrayList;
import java.util.Collections;

public class MyThread extends Thread {
    ArrayList<Integer> list;

    public MyThread(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        ArrayList<Integer> boxList = new ArrayList<>();
        // 循环
        while (true) {
            // 同步代码块
            synchronized (MyThread.class) {
                if (list.size() == 0) {
                    // 判断,共享数据是否到了末尾(已经到了末尾)
                    System.out.println("在此次抽奖过程中,抽奖箱1总共产生了" + boxList.size() + "个奖项");
                    System.out.println("    分别为: " + boxList.toString().substring(1, boxList.toString().length() - 1)
                            + " 最高奖项为" + Collections.max(boxList) + "元,总计额为" + getSum(boxList));
                    break;
                } else {
                    // 判断,共享数据是否到了末尾(没有到末尾)
                    Collections.shuffle(list);
                    boxList.add(list.remove(0));
                }
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static int getSum(ArrayList<Integer> list) {
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        return sum;
    }
}
