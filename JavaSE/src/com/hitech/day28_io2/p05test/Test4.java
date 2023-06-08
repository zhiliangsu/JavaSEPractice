package com.hitech.day28_io2.p05test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringJoiner;
import java.util.function.Function;

public class Test4 {
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

        // 2.排序
        Integer[] arr = Arrays.stream(sb.toString().split("-"))
                .map(Integer::parseInt)
                .sorted()
                .toArray(Integer[]::new);

        // 3.写出数据到文件
        FileWriter fw = new FileWriter("JavaSE\\src\\com\\hitech\\day28_io2\\a.txt");
        String s = Arrays.toString(arr).replace(", ", "-");
        String result = s.substring(1, s.length() - 1);
        fw.write(result);
        fw.close();
    }
}
