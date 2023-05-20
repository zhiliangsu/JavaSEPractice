package com.hitech.day07_exercise.test;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        /* 机票价格按照淡季旺季、头等舱和经济舱收费、输入机票原价、月份和头等舱或经济舱。
        按照如下规则计算机票价格：旺季(5-10月)头等舱9折，经济舱8.5折，淡季(11月到来年4月)头等舱7折，经济舱6.5折。*/
        Scanner in = new Scanner(System.in);
        System.out.println("请输入机票原价：");
        int ticketPrice = in.nextInt();
        System.out.println("请输入购买的月份：");
        int month = in.nextInt();
        System.out.println("请输入当前购买的仓位：0 头等舱 1 经济舱");
        int seat = in.nextInt();

        if (month >= 5 && month <= 10) {
            //旺季
            ticketPrice = getTicketPrice(seat, ticketPrice, 0.9, 0.85);

        } else if ((month >= 1 && month <= 4) || (month >= 11 && month <= 12)) {
            //淡季
            ticketPrice = getTicketPrice(seat, ticketPrice, 0.7, 0.65);
        } else {
            System.out.println("键盘录入的月份不合法");
        }
        System.out.println(ticketPrice);
    }

    public static int getTicketPrice(int seat, int ticketPrice, double x, double x1) {
        if (seat == 0) {
            ticketPrice = (int) (ticketPrice * x);
        } else if (seat == 1) {
            ticketPrice = (int) (ticketPrice * x1);
        } else {
            System.out.println("没有这个舱位");
        }
        return ticketPrice;
    }
}
