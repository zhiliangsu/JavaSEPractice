package com.hitech.day25_pokergame.farmerandlord.src.com.itheima.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class CodeUtil {
    public static void main(String[] args) {
        System.out.println(getCode());
        System.out.println(getCode2());
        System.out.println(getCode3());
    }

    public static String getCode() {
        // 自己练习
        // 1.定义字符集合,并把a-zA-Z字符放进去
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add((char) ('a' + i));
            list.add((char) ('A' + i));
        }
        // 2.获取4个随机字母
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            int index = r.nextInt(list.size());
            sb.append(list.get(index));
        }

        // 3.获取一个随机数字
        int randomNumber = r.nextInt(10);
        sb.append(randomNumber);

        // 4.拿着随机索引对应的元素和最后一个索引对应的元素交换
        char[] charArr = sb.toString().toCharArray();
        int randomIndex = r.nextInt(charArr.length);
        char temp = charArr[randomIndex];
        charArr[randomIndex] = charArr[charArr.length - 1];
        charArr[charArr.length - 1] = temp;
        return new String(charArr);
    }

    public static String getCode2() {
        // 包含大小写A-Z和数字0-9，总长度为5，内容随机的，生成的结果不包含大小写字母o
        // 1.定义字符集合,并把a-zA-Z除了大小写o的字母放进去
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            char lowerCase = (char) ('a' + i);
            char upperCase = (char) ('A' + i);
            if (lowerCase == 'o' || upperCase == 'O') {
                continue;
            }
            list.add(lowerCase);
            list.add(upperCase);
        }
        // 2.获取4个随机字母
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            int index = r.nextInt(list.size());
            sb.append(list.get(index));
        }

        // 3.获取一个随机数字
        int randomNumber = r.nextInt(10);
        sb.append(randomNumber);

        // 4.拿着随机索引对应的元素和最后一个索引对应的元素交换
        char[] charArr = sb.toString().toCharArray();
        int randomIndex = r.nextInt(charArr.length);
        char temp = charArr[randomIndex];
        charArr[randomIndex] = charArr[charArr.length - 1];
        charArr[charArr.length - 1] = temp;
        return new String(charArr);
    }

    public static String getCode3() {
        // 包含大小写A-Z和数字0-9，总共长度为4或5，内容都是随机的，但是数字不能连续
        // 1.定义字符集合,并把a-zA-Z字符放进去
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            char lowerCase = (char) ('a' + i);
            char upperCase = (char) ('A' + i);
            char number = (char) ('0' + i);
            list.add(lowerCase);
            list.add(upperCase);
            if (i < 10) {
                list.add(number);
            }
        }
        // 2.获取4个随机字母
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            int index = r.nextInt(list.size());
            sb.append(list.get(index));
        }

        // 3.获取一个随机数字
        // int randomNumber = r.nextInt(10);
        // sb.append(randomNumber);

        // 4.拿着随机索引对应的元素和最后一个索引对应的元素交换
        char[] charArr = sb.toString().toCharArray();

        // int randomIndex = r.nextInt(charArr.length);
        // char temp = charArr[randomIndex];
        // charArr[randomIndex] = charArr[charArr.length - 1];
        // charArr[charArr.length - 1] = temp;
        return new String(charArr);
    }
}