package com.hitech.day27_io1.p05filetest;

import java.io.File;
import java.io.IOException;

public class Test1 {
    public static void main(String[] args) throws IOException {
        // 需求：在当前模块下的aaa文件夹中创建一个a.txt文件

        // 1.创建a.txt文件的父级路径
        File file = new File("JavaSE\\src\\com\\hitech\\day27_io1\\aaa");
        // 2.创建父级目录
        // 如果aaa是存在的，那么此时创建失败的。
        // 如果aaa是不存在的，那么此时创建成功的。
        file.mkdirs();
        // 3.拼接父级路径和子级路径
        File src = new File(file, "a.txt");
        boolean b = src.createNewFile();
        if (b) {
            System.out.println("创建成功");
        } else {
            System.out.println("创建失败");
        }

    }
}
