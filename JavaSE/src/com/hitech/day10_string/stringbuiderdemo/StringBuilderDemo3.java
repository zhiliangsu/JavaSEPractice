package com.hitech.day10_string.stringbuiderdemo;

public class StringBuilderDemo3 {
    public static void main(String[] args) {
        //1.创建对象
        StringBuilder sb = new StringBuilder("abc");

        //2.添加元素
        sb.append(1);
        sb.append(2.3);
        sb.append(true);
        System.out.println(sb);

        //3.反转
        sb.reverse();
        System.out.println(sb);

        //4.获取长度
        int len = sb.length();
        System.out.println(len);

        //5.打印
        //普及：因为StringBuilder是Java已经写好的类
        //java在底层对它做了一些特殊处理，打印对象不是地址而是属性值。
        System.out.println(sb);
    }
}
