package com.hitech.day15_oopadvanced3.p02interface.demo5;

public class Test {
    public static void main(String[] args) {
        // 创建对象
        PingPongAthlete pa = new PingPongAthlete("malong", 30);
        System.out.println(pa.getName() + ", " + pa.getAge());
        pa.study();
        pa.say();

        BasketballAthlete ba = new BasketballAthlete("kobe", 28);
        System.out.println(ba.getName() + ", " + ba.getAge());
        ba.study();

        PingPongCoach pc = new PingPongCoach("liuguoliang", 45);
        System.out.println(pc.getName() + ", " + pc.getAge());
        pc.teach();
        pc.say();

        BasketballCoach bc = new BasketballCoach("rivers", 55);
        System.out.println(bc.getName() + ", " + bc.getAge());
        bc.teach();
    }
}
