package com.hitech.day19_api2.regexdemo;

public class demo4 {
    public static void main(String[] args) {
        /*
            需求
            请编写正则表达式验证用户输入的手机号码是否满足要求。请编写正则表达式验证用户输入的邮箱号是否满足要求。请编写正则表达式验证用户输入的电话号码是否满足要求。
            验证手机号码 13112345678 13712345667 13945679027 139456790271
            验证座机电话号码 020-2324242 02122442 027-42424 0712-3242434
            验证邮箱号码 3232323@qq.com zhangsan@itcast.cnn dlei0009@163.com dlei0009@pci.com.cn
        */
        String regex1 = "1[3-9]\\d{9}";
        System.out.println("13112345678".matches(regex1));
        System.out.println("13712345667".matches(regex1));
        System.out.println("13945679027".matches(regex1));
        System.out.println("139456790271".matches(regex1));
        System.out.println("-------------------------------------");

        String regex2 = "0\\d{2,3}-?[1-9]{4,9}";
        System.out.println("020-2324242".matches(regex2));
        System.out.println("02122442".matches(regex2));
        System.out.println("027-42424".matches(regex2));
        System.out.println("0712-3242434".matches(regex2));
        System.out.println("-------------------------------------");

        String regex3 = "\\w+@[\\w&&[^_]]{2,6}(\\.[a-zA-Z]{2,3}){1,2}";
        System.out.println("3232323@qq.com".matches(regex3));
        System.out.println("zhangsan@itcast.cnn".matches(regex3));
        System.out.println("dlei0009@163.com".matches(regex3));
        System.out.println("dlei0009@pci.com.cn".matches(regex3));
        System.out.println("-------------------------------------");

        //24小时的正则表达式
        String regex4 = "([01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d";
        String regex5 = "([01]\\d|2[0-3])(:[0-5]\\d){2}";
        System.out.println("23:11:11".matches(regex4));
        System.out.println("23:11:11".matches(regex5));
    }
}
