package com.hitech.day25_pokergame.p08test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Test3 {
    public static void main(String[] args) {
        /* 班级里有5个学生
        要求：
        被点到的学生不会再被点到。
        但是如果班级中所有的学生都点完了，需要重新开启第二轮点名。*/

        // 1.创建集合
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        // 2.添加数据
        Collections.addAll(list, "范闲", "范建", "范统", "杜子腾", "杜琦燕",
                "宋合泛", "侯笼藤", "朱益群", "朱穆朗玛峰", "袁明媛");
        // 3.随机点名
        // 3.1通过创建random对象随机
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println("===========第" + i + "轮点名开始了===========");
            int count = list.size();
            for (int j = 0; j < count; j++) {
                int index = r.nextInt(list.size());
                String name = list.remove(index);
                list2.add(name);
                System.out.println(name);
            }

            list.addAll(list2);
            list2.clear();
        }
    }
}
