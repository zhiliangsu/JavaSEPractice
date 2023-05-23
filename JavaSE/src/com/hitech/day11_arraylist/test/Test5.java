package com.hitech.day11_arraylist.test;

import java.util.ArrayList;
import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        // 1.创建集合
        ArrayList<Student> list = new ArrayList<>();

        // 2.键盘录入学生信息并添加到集合当中
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            Student s = new Student();
            System.out.println("请输入学生的姓名: ");
            String name = in.next();
            System.out.println("请输入学生的年龄: ");
            int age = in.nextInt();
            s.setName(name);
            s.setAge(age);

            // 添加到集合中
            list.add(s);
        }

        // 3.遍历集合
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            System.out.println(stu.getName() + ", " + stu.getAge());
        }
    }
}
