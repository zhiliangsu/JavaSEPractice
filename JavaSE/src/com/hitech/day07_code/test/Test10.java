package com.hitech.day07_code.test;

import java.util.Random;

public class Test10 {
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
        //1.把奖池里的所有奖项都打乱顺序
        int[] arr = {2,588,888,1000,10000};
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            int randomIndex = r.nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[randomIndex];
            arr[randomIndex] = temp;
        }
        //2.遍历奖池，从0索引开始获取每一个奖项
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

}
