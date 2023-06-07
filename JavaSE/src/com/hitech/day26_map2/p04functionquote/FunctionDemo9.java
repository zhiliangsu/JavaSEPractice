package com.hitech.day26_map2.p04functionquote;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.IntFunction;

public class FunctionDemo9 {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("zhangsan", 23));
        list.add(new Student("lisi", 24));
        list.add(new Student("wangwu", 25));

        /* String[] arr1 = list.stream().map(new Function<Student, String>() {
            @Override
            public String apply(Student stu) {
                return stu.getName() + "-" + stu.getAge();
            }
        }).toArray(new IntFunction<String[]>() {
            @Override
            public String[] apply(int value) {
                return new String[value];
            }
        });
        System.out.println(Arrays.toString(arr1)); */

        String[] arr2 = list.stream().map( Student::stringJudge).toArray(String[]::new);
        String[] arr3 = list.stream().map(new Student()::stringJudge).toArray(String[]::new);
        String[] arr4 = list.stream().map(new FunctionDemo9()::stringJudge).toArray(String[]::new);
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(arr4));
    }
    public String stringJudge(Student stu) {
        return stu.getName() + "-" + stu.getAge();
    }
}
