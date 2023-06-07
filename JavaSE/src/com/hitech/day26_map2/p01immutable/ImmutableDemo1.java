package com.hitech.day26_map2.p01immutable;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ImmutableDemo1 {
    public static void main(String[] args) {
        /*
            创建不可变的List集合
            "张三", "李四", "王五", "赵六"
        */

        //一旦创建完毕之后，是无法进行修改的，在下面的代码中，只能进行查询操作
        List<String> list = List.of("张三", "李四", "王五", "赵六");

        //查询
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));

        //遍历
        System.out.println("----------------------------");
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("----------------------------");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("----------------------------");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("----------------------------");
        ListIterator<String> lit = list.listIterator();
        while (lit.hasNext()) {
            System.out.println(lit.next());
        }
        System.out.println("----------------------------");
        list.forEach(s -> System.out.println(s));
        System.out.println("----------------------------");

        // list.remove("李四");
        // list.add("aaa");
        // list.set(0, "aaa");
    }
}
