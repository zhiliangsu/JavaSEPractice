package com.hitech.day26_map2.p02stream;

import java.util.ArrayList;
import java.util.Collections;

public class StreamDemo1 {
    public static void main(String[] args) {
        /*
            创建集合添加元素，完成以下需求：
            1.把所有以“张”开头的元素存储到新集合中
            2.把“张”开头的，长度为3的元素再存储到新集合中
            3.遍历打印最终结果
        */
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("张无忌");
        list1.add("周芷若");
        list1.add("赵敏");
        list1.add("张强");
        list1.add("张三丰");

        ArrayList<String> list2 = new ArrayList<>();
        for (String name : list1) {
            if (name.startsWith("张")) {
                list2.add(name);
            }
        }

        ArrayList<String> list3 = new ArrayList<>();
        for (String name : list2) {
            if (name.length() == 3) {
                list3.add(name);
            }
        }

        list3.forEach(s -> System.out.println(s));
        System.out.println("----------------------");

        list1.stream().filter(s -> s.startsWith("张")).filter(s -> s.length() == 3).forEach(s -> System.out.println(s));
    }
}
