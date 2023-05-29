package com.hitech.day20_api3.p01jdk7datedemo;

import java.util.Date;
import java.util.Random;

public class demo2 {
    public static void main(String[] args) {
        /*
        需求1:打印时间原点开始一年之后的时间
        需求2:定义任意两个Date对象，比较一下哪个时间在前，哪个时间在后
        */

        // 需求2:定义任意两个Date对象，比较一下哪个时间在前，哪个时间在后
        Random r = new Random();
        Date d1 = new Date(Math.abs(r.nextInt()));
        Date d2 = new Date(Math.abs(r.nextInt()));
        long time1 = d1.getTime();
        long time2 = d2.getTime();
        if (time1 > time2) {
            System.out.println("第一个时间在后面,第二个时间在前面");
        } else if (time1 < time2) {
            System.out.println("第二个时间在后面,第一个时间在见面");
        } else {
            System.out.println("表示两个时间一样");
        }
    }

    private static void extracted() {
        // 需求1:打印时间原点开始一年之后的时间
        Date d1 = new Date(0L);
        long time = d1.getTime();
        time = time + 1000L * 60 * 60 * 24 * 365;
        d1.setTime(time);
        System.out.println(d1);
    }
}
