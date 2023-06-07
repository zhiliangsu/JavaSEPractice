package com.hitech.day26_map2.p02stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamDemo2 {
    public static void main(String[] args) {
        /*
        单列集合      default Stream<E> stream()                           Collection中的默认方法
        双列集合      无                                                   无法直接使用stream流
        数组          public static <T> Stream<T> stream(T[] array)        Arrays工具类中的静态方法
        一堆零散数据   public static<T> Stream<T> of(T... values)           Stream接口中的静态方法
        */

        // 单列集合      default Stream<E> stream()                           Collection中的默认方法
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,2,3,4,5);

        Stream<Integer> stream = list.stream();
        stream.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        System.out.println("---------------------------");

        list.stream().forEach(s-> System.out.println(s));
    }
}
