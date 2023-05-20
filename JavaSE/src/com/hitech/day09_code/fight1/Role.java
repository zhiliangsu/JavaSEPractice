package com.hitech.day09_code.fight1;

import java.util.Random;

public class Role {
    private String name;
    private int blood;

    public Role() {
    }

    public Role(String name, int blood) {
        this.name = name;
        this.blood = blood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public void attack(Role role) {
        //计算造成的伤害(1~20间的随机值)
        Random r = new Random();
        int hurt = r.nextInt(20) + 1;
        //计算剩余血量
        int remainBlood = role.getBlood() - hurt;
        //对剩余血量进行验证,如果为负数了,就修改为0
        remainBlood = remainBlood < 0 ? 0 : remainBlood;
        //验证完后修改一下受到攻击的人的剩余血量
        role.setBlood(remainBlood);

        System.out.println(this.getName() + "举起拳头,打了" + role.getName() + "一下," +
                "造成了" + hurt + "点伤害," + role.getName() + "还剩下了" + remainBlood + "点血");
    }
}
