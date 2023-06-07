package com.hitech.day26_map2.p03streamtest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test3 {
    public static void main(String[] args) {
        ArrayList<String> maleList = new ArrayList<>();
        ArrayList<String> femaleList = new ArrayList<>();

        Collections.addAll(maleList, "张三,23","张三丰,100","张无忌,24","张翠山,43","李四,24","王五,25");
        Collections.addAll(femaleList, "杨颖,23","杨珊珊,100","李思思,24","王语嫣,27","杨思琴,29","王五,25");

        List<String> list1 = maleList.stream()
                .filter(s -> s.split(",")[0].length() == 3)
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(list1);
        System.out.println("-----------------------------------------------");

        List<String> list2 = femaleList.stream()
                .filter(s -> s.split(",")[0].startsWith("杨"))
                .skip(1)
                .collect(Collectors.toList());

        System.out.println(list2);
        System.out.println("-----------------------------------------------");

        List<String> list3 = Stream.concat(list1.stream(), list2.stream()).toList();
        ArrayList<Actor> actors = new ArrayList<>();
        for (String s : list3) {
            Actor actor = new Actor(s.split(",")[0], Integer.parseInt(s.split(",")[1]));
            actors.add(actor);
        }
        System.out.println(actors);
    }
}
