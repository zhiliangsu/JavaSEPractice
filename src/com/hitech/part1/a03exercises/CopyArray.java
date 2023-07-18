package com.hitech.part1.a03exercises;

import java.util.Arrays;

public class CopyArray {
    public static void main(String[] args) {
        // 需求：把一个数组中的元素复制到另一个新数组中去。

        // 1.定义新数组,长度和需要复制的数组长度一致
        int[] arr = {1, 2, 3, 4, 5};
        int[] newArr = new int[arr.length];

        // 2.循环遍历老数组,复制元素
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        // 3.打印结果
        System.out.println(Arrays.toString(newArr));
    }
}
