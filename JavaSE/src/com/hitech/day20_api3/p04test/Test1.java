package com.hitech.day20_api3.p04test;

import java.util.ArrayList;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        /*
            键盘录入一些1~100之间的整数，并添加到集合中。直到集合中所有数据和超过200为止。
        */

        // 1.创建集合存储数据
        ArrayList<Integer> list = new ArrayList<>();

        // 2.键盘录入数据添加到集合当中
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入一个整数: ");
            String numStr = sc.nextLine();
            int num = Integer.parseInt(numStr);
            // 先把异常数据进行过滤
            if (num < 0 || num > 100) {
                System.out.println("输入的数字不符合要求,请重新输入:");
                continue;
            }
            // 添加到集合中,添加数据的过程会出发自动装箱,因为num当前为int类型
            list.add(num);
            // 统计集合中的所有数据和
            int sum = getSum(list);
            if (sum > 200) {
                System.out.println("集合中所有数据的和已经超过200");
                break;
            }
        }
    }

    private static int getSum(ArrayList<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }
}
