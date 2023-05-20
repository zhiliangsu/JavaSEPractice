package com.hitech.day07_exercise.test;

public class Test7 {
    public static void main(String[] args) {
        //需求：把整数上的每一位都添加到数组当中
        //反向推导
        //1.计算出数组的长度
        int number = 12345;
        int temp = number;
        int count = 0;
        while (number != 0){
            number = number / 10;
            count++;
        }

        //2.定义一个数组
        int[] arr = new int[count];

        //3.把整数上的每一位都添加到数组中
        int index = arr.length -1;
        while (temp!=0){
            int ge = temp % 10;
            temp = temp / 10;
            arr[index] = ge;
            index--;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }






    }
}
