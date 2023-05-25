package com.hitech.day14_oopadvanced2.p01polymorphism.demo1;

public class Administrator extends Person {
    @Override
    public void show() {
        System.out.println("管理员的信息是: " + getName() + "," + getAge());
    }
}
