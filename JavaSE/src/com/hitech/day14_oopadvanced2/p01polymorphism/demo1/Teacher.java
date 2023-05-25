package com.hitech.day14_oopadvanced2.p01polymorphism.demo1;

public class Teacher extends Person {
    @Override
    public void show() {
        System.out.println("老师的信息是: " + getName() + "," + getAge());
    }
}
