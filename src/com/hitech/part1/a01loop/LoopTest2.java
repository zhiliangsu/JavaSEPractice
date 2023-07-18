package com.hitech.part1.a01loop;

public class LoopTest2 {
    public static void main(String[] args) {
        /*需求：给定两个整数，被除数和除数（都是整数，且不超过int的范围）。
        将两数相除，要求不使用乘法、除法和%运算符。
        得到商和余数。

        分析：
            被除数 / 除数 = 商 ... 余数
         */
        int dividend = 24;
        int divisor = 3;
        int count = 0;
        while (dividend >= divisor) {
            dividend = dividend - divisor;
            count++;
        }
        System.out.println("商为: " + count + ", 余数为: " + dividend);
    }
}
