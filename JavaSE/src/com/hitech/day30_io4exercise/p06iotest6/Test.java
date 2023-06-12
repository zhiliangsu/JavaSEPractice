package com.hitech.day30_io4exercise.p06iotest6;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws IOException {

        // 1.把文件中所有的学生信息读取到内存中
        ArrayList<Student> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("JavaSE\\src\\com\\hitech\\day30_io4exercise" +
                "\\p06iotest6\\names.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] arr = line.split("-");
            Student stu = new Student(arr[0], arr[1], Integer.parseInt(arr[2]), Double.parseDouble(arr[3]));
            list.add(stu);
        }
        br.close();
        System.out.println(list);

        // 2.计算权重的总和
        double weight = 0;
        for (Student stu : list) {
            weight += stu.getWeight();
        }
        System.out.println("总权重: " + weight);

        // 3.计算每一个人的实际占比
        double[] arr = new double[list.size()];
        int index = 0;
        for (Student stu : list) {
            arr[index] = stu.getWeight() / weight;
            index++;
        }
        System.out.println("每一个人的实际权重占比: " + Arrays.toString(arr));

        // 4.计算每一个人的权重占比范围
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i] + arr[i - 1];
        }
        System.out.println("每一个人的权重占比范围: " + Arrays.toString(arr));

        // 5.随机抽取
        double number = Math.random();
        int result = -Arrays.binarySearch(arr, number) - 1;
        Student stu = list.get(result);
        System.out.println("当前抽取到的学生是: " + stu);

        // 6.修改当前学生的权重
        stu.setWeight(stu.getWeight() / 2);

        // 7.把集合中的数据再次写到文件中
        BufferedWriter bw = new BufferedWriter(new FileWriter("JavaSE\\src\\com\\hitech\\day30_io4exercise" +
                "\\p06iotest6\\names.txt"));
        for (Student s : list) {
            bw.write(s.toString());
            bw.newLine();
        }
        bw.close();
    }
}
