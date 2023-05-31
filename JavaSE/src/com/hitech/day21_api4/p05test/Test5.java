package com.hitech.day21_api4.p05test;

public class Test5 {
    public static void main(String[] args) {
        /*
            可爱的小明特别喜欢爬楼梯，他有的时候一次爬一个台阶，有的时候一次爬两个台阶,有的时候一次爬三个台阶
            如果这个楼梯有20个台阶，小明一共有多少种爬法呢？

            课堂练习:
        */

        System.out.println(getCount(3));

    }

    public static int getCount(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        return getCount(n - 1) + getCount(n - 2) + getCount(n - 3);
    }
}
