package com.hitech.day32_thread2.p06test6case1;

import java.util.ArrayList;
import java.util.Collections;

public class MyThread extends Thread {
    ArrayList<Integer> list;
    static ArrayList<Integer> list1 = new ArrayList<>();
    static ArrayList<Integer> list2 = new ArrayList<>();

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
                    if ("抽奖箱1".equals(getName())) {
                        System.out.println("在此次抽奖过程中,抽奖箱1总共产生了" + list1.size() + "个奖项");
                        System.out.println("    分别为: " + list1.toString().substring(1, list1.toString().length() - 1)
                                + " 最高奖项为" + Collections.max(list1) + "元,总计额为" + getSum(list1));
                    } else {
                        System.out.println("在此次抽奖过程中,抽奖箱2总共产生了" + list2.size() + "个奖项");
                        System.out.println("    分别为: " + list1.toString().substring(1, list1.toString().length() - 1)
                                + " 最高奖项为" + Collections.max(list2) + "元,总计额为" + getSum(list2));
                    }
                    break;
                } else {
                    // 判断,共享数据是否到了末尾(没有到末尾)
                    Collections.shuffle(list);
                    if ("抽奖箱1".equals(getName())) {
                        list1.add(list.remove(0));
                    } else {
                        list2.add(list.remove(0));
                    }
                    // System.out.println(getName() + " 又产生了一个 " + number + " 元大奖");
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
