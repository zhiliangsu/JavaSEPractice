package com.hitech.day09_oop2.fight1;

public class FightTest1 {
    public static void main(String[] args) {
        //创建角色
        Role r1 = new Role("乔峰", 100);
        Role r2 = new Role("鸠摩智", 100);

        //开始回合制格斗
        while (true) {
            //r1攻击r2
            r1.attack(r2);
            //判断r2的剩余血量
            if (r2.getBlood() == 0) {
                System.out.println(r1.getName() + "K.O.了" + r2.getName());
                break;
            }

            r2.attack(r1);
            if (r1.getBlood() == 0) {
                System.out.println(r2.getName() + "K.O.了" + r1.getName());
                break;
            }
        }

    }
}
