package com.hitech.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class MyJFrame2 extends JFrame implements MouseListener {

    // 创建2个按钮对象
    JButton jtb1 = new JButton("点我啊");

    public MyJFrame2() {
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

        // 方式三: 通过本类实现MouseListener接口
        jtb1.addMouseListener(this);

        // 把按钮添加到界面当中
        this.getContentPane().add(jtb1);

        // 显示界面
        this.setVisible(true);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("鼠标单击");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("鼠标按下");

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("鼠标松开");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("鼠标划入");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("鼠标划出");
    }
}
