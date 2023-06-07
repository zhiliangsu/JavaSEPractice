package com.hitech.day26_map2.p02stream;

import java.util.HashMap;

public class StreamDemo3 {
    public static void main(String[] args) {
        // 双列集合      无                                                   无法直接使用stream流

        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("aaa", 111);
        hm.put("bbb", 222);
        hm.put("ccc", 333);

        hm.keySet().stream().forEach(s -> System.out.println(s));
        hm.entrySet().stream().forEach(s-> System.out.println(s));
    }
}
