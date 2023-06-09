package com.hitech.day29_io3.p01test;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Test6Case1 {
    public static void main(String[] args) throws IOException {
        /*
                需求：把《出师表》的文章顺序进行恢复到一个新文件中。
        */

        // 1.创建对象,读取数据
        BufferedReader br = new BufferedReader(new FileReader("JavaSE\\src" +
                "\\com\\hitech\\day29_io3\\csb.txt"));
        ArrayList<String> list = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            list.add(line);
        }
        br.close();

        // 2.排序
        Collections.sort(list, (o1, o2) -> {
            int i1 = Integer.parseInt(o1.substring(0, 1));
            int i2 = Integer.parseInt(o2.substring(0, 1));
            return i1 - i2;
        });

        // 3.写出数据
        BufferedWriter bw = new BufferedWriter(new FileWriter("JavaSE\\src" +
                "\\com\\hitech\\day29_io3\\result.txt"));
        for (String str : list) {
            bw.write(str);
            bw.newLine();
        }
        bw.close();;

    }
}
