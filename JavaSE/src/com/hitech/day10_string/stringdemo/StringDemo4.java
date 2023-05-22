package com.hitech.day10_string.stringdemo;

import java.util.Scanner;

public class StringDemo4 {
    public static void main(String[] args) {
        //统计字符串
        //1.键盘录入一个字符串
        Scanner in = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String str = in.next();

        //2.定义计数器，遍历录入的字符串
        int upperCount = 0;
        int lowerCount = 0;
        int numCount = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                upperCount++;
            } else if (c >= 'a' && c <= 'z') {
                lowerCount++;
            } else if (c >= '0' && c <= '9') {
                numCount++;
            }
        }

        //3.输出打印
        System.out.println("大写字母有：" + upperCount + "个");
        System.out.println("小写字母有：" + lowerCount + "个");
        System.out.println("数字字母有：" + numCount + "个");
    }
}
