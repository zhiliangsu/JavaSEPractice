package com.hitech.day10_string.stringdemo;

import java.util.Scanner;

public class StringDemo3 {
    public static void main(String[] args) {
        //字符串遍历
        Scanner in = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String str = in.next();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            System.out.println(c);
        }
    }
}
