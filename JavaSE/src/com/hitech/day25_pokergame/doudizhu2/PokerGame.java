package com.hitech.day25_pokergame.doudizhu2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class PokerGame {

    // 创建牌盒
    // 此时我们只要把牌跟序号产生对应关系就可以了，不需要按照序号进行排序，所以只要HashMap就可以了
    static HashMap<Integer, String> hm = new HashMap<>();
    static ArrayList<Integer> list = new ArrayList<>();

    // 静态代码块
    // 特点：随着类的加载而在加载的，而且只执行一次。
    static {
        // 准备牌
        // "♦", "♣", "♥", "♠"
        // "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"
        String[] color = {"♦", "♣", "♥", "♠"};
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        // 序号
        int serialNumber = 1;
        // 细节:先遍历数字,再遍历花色
        for (String n : number) {
            // n 依次表示每一个数字
            for (String c : color) {
                // c依次表示每一种花色
                hm.put(serialNumber, c + n);
                list.add(serialNumber);
                serialNumber++;
            }
        }

        hm.put(serialNumber, "小王");
        list.add(serialNumber);
        serialNumber++;
        hm.put(serialNumber, "大王");
        list.add(serialNumber);
    }

    public PokerGame() {
        // 洗牌
        Collections.shuffle(list);

        // 发牌
        TreeSet<Integer> lord = new TreeSet<>();
        TreeSet<Integer> player1 = new TreeSet<>();
        TreeSet<Integer> player2 = new TreeSet<>();
        TreeSet<Integer> player3 = new TreeSet<>();

        // 遍历牌盒得到每一张牌
        for (int i = 0; i < list.size(); i++) {
            // i :依次表示集合中的每一个索引
            // list.get(i)元素：牌的序号
            int serialNumber = list.get(i);
            if (i <= 2) {
                lord.add(serialNumber);
                continue;
            }

            // 给三个玩家轮流发牌
            if (i % 3 == 0) {
                player1.add(serialNumber);
            } else if (i % 3 == 1) {
                player2.add(serialNumber);
            } else {
                player3.add(serialNumber);
            }
        }

        // 看牌
        lookPoker("底牌", lord);
        lookPoker("钢脑壳", player1);
        lookPoker("大帅比", player2);
        lookPoker("蛋筒", player3);
    }

    /*
     * 参数一：玩家的名字
     * 参数二：每位玩家的牌
     * */
    private void lookPoker(String player, TreeSet<Integer> ts) {
        System.out.print(player + ": ");
        // 遍历TreeSet集合得到每一个序号，再拿着序号到Map集合中去找真正的牌
        for (int serialNumber : ts) {
            System.out.print(hm.get(serialNumber) + " ");
        }
        System.out.println();
    }
}
