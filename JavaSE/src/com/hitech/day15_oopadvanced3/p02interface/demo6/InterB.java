package com.hitech.day15_oopadvanced3.p02interface.demo6;

public interface InterB {
    public default void show(){
        System.out.println("InterB接口中的默认方法 ---- show");
    }
}
