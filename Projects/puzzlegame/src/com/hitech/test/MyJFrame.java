package com.hitech.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyJFrame extends JFrame implements ActionListener {

    // 创建2个按钮对象
    JButton jtb1 = new JButton("点我啊");
    JButton jtb2 = new JButton("点我啊");

    public MyJFrame() {
        // 设置宽高
        this.setSize(603, 680);
        // 设置标题
        this.setTitle("拼图单机版 v1.0");
        // 设置置顶
        this.setAlwaysOnTop(true);
        // 设置JFrame界面居中
        this.setLocationRelativeTo(null);
        // 设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 取消隐藏窗体默认居中放置
        this.setLayout(null);


        // 设置位置和宽高
        jtb1.setBounds(0, 0, 100, 50);
        jtb2.setBounds(100, 0, 100, 50);

        // 方式三: 通过本类实现ActionListener接口
        jtb1.addActionListener(this);
        jtb2.addActionListener(this);

        // 把按钮添加到界面当中
        this.getContentPane().add(jtb1);
        this.getContentPane().add(jtb2);

        // 显示界面
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == jtb1) {
            jtb1.setBounds(0, 0, 200, 200);
        } else if (source == jtb2) {
            Random r = new Random();
            jtb2.setLocation(r.nextInt(500), r.nextInt(500));
        }
    }
}
