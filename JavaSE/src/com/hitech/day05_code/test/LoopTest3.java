package com.hitech.day05_code.test;

import java.util.Scanner;

public class LoopTest3 {
    public static void main(String[] args) {
        /*
        需求：键盘录入一个正整数x，判断该整数是否为一个质数。
         */
        Scanner in = new Scanner(System.in);
        System.out.println("请输入一个正整数：");
        int number = in.nextInt();
        boolean flag = true;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println(number + "是一个质数");
        } else {
            System.out.println(number + "不是一个质数");
        }
    }
}