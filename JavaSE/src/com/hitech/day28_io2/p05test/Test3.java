package com.hitech.day28_io2.p05test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Test3 {
    public static void main(String[] args) throws IOException {
        /*
            文本文件中有以下的数据：
                2-1-9-4-7-8
            将文件中的数据进行排序，变成以下的数据：
                1-2-4-7-8-9
        */

        // 1.创建对象,获取数据
        FileReader fr = new FileReader("JavaSE\\src\\com\\hitech\\day28_io2\\a.txt");
        StringBuilder sb = new StringBuilder();
        int b;
        while ((b = fr.read()) != -1) {
            sb.append((char) b);
        }
        fr.close();
        System.out.println(sb);


        // 2.排序
        String[] arrStr = sb.toString().split("-");
        ArrayList<Integer> list = new ArrayList<>();
        for (String s : arrStr) {
            list.add(Integer.parseInt(s));
        }
        Collections.sort(list);
        System.out.println(list);

        // 3.写出数据到文件
        FileWriter fw = new FileWriter("JavaSE\\src\\com\\hitech\\day28_io2\\a.txt");
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                fw.write(list.get(i) + "");
            } else {
                fw.write(list.get(i) + "-");
            }
        }
        fw.close();
    }
}
