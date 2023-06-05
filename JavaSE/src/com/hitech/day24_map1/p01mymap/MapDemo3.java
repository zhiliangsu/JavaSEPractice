package com.hitech.day24_map1.p01mymap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo3 {
    public static void main(String[] args) {

        // 1.创建集合的对象
        Map<String, String> map = new HashMap<>();

        // 2.添加元素
        map.put("杨过", "小龙女");
        map.put("郭靖", "黄蓉");
        map.put("张无忌", "赵敏");

        // 3.通过键值对
        Set<Map.Entry<String, String>> entries = map.entrySet();

        // 3.1增强for遍历
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

        // 3.2迭代器遍历
        Iterator<Map.Entry<String, String>> it = entries.iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            System.out.println(next.getKey() + "=" + next.getValue());
        }

        // 3.3lambda表达式遍历
        entries.forEach(s -> System.out.println(s.getKey() + "=" + s.getValue()));
    }
}
