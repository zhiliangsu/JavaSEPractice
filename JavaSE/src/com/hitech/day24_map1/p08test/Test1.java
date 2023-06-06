package com.hitech.day24_map1.p08test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Test1 {
    public static void main(String[] args) {
        /* 班级里有N个学生，学生属性:姓名，年龄，性别。
        实现随机点名器。*/

        //1.创建集合
        ArrayList<String> list = new ArrayList<>();
        //2.添加数据
        Collections.addAll(list, "范闲","范建","范统","杜子腾","杜琦燕",
                "宋合泛","侯笼藤","朱益群","朱穆朗玛峰","袁明媛");
        //3.随机点名
        //3.1通过创建random对象随机
        Random r = new Random();
        System.out.println(list.get(r.nextInt(list.size())));
        // 3.2通过Collections.shuffle方法随机
        Collections.shuffle(list);
        System.out.println(list.get(0));
    }
}
