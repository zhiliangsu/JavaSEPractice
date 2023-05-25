package com.hitech.day15_oopadvanced3.p02interface.demo5;

public class BasketballCoach extends Coach {
    public BasketballCoach() {
    }

    public BasketballCoach(String name, int age) {
        super(name, age);
    }

    @Override
    public void teach() {
        System.out.println("篮球教练教打篮球");
    }
}
