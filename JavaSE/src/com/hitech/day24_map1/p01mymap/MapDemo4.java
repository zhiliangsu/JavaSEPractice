package com.hitech.day24_map1.p01mymap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class MapDemo4 {
    public static void main(String[] args) {

        // 1.创建集合的对象
        Map<String, String> map = new HashMap<>();

        // 2.添加元素
        map.put("杨过", "小龙女");
        map.put("郭靖", "黄蓉");
        map.put("张无忌", "赵敏");

        // 3.通过lambda
        /* map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String key, String value) {
                System.out.println(key + "=" + value);
            }
        }); */

        map.forEach((key, value) -> System.out.println(key + "=" + value));
    }
}
