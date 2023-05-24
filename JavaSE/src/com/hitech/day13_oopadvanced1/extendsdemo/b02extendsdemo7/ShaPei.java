package com.hitech.day13_oopadvanced1.extendsdemo.b02extendsdemo7;

public class ShaPei extends Dog {
    @Override
    public void eat() {
        super.eat();
        System.out.println("狗在啃骨头");
    }
}
