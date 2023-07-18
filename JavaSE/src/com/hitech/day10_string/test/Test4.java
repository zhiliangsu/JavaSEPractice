package com.hitech.day10_string.test;

import java.util.Random;

public class Test4 {
    public static void main(String[] args) {
        /*
        生成验证码
        内容：可以是小写字母，也可以是大写字母，还可以是数字
        规则：
        长度为5
        内容中是四位字母，1位数字。
        其中数字只有1位，但是可以出现在任意的位置。*/


        // 1.可以把所有的大写字母，小写字母都放到一个数组当中
        char[] arr = new char[52];
        // a-z  A-Z
        for (int i = 0; i < arr.length; i++) {
            if (i < 26) {
                arr[i] = (char) ('a' + i);
            } else {
                arr[i] = (char) ('A' + i - 26);
            }
        }

        // 2.从数组中随机获取4次
        Random r = new Random();
        String result = "";
        for (int i = 0; i < 4; i++) {
            int index = r.nextInt(arr.length);
            result = result + arr[index];
        }

        // 3.生成一个0~9之间的随机数拼接到最后
        // ACFG7
        // 思考，我们把7放到前面，修改了字符串的内容
        // 把生成的验证码先变成一个字符数组
        // 再让最后一个元素跟前面的随机位置的元素进行交换
        // 交换完毕之后再变成字符串就可以了。
        char[] resultArr = (result + r.nextInt(10)).toCharArray();
        for (int i = 0; i < resultArr.length; i++) {
            char temp = resultArr[resultArr.length - 1];
            int randonIndex = r.nextInt(resultArr.length);
            resultArr[resultArr.length - 1] = resultArr[randonIndex];
            resultArr[randonIndex] = temp;
        }
        System.out.println(new String(resultArr));
    }
}
