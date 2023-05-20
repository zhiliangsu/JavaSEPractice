package com.hitech.day07_exercise.lottery;

import java.util.Random;
import java.util.Scanner;

public class Test11 {
    public static void main(String[] args) {
        //1.随机生成中奖号码
        int[] arr = createNumber();
        System.out.println("=========================");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("=========================");

        //2.用户输入彩票号码
        int[] userInputArr = userInputNumber();

        //3.判断用户的中奖情况
        //初始化红球和蓝球计数器
        int redCount = 0;
        int blueCount = 0;

        //判断红球
        for (int i = 0; i < userInputArr.length - 1; i++) {
            int redNumber = userInputArr[i];
            for (int j = 0; j < arr.length - 1; j++) {
                if (redNumber == arr[j]) {
                    redCount++;
                    break;
                }
            }
        }

        //判断蓝球
        int blueNumber = userInputArr[userInputArr.length - 1];
        if (blueNumber == arr[arr.length - 1]) {
            blueCount++;
        }

        //根据红球的个数以及蓝球的个数来判断中奖情况
        if (redCount == 6 && blueCount == 1) {
            System.out.println("恭喜你,中奖1000万");
        } else if (redCount == 6 && blueCount == 0) {
            System.out.println("恭喜你,中奖500万");
        } else if (redCount == 5 && blueCount == 1) {
            System.out.println("恭喜你,中奖3000块");
        } else if ((redCount == 5 && blueCount == 0) || (redCount == 4 && blueCount == 1)) {
            System.out.println("恭喜你,中奖200块");
        } else if ((redCount == 4 && blueCount == 0) || (redCount == 3 && blueCount == 1)) {
            System.out.println("恭喜你,中奖10块");
        } else if ((redCount == 2 && blueCount == 1) || (redCount == 1 && blueCount == 1) || (redCount == 0 && blueCount == 1)) {
            System.out.println("恭喜你,中奖5块");
        } else {
            System.out.println("谢谢参与,谢谢惠顾");
        }
    }

    public static int[] userInputNumber() {
        // 1.创建数组用于添加用户购买的彩票号码
        int[] arr = new int[7];
        Scanner in = new Scanner(System.in);
        //添加红球号码
        for (int i = 0; i < arr.length - 1; ) {
            System.out.println("请输入第" + (i + 1) + "个红球号码:");
            int redNumber = in.nextInt();
            if (redNumber >= 1 && redNumber <= 33) {
                if (!contains(arr, redNumber)) {
                    arr[i] = redNumber;
                    i++;
                } else {
                    System.out.println("当前红球号码已存在,请重新输入:");
                }
            } else {
                System.out.println("当前红球号码超出范围");
            }
        }
        //添加蓝球号码
        System.out.println("请输入蓝球号码:");
        while (true) {
            int blueNumber = in.nextInt();
            if (blueNumber >= 1 && blueNumber <= 16) {
                arr[arr.length - 1] = blueNumber;
                break;
            } else {
                System.out.println("当前蓝球号码超出范围,请重新输入:");
            }
        }
        return arr;
    }

    public static int[] createNumber() {
        //1.创建数组用于添加中奖号码
        int[] arr = new int[7];

        //2.往数组中添加随机的红球号码
        Random r = new Random();
        for (int i = 0; i < arr.length; ) {
            int redNumber = r.nextInt(33) + 1;
            if (!contains(arr, redNumber)) {
                arr[i] = redNumber;
                i++;
            }
        }
        //3.往数组中添加蓝球号码
        int blueNumber = r.nextInt(16) + 1;
        arr[arr.length - 1] = blueNumber;
        return arr;
    }

    public static boolean contains(int[] arr, int number) {
        //判断随机生成的数字是否在数组当中
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                return true;
            }
        }
        return false;
    }
}
