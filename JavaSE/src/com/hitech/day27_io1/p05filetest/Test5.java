package com.hitech.day27_io1.p05filetest;

import java.io.File;

public class Test5 {
    public static void main(String[] args) {
       /*需求：
            统计一个文件夹的总大小
      */

        File src = new File("C:\\Users\\szl\\Desktop\\src");
        System.out.println(getLen(src));


    }

    public static long getLen(File pathname) {
        long len = 0;
        File[] files = pathname.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    len += file.length();
                } else {
                    len += getLen(file);
                }
            }
        }
        return len;
    }


}
