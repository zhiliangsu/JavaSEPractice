package com.hitech.part1.a03exercises;

import java.util.Scanner;

public class BuyTicket {
    public static void main(String[] args) {
        /* 机票价格按照淡季旺季、头等舱和经济舱收费、输入机票原价、月份和头等舱或经济舱。
        按照如下规则计算机票价格：旺季(5-10月)头等舱9折，经济舱8.5折，淡季(11月到来年4月)头等舱7折，经济舱6.5折。*/

        // 1.键盘录入机票原件, 月份, 舱位
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入机票原价: ");
        int ticketPrice = sc.nextInt();
        System.out.println("请输入当前月份: ");
        int month = sc.nextInt();
        System.out.println("请输入预定的舱位: 0 头等舱, 1 经济舱");
        int seat = sc.nextInt();

        // 2.根据录入的信息按规则判断并计算机票最终价钱
        if (month >= 5 && month <= 10) {
            ticketPrice = getTicketPrice(ticketPrice, seat, 0.9, 0.85);
        } else if ((month >= 1 && month <= 4) || (month >= 11 && month <= 12)) {
            ticketPrice = getTicketPrice(ticketPrice, seat, 0.7, 0.65);
        } else {
            System.out.println("键盘录入的月份不合法");
        }
        // 3.打印机票价钱
        System.out.println(ticketPrice);
    }

    private static int getTicketPrice(int ticketPrice, int seat, double x, double x1) {
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
