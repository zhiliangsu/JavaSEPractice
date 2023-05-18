package com.hitech.day07_code.test;

import java.util.Random;

public class Test9 {
    public static void main(String[] args) {
        /*需求：
        一个大V直播抽奖，奖品是现金红包，分别有{2,588,888,1000,10000}五个奖金。
        请使用代码模拟抽奖，打印出每个奖项，奖项的出现顺序要随机且不重复。
        打印效果如下：（随机顺序，不一定是下面的顺序）
            888元的奖金被抽出
            588元的奖金被抽出
            10000元的奖金被抽出
            1000元的奖金被抽出
            2元的奖金被抽出
        */

        //1.定义数组表示奖池
        int[] arr = {2, 588, 888, 1000, 10000};
        //2.定义新数组用于存储抽奖的结果
        int[] newArr = new int[arr.length];
        //3.抽奖
        Random r = new Random();
        for (int i = 0; i < 5; ) {
            int randomIndex = r.nextInt(arr.length);
            int prize = arr[randomIndex];
            if (!contains(newArr, prize)) {
                newArr[i] = prize;
                i++;
            }
        }
        //4.打印抽奖结果
        for (int i = 0; i < newArr.length; i++) {
            System.out.println(newArr[i]);
        }
    }

    public static boolean contains(int[] arr, int prize) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == prize) {
                return true;
            }
        }
        return false;
    }
}
