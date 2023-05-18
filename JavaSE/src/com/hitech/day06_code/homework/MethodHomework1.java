package com.hitech.day06_code.homework;

public class MethodHomework1 {
    public static void main(String[] args) {
        //定义一个方法，该方法能够找出两个小数中的较小值并返回。在主方法中调用方法进行测试。
        double compareResult = compare(10.2, 2.4);
        System.out.println(compareResult);
    }

    public static double compare(double a, double b) {
//        if (a < b) {
//            return a;
//        } else {
//            return b;
//        }
        return a < b ? a : b;
    }
}
