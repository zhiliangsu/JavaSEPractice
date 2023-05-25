package com.hitech.day15_oopadvanced3.p01abstract.a02abstractdemo2;

public class Frog extends Animal{


    public Frog() {
    }

    public Frog(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("青蛙在吃虫子");
    }
}
