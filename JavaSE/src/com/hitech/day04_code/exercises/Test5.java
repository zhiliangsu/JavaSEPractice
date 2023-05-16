package com.hitech.day04_code.exercises;

public class Test5 {
    public static void main(String[] args) {
        /* 需求：给你一个整数 x。
         * 如果x是一个回文数，打印true，否则， 返回false。*/

        int x = 102;
        int temp = x;
        int num = 0;
        while (x != 0) {
            int ge = x % 10;
            x = x / 10;
            num = num * 10 + ge;
        }

        System.out.println(num);
        System.out.println(num == temp);

    }
}
