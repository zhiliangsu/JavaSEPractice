package com.hitech.day13_oopadvanced1.p01staticdemo.a02staticdemo2;

public class TestDemo {
    public static void main(String[] args) {
        // 测试工具类中两个方法是否正确
        int[] arr1 = {1, 2, 3, 4, 5};
        String str = ArrayUtil.printArr(arr1);
        System.out.println(str);

        double[] arr2 = {1.5, 2.4, 3.7, 5.8, 9.9};
        double avg = ArrayUtil.getAverage(arr2);
        System.out.println(avg);
    }
}
