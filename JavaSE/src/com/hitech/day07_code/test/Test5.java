package com.hitech.day07_code.test;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        //在唱歌比赛中，有6名评委给选手打分，分数范围是[0-100]之间的整数。
        //选手的最后得分为：去掉最高分、最低分后的4个评委的平均分，请完成上述过程并计算出选手的得分
        //1.定义一个数组，用来存储6名评委的打分
        int[] scoreArr = getScores();
        //2.求出数组中的最大值
        int max = getMax(scoreArr);
        //3.求出数组中的最小值
        int min = getMin(scoreArr);
        //4.求出数组中6个分数的总和
        int sum = getSum(scoreArr);
        //5.（总和-最大值-最小值）/4
        int avg = (sum - max - min) / (scoreArr.length - 2);
        //6.打印结果
        System.out.println("当前选手的最终得分是：" + avg);
    }


    public static int getSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static int getMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }

    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int[] getScores() {
        int[] scores = new int[6];
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < scores.length; ) {
            System.out.println("请输入评委的打分：");
            int score = in.nextInt();
            if (score >= 0 && score <= 100) {
                scores[i] = score;
                i++;
            } else {
                System.out.println("成绩超出了范围，请重新录入，当前i为：" + i);
            }
        }
        return scores;
    }
}
