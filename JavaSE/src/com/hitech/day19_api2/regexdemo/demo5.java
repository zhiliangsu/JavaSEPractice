package com.hitech.day19_api2.regexdemo;

public class demo5 {
    public static void main(String[] args) {
        /*
            正则表达式练习:
            需求
            请编写正则表达式验证用户名是否满足要求。要求:大小写字母，数字，下划线一共4-16位
            请编写正则表达式验证身份证号码是否满足要求。
            简单要求:18位，前17位任意数字，最后一位可以是数字可以是大写或小写的x复杂要求:按照身份证号码的格式严格要求。

            身份证号码:
            41080119930228457x
            510801197609022309
            15040119810705387X
            130133197204039024 I
            430102197606046442
        */
        // 用户名校验
        String usernameRegex = "\\w{4,16}";
        System.out.println("zhangsan".matches(usernameRegex));
        System.out.println("lisi".matches(usernameRegex));
        System.out.println("wangwu".matches(usernameRegex));
        System.out.println("$123".matches(usernameRegex));
        System.out.println("------------------------------");

        // 身份证号码简单校验
        String personIDRegex1 = "[1-9]\\d{16}[\\dXx]";
        String personIDRegex2 = "[1-9]\\d{16}(\\d|(?i)x)";
        String personIDRegex3 = "[1-9]\\d{16}(\\d|X|x)";
        System.out.println("41080119930228457x".matches(personIDRegex3));
        System.out.println("510801197609022309".matches(personIDRegex3));
        System.out.println("15040119810705387X".matches(personIDRegex3));
        System.out.println("130133197204039024".matches(personIDRegex3));
        System.out.println("430102197606046442".matches(personIDRegex3));
        System.out.println("------------------------------");

        // 忽略大小写的书写方式
        // 在匹配的时候忽略abc的大小写
        String regex4 = "a((?i)b)c";
        System.out.println("abc".matches(regex4));// true
        System.out.println("ABC".matches(regex4));// false
        System.out.println("aBc".matches(regex4));// true
        System.out.println("------------------------------");

        //身份证号码严格校验
        //410801 1993 02 28 457x
        String personIDRegex4 = "[1-9]\\d{5}(18|19|20)\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])\\d{3}[\\dXx]";
        String personIDRegex5 = "[1-9]\\d{5}(18|19|20)\\d{2}(0\\d|10|11|12)(0[1-9]|[1-2]\\d|30|31)\\d{3}[\\dXx]";
        System.out.println("41080119930228457x".matches(personIDRegex5));
        System.out.println("510801197609022309".matches(personIDRegex5));
        System.out.println("15040119810705387X".matches(personIDRegex5));
        System.out.println("130133197204039024".matches(personIDRegex5));
        System.out.println("430102197606046442".matches(personIDRegex5));

    }
}
