package com.hitech.day15_oopadvanced3.p02interface.demo5;

public class PingPongAthlete extends Athlete implements SpeakEnglish {
    public PingPongAthlete() {
    }

    public PingPongAthlete(String name, int age) {
        super(name, age);
    }

    @Override
    public void study() {
        System.out.println("乒乓球运动员学打乒乓球");
    }

    @Override
    public void say() {
        System.out.println("乒乓球运动员说英语");
    }
}
