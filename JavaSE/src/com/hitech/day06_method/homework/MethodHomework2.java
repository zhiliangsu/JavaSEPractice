package com.hitech.day06_method.homework;

public class MethodHomework2 {
    public static void main(String[] args) {
        //定义一个方法，该方法能够找出三个整数中的最大值并返回。在主方法中调用方法测试执行。
        System.out.println(getMax(3, 5, 17));
    }

    public static int getMax(int a, int b, int c) {
        int temp = a > b ? a : b;
        int max = temp > c ? temp : c;
        return max;
    }
}
