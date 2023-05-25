package com.hitech.day13_oopadvanced1.p02extendsdemo.b03extendsdemo10;

import com.hitech.day13_oopadvanced1.p02extendsdemo.a10oopextendsdemo10.Cook;
import com.hitech.day13_oopadvanced1.p02extendsdemo.a10oopextendsdemo10.Manager;

public class Test {
    public static void main(String[] args) {
        //创建对象并赋值调用
        com.hitech.day13_oopadvanced1.p02extendsdemo.a10oopextendsdemo10.Manager m = new Manager("heima001","张三",15000,8000);
        System.out.println(m.getId() + ", " + m.getName() +
                ", " + m.getSalary() + ", " + m.getBouns());
        m.work();
        m.eat();



        com.hitech.day13_oopadvanced1.p02extendsdemo.a10oopextendsdemo10.Cook c = new Cook();
        c.setId("heima002");
        c.setName("李四");
        c.setSalary(8000);
        System.out.println(c.getId() + ", " + c.getName() + ", " + c.getSalary());
        c.work();
        c.eat();
    }
}
