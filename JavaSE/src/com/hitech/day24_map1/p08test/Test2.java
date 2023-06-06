package com.hitech.day24_map1.p08test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Test2 {
    public static void main(String[] args) {
        /* 班级里有N个学生
        要求：
        70%的概率随机到男生
        30%的概率随机到女生

        "范闲","范建","范统","杜子腾","宋合泛","侯笼藤","朱益群","朱穆朗玛峰",
        "杜琦燕","袁明媛","李猜","田蜜蜜",
        */

        // 1.创建集合
        ArrayList<Integer> list = new ArrayList<>();
        // 2.添加数据
        Collections.addAll(list, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0);

        // 3.打乱集合中的数据
        Collections.shuffle(list);

        // 4.从list集合中随机抽取0或1
        Random r = new Random();
        int number = list.get(r.nextInt(list.size()));
        // int number = r.nextInt(10)+1;
        // System.out.println(number);

        // 5.创建2个集合分别存储男生和女生的名字
        ArrayList<String> maleList = new ArrayList<>();
        ArrayList<String> femaleList = new ArrayList<>();
        Collections.addAll(maleList, "范闲", "范建", "范统", "杜子腾", "宋合泛", "侯笼藤", "朱益群", "朱穆朗玛峰");
        Collections.addAll(femaleList, "杜琦燕", "袁明媛", "李猜", "田蜜蜜");

        // 6.判断此时是从男生列表中抽取还是从女生列表中抽取
        if (number == 1) {
            System.out.println(maleList.get(r.nextInt(maleList.size())));
        } else {
            System.out.println(femaleList.get(r.nextInt(femaleList.size())));
        }
        /* if (number <= 7 ) {
            System.out.println(maleList.get(r.nextInt(maleList.size())));
        } else{
            System.out.println(femaleList.get(r.nextInt(femaleList.size())));
        } */
    }
}

