package com.hitech.day30_io4exercise.p02iotest2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Test {
    public static void main(String[] args) throws IOException {
        /*需求：
            需求：
                有一个文件里面存储了班级同学的信息，每一个信息占一行。
                格式为：张三-男-23
                要求通过程序实现随机点名器。

            运行效果：
                第一次运行程序：随机同学姓名1（只显示名字）
                第二次运行程序：随机同学姓名2（只显示名字）
                第三次运行程序：随机同学姓名3（只显示名字）
                …
         */

        // 1.创建集合用于存储在文件中读取到的学生数据
        ArrayList<String> list = new ArrayList<>();
        // 2.从文件中读取学生数据,并存放到集合中
        BufferedReader br = new BufferedReader(new FileReader("JavaSE\\src\\com\\hitech\\" +
                "day30_io4exercise\\p02iotest2\\names.txt"));

        String line;
        while ((line = br.readLine()) != null) {
            list.add(line.split("-")[0]);
        }
        br.close();
        // 3.打乱集合,随机抽取学生
        // 解法1:
        Collections.shuffle(list);
        System.out.println(list.get(0));

        // 解法2:
        // Random r = new Random();
        // int index = r.nextInt(list.size());
        // System.out.println(list.get(index));


    }
}
