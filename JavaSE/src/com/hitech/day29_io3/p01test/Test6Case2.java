package com.hitech.day29_io3.p01test;

import java.io.*;
import java.util.*;

public class Test6Case2 {
    public static void main(String[] args) throws IOException {
        /*
                需求：把《出师表》的文章顺序进行恢复到一个新文件中。
        */

        // 1.创建对象,读取数据
        BufferedReader br = new BufferedReader(new FileReader("JavaSE\\src" +
                "\\com\\hitech\\day29_io3\\csb.txt"));
        TreeMap<Integer, String> tm = new TreeMap<>();
        String line;
        while ((line = br.readLine()) != null) {
            tm.put(Integer.parseInt(line.substring(0,1)), line);
        }
        br.close();

        // 2.排序


        // 3.写出数据
        BufferedWriter bw = new BufferedWriter(new FileWriter("JavaSE\\src" +
                "\\com\\hitech\\day29_io3\\result.txt"));
        Set<Map.Entry<Integer, String>> entries = tm.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            bw.write(entry.getValue());
            bw.newLine();
        }
        bw.close();;
    }
}
