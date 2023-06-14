package com.hitech.day32_thread2.p07test7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    ArrayList<Integer> list;

    public MyCallable(ArrayList<Integer> list) {
        this.list = list;
    }

    private static int getSum(ArrayList<Integer> list) {
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        return sum;
    }

    @Override
    public Integer call() throws Exception {
        ArrayList<Integer> boxList = new ArrayList<>();
        // 循环
        while (true) {
            // 同步代码块
            synchronized (MyCallable.class) {
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
            Thread.sleep(10);
        }
        if (boxList.size() == 0) {
            return null;
        } else {
            return Collections.max(boxList);
        }
    }
}
