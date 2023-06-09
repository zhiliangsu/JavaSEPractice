package com.hitech.day29_io3.p01test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class Test8 {
    public static void main(String[] args) throws IOException {
        /*需求：
            将多个自定义对象序列化到文件中，但是对象的个数不确定，该如何操作呢？
        */

        Student s1 = new Student("zhangsan", 23, "nanjing");
        Student s2 = new Student("lisi", 24, "shenzhen");
        Student s3 = new Student("wangwu", 25, "beijing");

        ArrayList<Student> list = new ArrayList<>();
        Collections.addAll(list, s1, s2, s3);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("JavaSE\\src" +
                "\\com\\hitech\\day29_io3\\e.txt"));
        oos.writeObject(list);
        oos.close();
    }
}
