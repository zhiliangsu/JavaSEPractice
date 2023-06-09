package com.hitech.day29_io3.p02convertstream;

import java.io.*;
import java.nio.charset.Charset;

public class ConvertStreamDemo2 {
    public static void main(String[] args) throws IOException {
        /*
            利用转换流按照指定字符编码写出
        */

        /* OutputStreamWriter osr = new OutputStreamWriter(new FileOutputStream("JavaSE\\src\\com\\hitech\\day29_io3\\a.txt"), "GBK");
        osr.write("你很好你好");
        osr.close(); */

        FileWriter fw = new FileWriter("JavaSE\\src\\com\\hitech\\day29_io3\\b.txt",Charset.forName("GBK"));
        fw.write("你很好你好");
        fw.close();
    }
}
