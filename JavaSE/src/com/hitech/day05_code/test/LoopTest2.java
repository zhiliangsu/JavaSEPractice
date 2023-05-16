package com.hitech.day05_code.test;

import java.util.Scanner;

public class LoopTest2 {
    public static void main(String[] args) {
        /*
        需求：键盘录入一个大于等于2的整数x，计算并返回x的平方根。
        结果只保留整数部分，小数部分将被舍去
         */
        Scanner in = new Scanner(System.in);
        System.out.println("请输入一个整数：");

        int number = in.nextInt();
        for (int i = 1; i <= number; i++) {
            if (i * i == number){
                System.out.println(i + "就是" + number + "的平方根");
                break;
            } else if ( i * i > number) {
                System.out.println((i -1) + "就是" + number + "平方根的整数部分");
                break;
            }
        }
    }
}
