package com.hitech.ui;

import javax.swing.*;

public class LoginJFrame extends JFrame {
    // 与登录界面有关的逻辑写在这里
    public LoginJFrame() {
        //设置界面的宽高
        this.setSize(488, 430);
        //设置界面的标题
        this.setTitle("拼图 登录");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置界面关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //设置界面显示
        this.setVisible(true);
    }
}
