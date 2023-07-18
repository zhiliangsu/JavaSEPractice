package com.hitech.part1.a02array;

import java.util.Arrays;
import java.util.Random;

public class ArrayTest1 {
    public static void main(String[] args) {
        /* 需求：生成10个1~100之间的随机数存入数组。

        1）求出所有数据的和

        2）求所有数据的平均数

        3）统计有多少个数据比平均值小 */

        Random r = new Random();
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            int number = r.nextInt(100) + 1;
            arr[i] = number;
        }
        System.out.println(Arrays.toString(arr));

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }

        int avg = sum / arr.length;
        System.out.println(avg);

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < avg) {
                count++;
            }
        }
        System.out.println(count);
    }
}
