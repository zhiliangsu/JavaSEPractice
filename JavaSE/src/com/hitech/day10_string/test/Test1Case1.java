package com.hitech.day10_string.test;

import java.util.Scanner;

public class Test1Case1 {
    public static void main(String[] args) {
        /* 键盘录入一个字符串，
        要求1：长度为小于等于9
        要求2：只能是数字
        将内容变成罗马数字
        下面是阿拉伯数字跟罗马数字的对比关系：
        Ⅰ－1、Ⅱ－2、Ⅲ－3、Ⅳ－4、Ⅴ－5、Ⅵ－6、Ⅶ－7、Ⅷ－8、Ⅸ－9
        注意点：
        罗马数字里面是没有0的
        如果键盘录入的数字包含0，可以变成""(长度为0的字符串)*/

        // 1.键盘录入一个字符串,并创建方法校验
        Scanner in = new Scanner(System.in);
        String str;
        while (true) {
            System.out.println("请输入一个字符串: ");
            str = in.next();
            boolean flag = checkStr(str);
            if (flag) {
                break;
            } else {
                System.out.println("当前字符串不符合规则, 请重新输入");
                // continue;
            }
        }

        // 将内容变成罗马数字
        // 下面是阿拉伯数字跟罗马数字的对比关系：
        // Ⅰ－1、Ⅱ－2、Ⅲ－3、Ⅳ－4、Ⅴ－5、Ⅵ－6、Ⅶ－7、Ⅷ－8、Ⅸ－9
        // 注意点：
        // 罗马数字里面是没有0的
        // 如果键盘录入的数字包含0，可以变成""(长度为0的字符串)
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int number = str.charAt(i) - 48;
            String s = checkLuoMa(number);
            sb.append(s);
        }

        //打印最终结果
        System.out.println(sb.toString());


    }

    public static String checkLuoMa(int number) {
        String[] arr = {"", "Ⅰ", "Ⅱ", "Ⅲ", "Ⅳ", "Ⅴ", "Ⅵ", "Ⅶ", "Ⅷ", "Ⅸ"};
        return arr[number];
    }

    public static boolean checkStr(String str) {
        // 要求1：长度为小于等于9
        if (str.length() > 9) {
            return false;
        }
        // 要求2：只能是数字
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}
