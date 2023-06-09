package com.hitech.day29_io3.p02convertstream;

import java.io.*;
import java.nio.charset.Charset;

public class ConvertStreamDemo3 {
    public static void main(String[] args) throws IOException {
        /*
            利用转换流按照指定字符编码写出
        */

        //1.JDK11以前的方案
        /* InputStreamReader isr = new InputStreamReader(new FileInputStream("JavaSE\\src\\com\\hitech\\day29_io3\\gbkfile.txt"), "GBK");
        OutputStreamWriter osr = new OutputStreamWriter(new FileOutputStream("JavaSE\\src\\com\\hitech\\day29_io3\\c.txt"), "UTF-8");
        int ch;
        while ((ch = isr.read()) != -1) {
            osr.write(ch);
        }
        osr.close();
        isr.close();
        */

        //2.替代方案
        FileReader fr = new FileReader("JavaSE\\\\src\\\\com\\\\hitech\\\\day29_io3\\\\gbkfile.txt",Charset.forName("GBK"));
        FileWriter fw = new FileWriter("JavaSE\\src\\com\\hitech\\day29_io3\\b.txt",Charset.forName("UTF-8"));
        int b;
        while ((b = fr.read()) != -1) {
            fw.write(b);
        }
        fw.close();
        fr.close();
    }
}
