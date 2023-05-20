package com.hitech.day07_exercise.test;

import java.util.Random;

public class Test3 {
    public static void main(String[] args) {
        /*
        需求：
            定义方法实现随机产生一个5位的验证码
            验证码格式：
            长度为5
            前四位是大写字母或者小写字母
            最后一位是数字
         */

        //1.定义一个字符数组，把大写字母和小写字母都放到数组中
        char[] chs = new char[52];
        for (int i = 0; i < chs.length; i++) {
            if (i <= 25) {
                chs[i] = (char) (97 + i);
            } else {
                chs[i] = (char) (65 + i - 26);
            }
        }

        //2.随机在字符数组中抽取四次，并把结果拼接后放到一个字符串变量中
        Random r = new Random();
        String result = "";
        for (int i = 0; i < 4; i++) {
            int randomIndex = r.nextInt(chs.length);
            result = result + chs[randomIndex];
        }

        //3.随机一个数字并拼接到结果中
        int number = r.nextInt(10);
        result += number;

        System.out.println(result);
    }
}
