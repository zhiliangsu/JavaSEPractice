package com.hitech.day24_map1.p02hashmap;

import java.util.*;

public class HashMapDemo2 {
    public static void main(String[] args) {
        /*
            某个班级80名学生，现在需要组成秋游活动，
            班长提供了四个景点依次是（A、B、C、D）,
            每个学生只能选择一个景点，请统计出最终哪个景点想去的人数最多。
        */

        // 1.模拟学生投票
        String[] arr = {"A", "B", "C", "D"};
        // 创建集合保存投票结果
        ArrayList<String> list = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 80; i++) {
            list.add(arr[r.nextInt(arr.length)]);
        }
        System.out.println(list);

        // 2.创建hashmap集合,添加元素
        // 如果要统计的东西比较多,不方便使用计数器思想,可以定义map集合,利用集合进行统计
        HashMap<String, Integer> hm = new HashMap<>();
        for (String name : list) {
            // 判断当前的景点在map集合当中是否存在
            if (hm.containsKey(name)) {
                // 存在
                int count = hm.get(name);// 先获取当前景点已经被投票的次数
                count++;// 表示当前景点又被投了一次
                hm.put(name, count);// 把新的次数再次添加到集合当中
            } else {
                // 不存在
                hm.put(name, 1);
            }
        }
        System.out.println(hm);

        // 3.遍历集合,确定投票次数最多的景点
        int max = 0;
        Set<Map.Entry<String, Integer>> entries = hm.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            int count = entry.getValue();
            if (count > max) {
                max = count;
            }
        }
        System.out.println(max);

        // 4.遍历集合,如果存在多个景点投票次数与max一样,打印出来
        for (Map.Entry<String, Integer> entry : entries) {
            Integer count = entry.getValue();
            if (count == max) {
                System.out.println(entry.getKey());
            }
        }
    }
}
