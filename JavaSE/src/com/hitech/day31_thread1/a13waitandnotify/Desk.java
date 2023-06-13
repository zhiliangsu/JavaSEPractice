package com.hitech.day31_thread1.a13waitandnotify;

public class Desk {
    // 定义变量记录食物的状态
    // 是否有面条  0：没有面条  1：有面条
    public static int foodFlag = 0;
    // 定义变量记录吃货最多能吃的数量
    //总个数
    public static int count = 10;
    //锁对象
    public static Object lock = new Object();
}
