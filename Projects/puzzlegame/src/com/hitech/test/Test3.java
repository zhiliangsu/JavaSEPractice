package com.hitech.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test3 {
    public static void main(String[] args) {
        // 创建JFrame对象
        JFrame jFrame = new JFrame();
        // 设置宽高
        jFrame.setSize(603, 680);
        // 设置标题
        jFrame.setTitle("事件演示");
        // 设置JFrame界面居中
        jFrame.setLocationRelativeTo(null);
        // 设置置顶
        jFrame.setAlwaysOnTop(true);
        // 设置关闭模式
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 取消隐藏窗体默认居中放置
        jFrame.setLayout(null);

        // 创建一个按钮对象
        JButton jtb = new JButton("点我啊");
        // 设置位置和宽高
        jtb.setBounds(0, 0, 100, 50);
        // 给按钮添加工作监听
        // jtb:组件对象，表示你要给哪个组件添加事件
        // addActionListener：表示我要给组件添加哪个事件监听（动作监听包含鼠标左键点击，空格）
        // 参数：表示事件被触发之后要执行的代码

        // 方式一: 定义一个ActionListener接口的实现类并创建对象
        // jtb.addActionListener(new MyActionListener());

        // 方式二: 通过匿名内部类方法实现ActionListener接口并创建对象
        jtb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("达咩~不要点我啊~");
            }
        });

        // 把按钮添加到界面当中
        jFrame.getContentPane().add(jtb);

        // 显示界面
        jFrame.setVisible(true);
    }
}
