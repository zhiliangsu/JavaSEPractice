package com.hitech.day30_io4exercise.p05iotest5;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Test {
    public static void main(String[] args) throws IOException {
        /*需求：
            一个文件里面存储了班级同学的姓名，每一个姓名占一行。
            要求通过程序实现随机点名器。
            第三次必定是张三同学

          运行效果：
            第一次运行程序：随机同学姓名1
            第二次运行程序：随机同学姓名2
            第三次运行程序：张三
            …
        */

        // 1.创建集合用于存储在文件中读取到的学生数据
        ArrayList<String> list = new ArrayList<>();
        // 2.从文件中读取学生数据,并存放到集合中
        BufferedReader br1 = new BufferedReader(new FileReader("JavaSE\\src\\com\\hitech\\" +
                "day30_io4exercise\\p04iotest4\\names.txt"));
        String line;
        while ((line = br1.readLine()) != null) {
            list.add(line.split("-")[0]);
        }
        br1.close();

        // 3.从文件中读取当前程序已运行次数
        BufferedReader br2 = new BufferedReader(new FileReader("JavaSE\\src\\com\\hitech\\" +
                "day30_io4exercise\\p04iotest4\\count.txt"));
        int count = Integer.parseInt(br2.readLine());
        br2.close();

        // 4.表示当前程序又运行了一次
        count++;

        // 5.打乱集合,随机抽取学生
        if (count == 3) {
            System.out.println("第3次点名: 张三");
        } else {
            Collections.shuffle(list);
            System.out.println("第" + count + "次点名: " + list.get(0));
        }

        // 6.把程序已经运行的次数重新写会本地文件
        BufferedWriter bw = new BufferedWriter(new FileWriter("JavaSE\\src\\com\\hitech\\" +
                "day30_io4exercise\\p04iotest4\\count.txt"));
        bw.write(count + "");
        bw.close();
    }
}
