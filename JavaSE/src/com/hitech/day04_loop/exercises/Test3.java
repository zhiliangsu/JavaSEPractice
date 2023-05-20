package com.hitech.day04_loop.exercises;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入您的选择");

        int selection = in.nextInt();
        switch (selection) {
            case 1 -> System.out.println("机票查询");
            case 2 -> System.out.println("机票预定");
            case 3 -> System.out.println("机票改签");
            //case 4 -> System.out.println("退出服务");
            default -> System.out.println("退出服务");
        }
    }
}
