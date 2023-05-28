package com.hitech.day18_api1.p01mathdemo;

public class demo1 {
    public static void main(String[] args) {
        // 统计水仙花数
        int count = 0;
        for (int i = 100; i <= 999; i++) {
            int ones = i % 10;
            int tens = i / 10 % 10;
            int hundreds = i / 100 % 10;
            double sum = Math.pow(ones, 3) + Math.pow(tens, 3) + Math.pow(hundreds, 3);
            if (sum == i) {
                count++;
            }
        }
        System.out.println(count);
    }
}
