package com.hitech.day15_oopadvanced3.p01abstract.a01abstractdemo1;

public class Student extends Person{


    public Student() {
    }

    public Student(String name, int age) {
        super(name, age);
    }

    @Override
    public void work() {
        System.out.println("学生的工作是学习");
    }
}
