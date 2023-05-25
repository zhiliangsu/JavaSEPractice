package com.hitech.day15_oopadvanced3.p02interface.demo9;

public class InterImpl extends InterAdapter{
  //我需要用到那个方法，就重写哪个方法就可以了

    @Override
    public void method5() {
        System.out.println("只要用第五个方法");
    }
}
