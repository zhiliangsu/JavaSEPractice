package com.hitech.day06_method.test;

public class MethodTest2 {

    public static void main(String[] args) {
        //需求：设计一个方法用于获取数组中元素的最大值
        int[] arr = {1, 4, 5, 3, 7, 8};
        int max = getMax(arr);
        System.out.println(max);
    }

    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
