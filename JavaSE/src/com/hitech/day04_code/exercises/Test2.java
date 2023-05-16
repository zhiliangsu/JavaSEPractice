package com.hitech.day04_code.exercises;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请录入一个整数表示星期几");

        int weekday = in.nextInt();
        switch (weekday) {
            case 1, 2, 3, 4, 5 -> System.out.println("工作日");
            case 6, 7 -> System.out.println("休息日");
            default -> System.out.println("输入有误");
        }
    }
}
