package com.hitech.day10_string.stringdemo;

import java.util.Scanner;

public class StringDemo2 {
    public static void main(String[] args) {
        //字符串比较：equals/equalsIgnoreCase
        String rightUsername = "zhangsan";
        String rightPassword = "123456";

        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入用户名：");
            String username = in.next();
            System.out.println("请输入密码：");
            String password = in.next();

            if (username.equals(rightUsername) && password.equals(rightPassword)) {
                System.out.println("用户登录成功");
                break;
            } else {
                if (i == 2) {
                    System.out.println("账号" + username + "被锁定，请联系管理员");
                } else {
                    System.out.println("用户登录失败，用户名活密码有误，您还剩下" + (2 - i) + "次机会");
                }
            }
        }
    }
}
