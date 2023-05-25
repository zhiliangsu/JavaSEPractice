package com.hitech.day15_oopadvanced3.p03innerclass.a02innerclassdemo2;

public class Outer {
    String name;

    private class Inner{
        static int a = 10;
    }


    public Inner getInstance(){
        return new Inner();
    }


}
