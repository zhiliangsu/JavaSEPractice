package com.hitech.day10_string.stringdemo;

public class StringDemo10 {
    public static void main(String[] args) {
        //字符串替换

        //1.获取到说的话
        String  talk = "你玩的真好，以后不要再玩了，TMD，SB";
        //2.定义一个敏感词库
        String[] arr = {"TMD", "CNM", "SB", "MLGB"};
        //3.遍历敏感词库，并依次进行替换
        for (int i = 0; i < arr.length; i++) {
            talk = talk.replace(arr[i], "***");
        }
        //4.打印结果
        System.out.println(talk);

    }
}
