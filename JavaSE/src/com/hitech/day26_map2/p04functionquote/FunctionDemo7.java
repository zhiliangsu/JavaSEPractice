package com.hitech.day26_map2.p04functionquote;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FunctionDemo7 {
    public static void main(String[] args) {
        /*
        需求：
             集合中存储一些字符串的数据，比如：张三,23。
             收集到Student类型的数组当中
       */
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张三,23","李四,24","王五,25");

        Student[] arr = list.stream().map(Student::new).toArray(Student[]::new);
        System.out.println(Arrays.toString(arr));

    }
}
