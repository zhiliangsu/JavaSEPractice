package com.hitech.day15_oopadvanced3.p02interface.demo1;

public class Test {
    public static void main(String[] args) {
        // 创建对象
        Rabbit rabbit = new Rabbit("小白", 2);
        System.out.println(rabbit.getName() + ", " + rabbit.getAge());
        rabbit.eat();

        Frog frog = new Frog("小青", 1);
        System.out.println(frog.getName() + ", " + frog.getAge());
        frog.eat();
        frog.swim();
    }
}
