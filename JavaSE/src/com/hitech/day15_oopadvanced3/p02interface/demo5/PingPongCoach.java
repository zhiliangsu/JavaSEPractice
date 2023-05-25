package com.hitech.day15_oopadvanced3.p02interface.demo5;

public class PingPongCoach extends Coach implements SpeakEnglish {
    public PingPongCoach() {
    }

    public PingPongCoach(String name, int age) {
        super(name, age);
    }

    @Override
    public void teach() {
        System.out.println("乒乓球教练教打乒乓球");
    }

    @Override
    public void say() {
        System.out.println("乒乓球教练说英语");
    }
}
