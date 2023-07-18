package com.hitech.day10_string.test;

public class Test5 {
    public static void main(String[] args) {
        /* 给定两个以字符串形式表示的非负整数num1和num2，返回num1和num2的乘积，它们的乘积也表示为字符串形式。
        注意：需要用已有的知识完成。*/

        // 不需要考虑乘积过大之后的结果
        // 就认为乘积一定是小于int的最大值的


        String num1 = "12345";
        String num2 = "12345";

        // 1.把num1和num2变成对应的整数才可以
        //"123456789"
        // 先遍历字符串依次得到每一个字符 '1'  '2'  '3'  '4'  '5'  '6'  '7'  '8'  '9'
        // 再把字符变成对应的数字即可     1    2    3     4    5    6    7    8    9
        // 把每一个数字组合到一起 123456789
        int intNum1 = getInt(num1.toCharArray());
        int intNum2 = getInt(num2.toCharArray());

        System.out.println(intNum1);
        System.out.println(intNum2);
        // 2.利用整数进行相乘
        int result = intNum1 * intNum2;

        // 3.可以把整数变成字符串
        //+""
        System.out.println(result + "");
    }

    private static int getInt(char[] chars) {
        int result1 = 0;
        for (int i = 0; i < chars.length; i++) {
            int num = chars[i] - '0';
            result1 = result1 * 10 + num;
        }
        return result1;
    }


}
