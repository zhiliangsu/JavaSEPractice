package com.hitech.day27_io1.p04file;

import java.io.File;

public class FileDemo8 {
    public static void main(String[] args) {
        /*
        （掌握）public File[] listFiles()                获取当前该路径下所有内容
        public File[] listFiles(FileFilter filter)      利用文件名过滤器获取当前该路径下所有内容
        public File[] listFiles(FilenameFilter filter)  利用文件名过滤器获取当前该路径下所有内容
      */

        //1.创建File对象
        File f = new File("C:\\Users\\szl\\Desktop");
        File[] files = f.listFiles();
        for (File file : files) {
            if (file.isFile()&&file.getName().endsWith(".txt")) {
                System.out.println(file);
            }
        }
    }
}
