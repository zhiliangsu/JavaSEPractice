package com.hitech.day24_map1.p04treemap;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapDemo1 {
    public static void main(String[] args) {
        /*
           TreeMap集合：基本应用
            需求1：
                键：整数表示id
	            值：字符串表示商品名称
	            要求1：按照id的升序排列
	            要求2：按照id的降序排列
         */

        // 1.创建集合对象
        //Integer Double 默认情况下都是按照升序排列的
        //String 按照字母再ASCII码表中对应的数字升序进行排列
        //abcdefg ...
        TreeMap<Integer, String> tm = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //o1:当前要添加的元素
                //o2：表示已经在红黑树中存在的元素
                return o2 - o1;
            }
        });

        // 2.添加元素
        tm.put(5, "egg");
        tm.put(4, "dog");
        tm.put(3, "cat");
        tm.put(2, "boy");
        tm.put(1, "apple");

        // 3.打印集合
        System.out.println(tm);
    }
}
