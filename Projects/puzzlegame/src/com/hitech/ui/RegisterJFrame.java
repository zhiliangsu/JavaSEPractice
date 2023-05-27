package com.hitech.ui;

import javax.swing.*;

public class RegisterJFrame extends JFrame {
    // 与注册界面有关的逻辑写在这里
    public RegisterJFrame() {
        // 初始化界面
        initFrame();
        // 设置界面显示
        this.setVisible(true);
    }

    private void initFrame() {
        // 设置界面的宽高
        this.setSize(488, 500);
        // 设置界面的标题
        this.setTitle("拼图 注册");
        // 设置界面置顶
        this.setAlwaysOnTop(true);
        // 设置界面居中
        this.setLocationRelativeTo(null);
        // 设置界面关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
