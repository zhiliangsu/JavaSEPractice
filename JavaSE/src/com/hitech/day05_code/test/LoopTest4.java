package com.hitech.day05_code.test;

import java.util.Random;
import java.util.Scanner;

public class LoopTest4 {
    public static void main(String[] args) {
        /*
        需求：程序自动生成一个1-100之间的随机数，在代码中使用键盘录入去猜出这个数字是多少？
        要求：使用循环猜，一直猜中为止。
        思路分析：
            1. 生成一个1-100之间的随机数
            2. 使用键盘录入去猜出这个数字是多少
            3. 把反复猜的代码写在循环中
        */
        int count = 0;
        Scanner in = new Scanner(System.in);
        Random r = new Random();
        int number = r.nextInt(100) + 1;

        while (true) {
            System.out.println("请输入你要猜的数字：");
            int guessNumber = in.nextInt();
            count++;
            if (count == 3) {
                System.out.println("猜中了");
                break;
            }
            if (guessNumber > number) {
                System.out.println("大了");
            } else if (guessNumber < number) {
                System.out.println("小了");
            } else {
                System.out.println("猜中了");
                break;
            }
        }
    }
}
