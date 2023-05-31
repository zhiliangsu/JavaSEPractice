package com.hitech.day21_api4.p05test;

import java.util.Arrays;
import java.util.Comparator;

public class Test1 {
    public static void main(String[] args) {
        /*定义数组并存储一些女朋友对象，利用Arrays中的sort方法进行排序
        要求1：属性有姓名、年龄、身高。
        要求2：按照年龄的大小进行排序，年龄一样，按照身高排序，身高一样按照姓名的字母进行排序。
        (姓名中不要有中文或特殊字符，会涉及到后面的知识)*/

        // 1.创建女朋友对象并添加到数组中
        GirlFriend g1 = new GirlFriend("xiaoshishi", 18, 167);
        GirlFriend g2 = new GirlFriend("xiaodandan", 19, 172);
        GirlFriend g3 = new GirlFriend("xiaohuihui", 19, 178);
        GirlFriend g4 = new GirlFriend("abc", 19, 178);
        GirlFriend[] arr = {g1, g2, g3, g4};

        // 匿名内部类方式:
        /* Arrays.sort(arr, new Comparator<GirlFriend>() {
            @Override
            public int compare(GirlFriend o1, GirlFriend o2) {
                double temp = o1.getAge() - o2.getAge();
                temp = temp == 0 ? o1.getHeight() - o2.getHeight() : temp;
                temp = temp == 0 ? o1.getName().compareTo(o2.getName()) : temp;
                if (temp > 0) {
                    return 1;// 表示当前要插入的元素是大的，放在后面
                } else if (temp < 0) {
                    return -1;// 表示当前要/插入的元素是小的，放在前面
                } else {
                    return 0;// 表示当前要插入的元素跟现在的元素比是一样的们也会放在后面
                }
            }
        }); */

        // lambda表达式完整写法:
        /* Arrays.sort(arr, (GirlFriend o1, GirlFriend o2) -> {
                    double temp = o1.getAge() - o2.getAge();
                    temp = temp == 0 ? o1.getHeight() - o2.getHeight() : temp;
                    temp = temp == 0 ? o1.getName().compareTo(o2.getName()) : temp;
                    if (temp > 0) {
                        return 1;// 表示当前要插入的元素是大的，放在后面
                    } else if (temp < 0) {
                        return -1;// 表示当前要/插入的元素是小的，放在前面
                    } else {
                        return 0;// 表示当前要插入的元素跟现在的元素比是一样的们也会放在后面
                    }
                }
        ); */

        // lambda表达式省略写法:
        Arrays.sort(arr, (o1, o2) -> {
                    double temp = o1.getAge() - o2.getAge();
                    temp = temp == 0 ? o1.getHeight() - o2.getHeight() : temp;
                    temp = temp == 0 ? o1.getName().compareTo(o2.getName()) : temp;
                    if (temp > 0) {
                        return 1;// 表示当前要插入的元素是大的，放在后面
                    } else if (temp < 0) {
                        return -1;// 表示当前要/插入的元素是小的，放在前面
                    } else {
                        return 0;// 表示当前要插入的元素跟现在的元素比是一样的们也会放在后面
                    }
                }
        );

        //打印结果
        System.out.println(Arrays.toString(arr));
    }
}
