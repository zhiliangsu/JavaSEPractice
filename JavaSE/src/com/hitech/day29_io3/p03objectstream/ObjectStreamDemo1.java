package com.hitech.day29_io3.p03objectstream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectStreamDemo1 {
    public static void main(String[] args) throws IOException {
        /*
           需求：
                利用序列化流/对象操作输出流，把一个对象写到本地文件中

           构造方法：
                public ObjectOutputStream(OutputStream out)         把基本流变成高级流

           成员方法：
                public final void writeObject(Object obj)           把对象序列化（写出）到文件中去

        */

        Student stu = new Student("zhangsan", 23,"nanjing");
        ObjectOutputStream oos  = new ObjectOutputStream(new FileOutputStream("JavaSE\\src" +
                "\\com\\hitech\\day29_io3\\d.txt"));
        oos.writeObject(stu);
        oos.close();
    }
}
