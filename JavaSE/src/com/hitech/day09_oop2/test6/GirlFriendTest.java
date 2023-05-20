package com.hitech.day09_oop2.test6;

public class GirlFriendTest {
    public static void main(String[] args) {
        //1.定义数组
        GirlFriend[] arr = new GirlFriend[4];

        //2.创建女朋友对象
        arr[0] = new GirlFriend("小诗诗", 18, "萌妹子", "吃零食");
        arr[1] = new GirlFriend("小丹丹", 19, "萌妹子", "玩游戏");
        arr[2] = new GirlFriend("小慧慧", 20, "萌妹子", "睡觉");
        arr[3] = new GirlFriend("小静静", 21, "萌妹子", "学习");

        //3.求和
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i].getAge();
        }

        //4.求平均值
        int avg = sum / arr.length;

        //5.统计年龄比平均值低的有几个，并打印她们的信息
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getAge() < avg) {
                count++;
                System.out.println(arr[i].getName() + ", " + arr[i].getAge() + ", " +
                        arr[i].getGender() + ", " + arr[i].getHobby());
            }
        }
        System.out.println(count + "个");
    }
}
