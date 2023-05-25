package com.hitech.day15_oopadvanced3.p01abstract.a02abstractdemo2;

public class Dog extends Animal{


    public Dog() {
    }

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }
}