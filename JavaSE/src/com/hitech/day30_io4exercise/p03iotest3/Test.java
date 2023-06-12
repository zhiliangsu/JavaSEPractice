package com.hitech.day30_io4exercise.p03iotest3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Test {
    public static void main(String[] args) throws IOException {
        /*需求：
            一个文件里面存储了班级同学的信息，格式为：张三-男-23
            每一个学生信息占一行。
            要求通过程序实现随机点名器。
            70%的概率随机到男生
            30%的概率随机到女生
            随机100万次，统计结果。看生成男生和女生的比例是不是接近于7：3
        */

        // 1.创建2个集合分别用于存储在文件中读取到的男学生和女学生数据
        ArrayList<String> maleList = new ArrayList<>();
        ArrayList<String> femaleList = new ArrayList<>();
        // 2.从文件中读取学生数据,并存放到集合中
        BufferedReader br = new BufferedReader(new FileReader("JavaSE\\src\\com\\hitech\\" +
                "day30_io4exercise\\p03iotest3\\names.txt"));

        String line;
        while ((line = br.readLine()) != null) {
            String[] arr = line.split("-");
            if ("男".equals(arr[1])) {
                maleList.add(line);
            } else {
                femaleList.add(line);
            }
        }
        br.close();

        /* // 解法2: 不定义权重集合
        Random r = new Random();
        int boyCount = 0;
        int girlCount = 0;

        // 5.循环100万次
        for (int i = 0; i < 1000000; i++) {
            // 从权重集合中获取随机数据
            int number = r.nextInt(10) + 1;
            // 判断获取的随机数据是1还是0
            if (number <= 7) {
                // 1就随机男生
                Collections.shuffle(maleList);
                System.out.println(maleList.get(0));
                boyCount++;
            } else {
                Collections.shuffle(femaleList);
                System.out.println(femaleList.get(0));
                girlCount++;
            }
        }
        System.out.println("随机抽取100万次，其中男生被抽到了" + boyCount);
        System.out.println("随机抽取100万次，其中女生被抽到了" + girlCount); */


        // 3.定义权重集合,男女比例7:3
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0);

        // 4.定义变量,统计被点到的次数
        Random r = new Random();
        int boyCount = 0;
        int girlCount = 0;

        // 5.循环100万次
        for (int i = 0; i < 1000000; i++) {
            // 从权重集合中获取随机数据
            int number = list.get(r.nextInt(list.size()));
            // 判断获取的随机数据是1还是0
            if (number == 1) {
                // 1就随机男生
                Collections.shuffle(maleList);
                System.out.println(maleList.get(0));
                boyCount++;
            } else {
                Collections.shuffle(femaleList);
                System.out.println(femaleList.get(0));
                girlCount++;
            }
        }
        System.out.println("随机抽取100万次，其中男生被抽到了" + boyCount);
        System.out.println("随机抽取100万次，其中女生被抽到了" + girlCount);
    }
}
