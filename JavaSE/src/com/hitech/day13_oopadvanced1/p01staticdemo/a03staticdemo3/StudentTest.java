package com.hitech.day13_oopadvanced1.p01staticdemo.a03staticdemo3;

import java.util.ArrayList;

public class StudentTest {
    public static void main(String[] args) {
        //1.创建一个集合用来存储学生对象
        ArrayList<Student> list = new ArrayList<>();

        //2.创建学生对象
        Student s1 = new Student("zhangsan", 23, "female");
        Student s2 = new Student("lisi", 24, "female");
        Student s3 = new Student("wangwu", 25, "female");

        //3.把学生对象添加到集合中去
        list.add(s1);
        list.add(s2);
        list.add(s3);

        //4.调用工具类中的方法
        int maxAge = StudentUtil.getMaxAge(list);
        System.out.println(maxAge);
    }
}
