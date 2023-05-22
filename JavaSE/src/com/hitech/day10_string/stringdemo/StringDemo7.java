package com.hitech.day10_string.stringdemo;

import java.util.Scanner;

public class StringDemo7 {
    public static void main(String[] args) {
        //金额转换

        //1.键盘录入一个金额数字并进行校验
        Scanner in = new Scanner(System.in);
        int money;
        while (true) {
            System.out.println("请输入一个金额：");
            money = in.nextInt();
            if (money >= 0 && money <= 9999999) {
                break;
            } else {
                System.out.println("输入的金额无效，请重新输入");
            }
        }

        //2.创建一个方法，把录入的金额数字转换成中文大写数字
        String moneyStr = "";
        while (true) {
            //从右往左获取数据，因为右侧是数据的个位
            int ge = money % 10;
            //把转换后的大写拼接到moneyStr当中
            moneyStr = getCapitalNumber(ge) + moneyStr;
            //去掉刚刚获取的数据
            money = money / 10;
            //如果数字上的每一位全都获取到了，那么money记录的就是0，此时循环结束
            if (money == 0) {
                break;
            }
        }

        //3.金额如果不满7位，前面补零
        int count = 7 - moneyStr.length();
        for (int i = 0; i < count; i++) {
            moneyStr = "零" + moneyStr;
        }
        System.out.println(moneyStr);

        //4.对金额进行拼接单位操作
        String result = "";
        String[] arr = {"佰", "拾", "万", "仟", "佰", "拾", "元"};
        for (int i = 0; i < moneyStr.length(); i++) {
            result = result + moneyStr.charAt(i) + arr[i];
        }

        //5.打印最终结果
        System.out.println(result);
    }

    public static String getCapitalNumber(int number) {
        String[] arr = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
        return arr[number];
    }
}
