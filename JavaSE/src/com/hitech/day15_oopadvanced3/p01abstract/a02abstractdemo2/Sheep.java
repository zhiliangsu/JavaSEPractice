package com.hitech.day15_oopadvanced3.p01abstract.a02abstractdemo2;

public class Sheep extends Animal{

    public Sheep() {
    }

    public Sheep(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("山羊在吃草");
    }
}
