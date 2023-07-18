package com.hitech.part1.a03exercises;

import java.util.Random;

public class GenerateCode {
    public static void main(String[] args) {
        /*
        需求：
            定义方法实现随机产生一个5位的验证码
            验证码格式：
            长度为5
            前四位是大写字母或者小写字母
            最后一位是数字
         */

        // 1.定义一个字符数组,把大写字母和小写字母都放到其中
        char[] chars = new char[52];
        for (int i = 0; i < chars.length; i++) {
            if (i <= 25) {
                chars[i] = (char) (97 + i);
            } else {
                chars[i] = (char) (65 + i - 26);
            }
        }
        /* ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < 52; i++) {
            if (i <= 25) {
                list.add((char) ('a' + i));
            } else {
                list.add((char) ('A' + i - 26));
            }
        }
        System.out.println(list);*/
        // 2.随机在字符数组中抽取4次,并把结果拼接后放到一个字符串变量中
        Random r = new Random();
        String result = "";
        for (int i = 0; i < 4; i++) {
            int index = r.nextInt(chars.length);
            result = result + chars[index];
        }
        /* StrBuilder sb = new StrBuilder();
        for (int i = 0; i < 4; i++) {
            Collections.shuffle(list);
            sb.append(list.get(0));
        } */

        // 3.随机一个数字并拼接到结果中
        result = result + r.nextInt(10);
        // sb.append(r.nextInt(10));

        // 4.打印结果
        System.out.println(result);
        // System.out.println(sb);

    }
}
