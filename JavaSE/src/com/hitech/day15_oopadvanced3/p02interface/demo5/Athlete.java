package com.hitech.day15_oopadvanced3.p02interface.demo5;

public abstract class Athlete extends Person {
    public Athlete() {
    }

    public Athlete(String name, int age) {
        super(name, age);
    }

    public abstract void study();
}
