package com.hitech.day11_arraylist.test;

import java.util.ArrayList;

/*
需求：
        定义Javabean类：Phone
        Phone属性：品牌，价格。
        main方法中定义一个集合，存入三个手机对象。
        分别为：小米，1000。苹果，8000。锤子 2999。
        定义一个方法，将价格低于3000的手机信息返回。
*/
public class Test8 {
    public static void main(String[] args) {
        // 1.创建集合
        ArrayList<Phone> list = new ArrayList<>();
        // 2.创建手机对象并添加到集合中
        Phone p1 = new Phone("小米", 1000);
        Phone p2 = new Phone("苹果", 8000);
        Phone p3 = new Phone("锤子", 2999);
        list.add(p1);
        list.add(p2);
        list.add(p3);
        // 3.调用方法
        ArrayList<Phone> phoneInfoList = getPhoneInfo(list);
        // 4.遍历集合
        for (int i = 0; i < phoneInfoList.size(); i++) {
            Phone phone = phoneInfoList.get(i);
            System.out.println(phone.getBrand() + ", " + phone.getPrice());
        }

    }

    public static ArrayList<Phone> getPhoneInfo(ArrayList<Phone> list) {
        ArrayList<Phone> resultList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int price = list.get(i).getPrice();
            if (price < 3000) {
                resultList.add(list.get(i));
            }
        }
        return resultList;
    }
}
