package com.hitech.part1.a03exercises;

import java.util.ArrayList;

public class FindPrimeNumber {
    public static void main(String[] args) {
        // 判断101~200之间有多少个素数，并输出所有素数
        // 质数只能被自身和1整除
        // 1.定义count变量,统计质数的个数
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        // 2.遍历101~200,判断里面的每一个数是否是质数
        for (int i = 101; i <= 200; i++) {
            // 3.定义flag变量,判断是否是质数
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    // 此时说明当前循环的i值不是一个质数
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(i);
                count++;
            }
        }

        // 4.打印结果
        System.out.println("一共有" + count + "个质数,结果如下:");
        System.out.println(list);
    }
}
