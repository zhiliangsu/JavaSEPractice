package com.hitech.day15_oopadvanced3.p02interface.demo5;

public class BasketballAthlete extends Athlete {
    public BasketballAthlete() {
    }

    public BasketballAthlete(String name, int age) {
        super(name, age);
    }

    @Override
    public void study() {
        System.out.println("篮球运动员学打篮球");
    }
}
