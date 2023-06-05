package com.hitech.day25_pokergame.doudizhu3;

import java.util.*;

public class PokerGame {

    // 创建牌盒
    static ArrayList<String> list = new ArrayList<>();
    // 创建一个集合,用来添加牌的价值
    static HashMap<String, Integer> hm = new HashMap<>();

    // 静态代码块
    // 特点：随着类的加载而在加载的，而且只执行一次。
    static {
        // 准备牌
        // "♦", "♣", "♥", "♠"
        // "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"
        String[] color = {"♦", "♣", "♥", "♠"};
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        for (String c : color) {
            // c依次表示每一种花色
            for (String n : number) {
                // n 依次表示每一个数字
                list.add(c + n);
            }
        }
        list.add("-小王");
        list.add("+大王");

        // 指定牌的价值
        // 牌上的数字到Map集合中判断是否存在
        // 存在，获取价值
        // 不存在，本身的数字就是价值
        hm.put("J", 11);
        hm.put("Q", 12);
        hm.put("K", 13);
        hm.put("A", 14);
        hm.put("2", 15);
        hm.put("小王", 50);
        hm.put("大王", 100);
    }

    public PokerGame() {
        // 洗牌
        Collections.shuffle(list);

        // 发牌
        ArrayList<String> lord = new ArrayList<>();
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();

        // 遍历牌盒得到每一张牌
        for (int i = 0; i < list.size(); i++) {
            String poker = list.get(i);
            if (i <= 2) {
                lord.add(poker);
                continue;
            }

            // 给三个玩家轮流发牌
            if (i % 3 == 0) {
                player1.add(poker);
            } else if (i % 3 == 1) {
                player2.add(poker);
            } else {
                player3.add(poker);
            }
        }

        // 排序
        order(lord);
        order(player1);
        order(player2);
        order(player3);

        // 看牌
        lookPoker("底牌", lord);
        lookPoker("钢脑壳", player1);
        lookPoker("大帅比", player2);
        lookPoker("蛋筒", player3);
    }

    // 计算牌的价值
    // 参数：牌
    // 返回值：价值
    public int getValue(String poker) {
        // 获取牌上的数字
        String number = poker.substring(1);
        // 拿着数字到map集合中判断是否存在
        if (hm.containsKey(number)) {
            return hm.get(number);// 存在，获取价值
        } else {
            return Integer.parseInt(number);// 不存在，类型转换
        }
    }

    // 利用牌的价值进行排序
    // 参数：集合
    //♥5 ♥3 ♥6 ♥7 ♥9
    private void order(ArrayList<String> list) {
        Collections.sort(list, new Comparator<String>() {
            // Array.sort （插入排序 + 二分查找）
            @Override
            public int compare(String o1, String o2) {
                // o1：表示当前要插入到有序序列中的牌
                // o2：表示已经在有序序列中存在的牌

                // 负数：o1小 插入到前面
                // 正数：o1大 插入到后面
                // 0：o1的数字跟o2的数字是一样的，需要按照花色再次排序

                // 1.计算o1的花色和价值
                String color1 = o1.substring(0, 1);
                int value1 = getValue(o1);

                // 2.计算o2的花色和价值
                String color2 = o2.substring(0, 1);
                int value2 = getValue(o2);

                // 3.比较o1和o2的价值
                int i = value1 - value2;
                return i == 0 ? color1.compareTo(color2) : i;
            }
        });

    }

    /*
     * 参数一：玩家的名字
     * 参数二：每位玩家的牌
     * */
    private void lookPoker(String player, ArrayList<String> list) {
        System.out.print(player + ": ");
        for (String poker : list) {
            System.out.print(poker + " ");
        }
        System.out.println();
    }
}
