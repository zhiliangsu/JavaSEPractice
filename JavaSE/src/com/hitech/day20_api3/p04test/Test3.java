package com.hitech.day20_api3.p04test;

public class Test3 {
    public static void main(String[] args) {
        /*

            定义一个方法自己实现toBinaryString方法的效果，将一个十进制整数转成字符串表示的二进制

         */
        int num = 1234;
        System.out.println(toBinaryString(num));
        System.out.println(Integer.toBinaryString(num));
    }

    private static String toBinaryString(int num) {
        // 核心逻辑:
        // 不断的去除以2，得到余数，一直到商为0就结束。
        // 方法一:得到余数后,倒着拼接
        // 方法二:得到余数后,先顺着拼接,然后返回前通过reverse方法倒转

        // 定义一个StringBuilder用来拼接余数
        StringBuilder sb = new StringBuilder();
        // 利用循环不断地除以2获取余数
        while (true) {
            if (num == 0) {
                break;
            }
            // 获取余数
            int remainder = num % 2;
            sb.append(remainder);
            // sb.insert(0, remainder);//倒着拼接
            num /= 2;
        }

        return sb.reverse().toString();
        // return sb.toString();
    }
}
