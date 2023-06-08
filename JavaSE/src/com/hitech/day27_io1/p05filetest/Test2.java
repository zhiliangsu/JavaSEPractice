package com.hitech.day27_io1.p05filetest;

import java.io.File;

public class Test2 {
    public static void main(String[] args) {
        /*需求：
             定义一个方法找某一个文件夹中，是否有以avi结尾的电影。
            （暂时不需要考虑子文件夹）
        */

        File src = new File("C:\\Users\\szl\\Desktop");
        System.out.println(haveAVI(src));
    }

    /*
     * 作用：用来找某一个文件夹中，是否有以avi结尾的电影
     * 形参：要查找的文件夹
     * 返回值：查找的结果  存在true  不存在false
     * */
    public static boolean haveAVI(File pathname) {
        // 1.进入aaa文件夹，而且要获取里面所有的内容
        File[] files = pathname.listFiles();
        // 2.遍历数组获取里面的每一个元素
        for (File file : files) {
            // file：依次表示aaa文件夹里面每一个文件或者文件夹的路径
            if (file.isFile() && file.getName().endsWith(".avi")) {
                return true;
            }
        }
        // 3.如果循环结束之后还没有找到，直接返回false
        return false;
    }

}
