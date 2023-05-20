package com.hitech.day05_array.test;

public class  ArrayTest2 {
    public static void main(String[] args) {
        //定义数组求最大值：33,5,22,44,55

        int[] arr = {33,5,22,44,55};
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println(max);
    }
}
