package com.hitech.day13_oopadvanced1.extendsdemo.b01extendsdemo1;

public class Test {
    public static void main(String[] args) {
        //创建对象并调用方法
        //1.创建狸花猫的对象
        LiHua lihua = new LiHua();
        lihua.eat();
        lihua.drink();
        lihua.catchMouse();

        System.out.println("=================================");

        //2.创建泰迪的对象
        Teddy teddy = new Teddy();
        teddy.eat();
        teddy.drink();
        teddy.lookHome();
        teddy.touch();
    }
}
