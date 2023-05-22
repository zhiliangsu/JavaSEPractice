package com.hitech.day10_string.stringbuiderdemo;

import java.util.Scanner;

public class StringBuilderDemo6 {
    public static void main(String[] args) {
        //对称字符串
        //使用StringBuilder的场景：
        //1.字符串的拼接
        //2.字符串的反转

        //1.键盘录入一个字符串
        Scanner in = new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String str = in.next();

        //2.反转键盘录入的字符串
        String result = new StringBuilder().append(str).reverse().toString();

        //3.比较并输出结果
        if (str.equals(result)) {
            System.out.println("当前字符串是对称字符串");
        } else {
            System.out.println("当前字符串不是对称字符串");
        }
    }
}
