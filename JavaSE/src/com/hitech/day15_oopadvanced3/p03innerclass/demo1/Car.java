package com.hitech.day15_oopadvanced3.p03innerclass.demo1;

public class Car {
    String carName;
    int carAge;
    String carColor;

    public void show() {
        System.out.println(this.carName);
        Engine engine = new Engine();
        System.out.println(engine.engineName);
    }

    class Engine {
        String engineName;
        int engineAge;

        public void show() {
            System.out.println(engineName);
            System.out.println(carName);
        }
    }
}
