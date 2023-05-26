package com.hitech.test;

import java.util.Random;

public class Test2 {
    public static void main(String[] args) {
        // 需求:
        // 把一个一维数组中的数据:0~15打乱顺序
        // 然后按照4个一组的方式添加到二维数组中

        // 1.创建一个一维数组
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        // 2.遍历数组,把数组中的元素顺序打乱
        Random r = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            int index = r.nextInt(tempArr.length);
            int temp = tempArr[index];
            tempArr[index] = tempArr[i];
            tempArr[i] = temp;
        }

        for (int i = 0; i < tempArr.length; i++) {
            System.out.print(tempArr[i] + " ");
        }
        System.out.println();

        // 3.定义一个二维数组用于存放数据
        int[][] data = new int[4][4];

        // 4.遍历一维数组,把数组中的数据添加到二维数组中
        // 解法二: 遍历二维数组
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = tempArr[count];
                count++;
            }
        }

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j]+" ");
            }
            System.out.println();
        }


    }
}
