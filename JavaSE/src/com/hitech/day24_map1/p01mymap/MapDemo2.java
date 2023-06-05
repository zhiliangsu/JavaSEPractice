package com.hitech.day24_map1.p01mymap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo2 {
    public static void main(String[] args) {

        // 1.创建集合的对象
        Map<String, String> map = new HashMap<>();

        // 2.添加元素
        map.put("杨过", "小龙女");
        map.put("郭靖", "黄蓉");
        map.put("张无忌", "赵敏");

        // 3.通过键找值
        Set<String> keys = map.keySet();

        // 3.1增强for遍历
        for (String key : keys) {
            System.out.println(key + "=" + map.get(key));
        }

        // 3.2迭代器遍历
        Iterator<String> it = keys.iterator();
        while (it.hasNext()) {
            String next = it.next();
            System.out.println(next + "=" + map.get(next));
        }

        // 3.3lambda表达式遍历
        keys.forEach(s -> System.out.println(s + "=" + map.get(s)));
    }
}
