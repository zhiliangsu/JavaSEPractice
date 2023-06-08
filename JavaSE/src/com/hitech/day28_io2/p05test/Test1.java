package com.hitech.day28_io2.p05test;

import java.io.*;

public class Test1 {
    public static void main(String[] args) throws IOException {
        // 拷贝一个文件夹，考虑子文件夹
        // 1.创建对象表示数据源
        File src = new File("C:\\Users\\szl\\Desktop\\src");
        // 2.创建对象表示目的地
        File dst = new File("C:\\Users\\szl\\Desktop\\dst");
        // 3.调用方法开始拷贝
        copydir(src, dst);
    }

    /*
     * 作用：拷贝文件夹
     * 参数一：数据源
     * 参数二：目的地
     *
     * */
    public static void copydir(File src, File dst) throws IOException {
        dst.mkdirs();
        //递归
        //1.进入数据源
        File[] files = src.listFiles();

        if (files != null) {
            //2.遍历数组
            for (File file : files) {
                if (file.isFile()) {
                    //3.判断文件，拷贝
                    FileInputStream fis = new FileInputStream(file);
                    FileOutputStream fos = new FileOutputStream(new File(dst, file.getName()));
                    int len;
                    byte[] bytes = new byte[1024 * 8];
                    while ((len = fis.read(bytes)) != -1) {
                        fos.write(bytes, 0, len);
                    }
                    fos.close();
                    fis.close();
                } else {
                    //4.判断文件夹，递归
                    copydir(file, new File(dst, file.getName()));
                }
            }
        }
    }
}
