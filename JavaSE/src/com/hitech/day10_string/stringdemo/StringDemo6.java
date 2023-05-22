package com.hitech.day10_string.stringdemo;

public class StringDemo6 {
    public static void main(String[] args) {
        //字符串反转
        String str = reverse("abc");
        System.out.println(str);
    }

    public static String reverse(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            result += c;
        }
        return result;
    }
}
