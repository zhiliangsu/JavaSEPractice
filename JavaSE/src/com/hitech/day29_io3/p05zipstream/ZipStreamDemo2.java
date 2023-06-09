package com.hitech.day29_io3.p05zipstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/*
 *   解压缩流
 *
 * */
public class ZipStreamDemo2 {
    /*
     *   压缩流
     *      需求：
     *          把D:\\a.txt打包成一个压缩包
     * */
    public static void main(String[] args) throws IOException {
        // 1.创建一个File表示要解压的压缩包
        File src = new File("JavaSE\\src\\com\\hitech\\day29_io3\\csb.txt");
        // 2.创建一个File表示解压的目的地
        File dst = new File("JavaSE\\src\\com\\hitech\\day29_io3\\");
        // 调用方法
        toZip(src, dst);

    }

    /*
     *   作用：压缩
     *   参数一：表示要压缩的文件
     *   参数二：表示压缩包的位置
     * */
    public static void toZip(File src, File dst) throws IOException {
        // 1.创建压缩流关联压缩包
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(new File(dst, "csb.zip")));
        // 2.创建ZipEntry对象，表示压缩包里面的每一个文件和文件夹
        // 参数：压缩包里面的路径
        ZipEntry entry = new ZipEntry("csb.txt");
        // 3.把ZipEntry对象放到压缩包当中
        zos.putNextEntry(entry);
        // 4.把src文件中的数据写到压缩包当中
        FileInputStream fis = new FileInputStream(src);
        int b;
        while ((b = fis.read()) != -1) {
            zos.write(b);
        }
        fis.close();
        zos.closeEntry();
        zos.close();
    }
}
