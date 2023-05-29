package com.hitech.day20_api3.p04test;

import java.time.LocalDate;
import java.util.Calendar;

public class Test5 {
    public static void main(String[] args) {
        /*
            判断任意的一个年份是闰年还是平年要求:用JDK7和JDK8两种方式判断
            提示:
            二月有29天是闰年
            一年有366天是闰年
        */

        // JDK7
        // 思路一:
        Calendar c1 = Calendar.getInstance();
        // 月份的范围:0~11
        // 再把日历往前减一天
        c1.set(1993, Calendar.MARCH, 1);
        c1.add(Calendar.DAY_OF_MONTH, -1);
        // 看当前的时间是28号还是29号?
        int day1 = c1.get(Calendar.DAY_OF_MONTH);
        System.out.println(day1);

        // 思路二:
        Calendar c2 = Calendar.getInstance();
        // 再把日历往前减一天
        c2.set(1994, Calendar.JANUARY, 1);
        c2.add(Calendar.DAY_OF_MONTH, -1);
        // 看当前的时间是第365天还是第366天
        int day2 = c2.get(Calendar.DAY_OF_YEAR);
        System.out.println(day2);


        // JDK8
        // 月份的范围:1~12
        LocalDate ld = LocalDate.of(1993, 3, 1);
        // 把时间往前减一天
        LocalDate ld2 = ld.minusDays(1);
        // 获取这一天是一个月中的几号
        int day3 = ld2.getDayOfMonth();
        System.out.println(day3);

        // true:闰年
        // false:平年
        System.out.println(ld.isLeapYear());
    }
}
