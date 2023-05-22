package com.hitech.day10_string.test;

public class Test2Case1 {
    public static void main(String[] args) {
        /* 给定两个字符串, A和B。
        A的旋转操作就是将A 最左边的字符移动到最右边。
        例如, 若A = 'abcde'，在移动一次之后结果就是'bcdea'
        如果在若干次调整操作之后，A能变成B，那么返回True。
        如果不能匹配成功，则返回false*/

        // 1.定义两个字符串
        String strA = "abcde";
        String strB = "cdeab";

        // 2.调用方法进行比较
        boolean result = compare(strA, strB);

        // 3.输出结果
        System.out.println(result);

    }

    public static boolean compare(String strA, String strB) {
        for (int i = 0; i < strA.length(); i++) {
            strA = rotate(strA);
            if (strA.equals(strB)) {
                return true;
            }
        }
        return false;
    }

    public static String rotate(String str) {
        // 套路:
        // 如果我们看到要修改字符串的内容,可以有两个办法:
        // 1.用subString进行截取,把左边的字符截取出来拼接到右侧去
        // 2.可以把字符串先变成一个字符数组,然后调整字符数组里的数据,最后再把字符数组变成字符串.
        char first = str.charAt(0);
        String end = str.substring(1);
        return end + first;
    }
}
