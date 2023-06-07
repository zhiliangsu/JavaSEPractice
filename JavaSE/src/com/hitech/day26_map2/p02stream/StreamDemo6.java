package com.hitech.day26_map2.p02stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Predicate;

public class StreamDemo6 {
    public static void main(String[] args) {
        /*
            filter              过滤
            limit               获取前几个元素
            skip                跳过前几个元素

            注意1：中间方法，返回新的Stream流，原来的Stream流只能使用一次，建议使用链式编程
            注意2：修改Stream流中的数据，不会影响原来集合或者数组中的数据
        */

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌", "周芷若", "赵敏", "张强", "张三丰",
                "张翠山", "张良", "王二麻子", "谢广坤");

        // filter              过滤
        list.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("张") && s.length()==3;
            }
        }).forEach(s -> System.out.println(s));
        System.out.println("============================");

        list.stream()
                .filter(s -> s.startsWith("张"))
                .filter(s -> s.length()==3)
                .forEach(s -> System.out.println(s));
        System.out.println("============================");


        // limit               获取前几个元素
        // skip                跳过前几个元素
        list.stream().limit(3).forEach(s -> System.out.println(s));
        System.out.println("============================");
        list.stream().skip(3).forEach(s -> System.out.println(s));
        System.out.println("============================");
        list.stream().skip(3).limit(3).forEach(s -> System.out.println(s));
        System.out.println("============================");
        list.stream().limit(6).skip(3).forEach(s -> System.out.println(s));
    }
}
