package com.hitech.day10_string.stringdemo;

public class StringDemo9 {
    public static void main(String[] args) {
        //身份证信息查看

        //1.定义一个字符串记录身份证号码信息
        String id = "445302199212093015";

        //2.获取出生年月日并打印
        String year = id.substring(6, 10);
        String month = id.substring(10, 12);
        String day = id.substring(12, 14);
        System.out.println("人物信息为：");
        System.out.println("出生年月日为：" + year + "年" + month + "月" + day + "日");

        //3.获取性别信息并打印
        char gender = id.charAt(id.length() - 2);
        int num = gender - 48;
        if (num % 2 == 0) {
            System.out.println("性别为：女");
        } else {
            System.out.println("性别为：男");
        }
    }
}
