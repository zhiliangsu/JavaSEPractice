package com.hitech.day13_oopadvanced1.staticdemo.a01staticdemo1;

public class StudentTest {
    public static void main(String[] args) {
        Student.teacherName = "阿伟老师";
        Student s1 = new Student();
        s1.setName("zhangsan");
        s1.setAge(23);
        s1.setGender("male");
        s1.study();
        s1.show();

        Student s2 = new Student();
        s2.setName("lisi");
        s2.setAge(24);
        s2.setGender("female");
        s2.study();
        s2.show();
    }
}
