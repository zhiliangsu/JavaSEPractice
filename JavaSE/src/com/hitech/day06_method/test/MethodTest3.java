package com.hitech.day06_method.test;

public class MethodTest3 {
    public static void main(String[] args) {
        //需求：定义一个方法获取数字，在数组中的索引位置，将结果返回给调用处，如果有重复的，只要获取第一个即可。
        int[] arr = {1, 2,3,4,3};
        boolean flag = contains(arr, 3);
        System.out.println(flag);
    }

    public static boolean contains(int[] arr, int number) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                return true;
            }
        }
        return false;
    }
}
