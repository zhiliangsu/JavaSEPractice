package com.hitech.day10_string.stringjoinerdemo;

import java.util.StringJoiner;

public class StringJoinerDemo2 {
    public static void main(String[] args) {
        //1.创建对象,指定中间的间隔符号和开始结束符号
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        //2.添加元素
        sj.add("aaa").add("bbb").add("ccc");
        //3.获取长度
        int len = sj.length();
        System.out.println(len);
        //4.打印
        System.out.println(sj);
        System.out.println(sj.toString());
    }
}
