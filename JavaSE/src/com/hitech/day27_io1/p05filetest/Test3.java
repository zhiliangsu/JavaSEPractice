package com.hitech.day27_io1.p05filetest;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class Test3 {
    public static void main(String[] args) {
       /* 需求：
        找到电脑中所有以avi结尾的电影。（需要考虑子文件夹）


        套路：
            1，进入文件夹
            2，遍历数组
            3，判断
            4，判断

        */
        File src = new File("C:\\Users\\szl\\Desktop");
        ArrayList<File> aviList = findAVI(src);
        System.out.println(aviList);
        // findAVI();


    }


    public static void findAVI() {
        File[] arr = File.listRoots();
        for (File file : arr) {
            findAVI(file);
        }
    }

    public static ArrayList<File> findAVI(File pathname) {
        ArrayList<File> fileList = new ArrayList<>();
        File[] files = pathname.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    fileList.addAll(findAVI(file));
                } else {
                    if (file.getName().endsWith(".avi")) {
                        fileList.add(file);
                        System.out.println(file);
                    }
                }
            }
        }
        return fileList;

    }
}
