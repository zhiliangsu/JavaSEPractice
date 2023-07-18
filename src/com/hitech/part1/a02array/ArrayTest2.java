package com.hitech.part1.a02array;

import java.util.Arrays;

public class ArrayTest2 {
    public static void main(String[] args) {
        /* 需求：定义一个数组，存入1,2,3,4,5。按照要求交换索引对应的元素。

        交换前：1,2,3,4,5

        交换后：5,2,3,4,1 */

        int[] arr = {1, 2, 3, 4, 5};
        for (int i = 0, j = arr.length-1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
