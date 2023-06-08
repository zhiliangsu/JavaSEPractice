package com.hitech.day27_io1.p04file;

import java.io.File;

public class FileDemo1 {
    public static void main(String[] args) {
        /*
        public File(String pathname)                根据文件路径创建文件对象
        public File(String parent, String child)    根据父路径名字符串和子路径名字符串创建文件对象
        public File(File  parent, String child)     根据父路径对应文件对象和子路径名字符串创建文件对象

        C:\Users\szl\Desktop

        \:转义字符
        */
        String str = "C:\\Users\\szl\\Desktop\\a.txt";
        File f1 = new File(str);
        System.out.println(f1);

        String parent = "C:\\Users\\szl\\Desktop";
        String child = "a.txt";
        File f2 = new File(parent, child);
        System.out.println(f2);
        File f4 = new File(parent + "\\" + child);
        System.out.println(f4);

        File parent2 = new File("C:\\Users\\szl\\Desktop");
        File f3 = new File(parent2, child);
        System.out.println(f3);

    }
}
