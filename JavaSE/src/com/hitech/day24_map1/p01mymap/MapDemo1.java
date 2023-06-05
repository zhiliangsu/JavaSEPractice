package com.hitech.day24_map1.p01mymap;

import java.util.HashMap;
import java.util.Map;

public class MapDemo1 {
    public static void main(String[] args) {
        /*
            V put(K key,V value)                    添加元素
            V remove(Object key)                    根据键删除键值对元素
            void clear()                            移除所有的键值对元素
            boolean containsKey(Object key)         判断集合是否包含指定的键
            boolean containsValue(Object value)     判断集合是否包含指定的值
            boolean isEmpty()                       判断集合是否为空
            int size()                              集合的长度，也就是集合中键值对的个数
        */

        // 1.创建Map集合的对象
        Map<String, String> map = new HashMap<>();

        // 2.添加元素
        // put方法的细节：
        // 添加/覆盖
        // 在添加数据的时候，如果键不存在，那么直接把键值对对象添加到map集合当中,方法返回null
        // 在添加数据的时候，如果键是存在的，那么会把原有的键值对对象覆盖，会把被覆盖的值进行返回。
        System.out.println(map.put("郭靖", "黄蓉"));
        map.put("杨过", "小龙女");
        map.put("段誉", "王语嫣");
        System.out.println(map.put("段誉", "木婉清"));

        // 3.删除元素
        // map.remove("段誉");

        // 4.清空元素
        // map.clear();

        // 5.判断是否包含
        System.out.println(map.containsKey("杨过"));
        System.out.println(map.containsValue("小龙女"));

        // 6.判断是否为空
        System.out.println(map.isEmpty());

        // 7.集合的长度
        System.out.println(map.size());

        // 打印集合
        System.out.println(map);
    }
}
