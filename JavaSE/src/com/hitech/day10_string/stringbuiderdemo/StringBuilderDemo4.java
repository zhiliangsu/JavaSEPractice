package com.hitech.day10_string.stringbuiderdemo;

public class StringBuilderDemo4 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

//        sb.append("aaa");
//        sb.append("bbb");
//        sb.append("ccc");
//        sb.append("ddd");
        sb.append("aaa").append("bbb").append("ccc").append("ddd");

        System.out.println(sb);
        String str = sb.toString();
        System.out.println(str);
    }
}
