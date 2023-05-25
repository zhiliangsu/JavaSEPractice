package com.hitech.day14_oopadvanced2.p01polymorphism.demo1;

public class Student extends Person {
    @Override
    public void show() {
        System.out.println("学生的信息是: " + getName() + "," + getAge());
    }
}
