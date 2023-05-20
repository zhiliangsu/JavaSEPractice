package com.hitech.day09_oop2.test4;

import java.util.Scanner;

public class CarTest {
    public static void main(String[] args) {
        //1.创建数组
        Car[] arr = new Car[3];

        //2.创建汽车对象，数据来自于键盘录入
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            Car c = new Car();
            //录入品牌
            System.out.println("请输入汽车的品牌：");
            c.setBrand(in.next());
            //录入价格
            System.out.println("请输入汽车的价格；");
            c.setPrice(in.nextInt());
            //录入颜色
            System.out.println("请输入汽车的颜色；");
            c.setColor(in.next());

            //把对象添加到数组中
            arr[i] = c;
        }

        //3.遍历数组
        for (int i = 0; i < arr.length; i++) {
            Car car = arr[i];
            System.out.println(car.getBrand() + "，" + car.getPrice() + "，" + car.getColor());
        }
    }
}
