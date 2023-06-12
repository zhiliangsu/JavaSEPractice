package com.hitech.ui;

import cn.hutool.core.io.FileUtil;
import com.hitech.domain.User;
import com.hitech.util.CodeUtil;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class LoginJFrame extends JFrame implements MouseListener {
    // 与登录界面有关的逻辑写在这里
    // 创建一个集合存储正确的用户名和密码
    ArrayList<User> allUsers = new ArrayList<User>();

    // 初始化用户数据(不需要了)
    /* static {
        allUsers.add(new User("zhangsan", "123"));
        allUsers.add(new User("lisi", "1234"));
    } */

    // 定义变量记录项目路径和图片路径
    static final String projectPath = "C:\\Users\\szl\\IdeaProjects\\JavaPractice\\Projects\\puzzlegame";
    String loginImagePath = projectPath + "\\image\\login";

    // 添加对象
    JTextField username = new JTextField();
    JPasswordField password = new JPasswordField();
    JTextField code = new JTextField();
    JLabel rightCode = new JLabel();
    JButton login = new JButton();
    JButton register = new JButton();

    public LoginJFrame() {
        // 读取本地文件中的用户信息
        readUserInfo();

        // 初始化界面
        initFrame();

        // 初始化界面内容, 添加组件
        initView();

        // 设置界面显示
        this.setVisible(true);
    }

    // 读取本地文件中的用户信息
    private void readUserInfo() {
        // 1.读取数据
        List<String> userInfoStrList = FileUtil.readUtf8Lines(projectPath + "\\userinfo.txt");
        // 2.遍历集合获取用户信息并创建User对象
        for (String str : userInfoStrList) {
            String[] userInfo = str.split("&");
            String[] arr1 = userInfo[0].split("=");
            String[] arr2 = userInfo[1].split("=");
            allUsers.add(new User(arr1[1], arr2[1]));
        }
        System.out.println(allUsers);
    }

    private void initView() {
        // 1.添加用户名文字
        JLabel usernameText = new JLabel(new ImageIcon(loginImagePath + "\\用户名.png"));
        usernameText.setBounds(116, 135, 51, 19);
        this.getContentPane().add(usernameText);

        // 2.添加用户名输入框
        // JTextField username = new JTextField();
        username.setBounds(195, 134, 200, 30);
        this.getContentPane().add(username);

        // 3.添加密码文字
        JLabel passwordText = new JLabel(new ImageIcon(loginImagePath + "\\密码.png"));
        passwordText.setBounds(116, 195, 35, 18);
        this.getContentPane().add(passwordText);

        // 4.添加密码输入框
        // JTextField password = new JTextField();
        // JPasswordField password = new JPasswordField();
        password.setBounds(195, 195, 200, 30);
        this.getContentPane().add(password);

        // 5.添加验证码文字
        JLabel codeText = new JLabel(new ImageIcon(loginImagePath + "\\验证码.png"));
        codeText.setBounds(116, 256, 50, 30);
        this.getContentPane().add(codeText);

        // 6.添加验证码输入框
        // JTextField code = new JTextField();
        code.setBounds(195, 256, 100, 30);
        this.getContentPane().add(code);

        // 7.添加正确的验证码
        // JLabel rightCode = new JLabel();
        String codeStr = CodeUtil.getCode();// 获取随机验证码
        rightCode.setText(codeStr);// 设置内容
        rightCode.setBounds(300, 256, 50, 30);// 设置位置和宽高
        rightCode.addMouseListener(this);// 正确的验证码添加鼠标监听事件
        this.getContentPane().add(rightCode);

        // 8.添加登录按钮
        // JButton login = new JButton();
        login.setBounds(123, 310, 128, 47);
        login.setIcon(new ImageIcon(loginImagePath + "\\登录按钮.png"));
        login.setBorderPainted(false);// 去除按钮的默认边框
        login.setContentAreaFilled(false);// 去除按钮的默认背景
        login.addMouseListener(this);// 登录按钮添加鼠标监听事件
        this.getContentPane().add(login);

        // 9.添加注册按钮
        // JButton register = new JButton();
        register.setBounds(256, 310, 128, 47);
        register.setIcon(new ImageIcon(loginImagePath + "\\注册按钮.png"));
        register.setBorderPainted(false);// 去除按钮的默认边框
        register.setContentAreaFilled(false);// 去除按钮的默认背景
        register.addMouseListener(this);// 注册按钮添加鼠标监听事件
        this.getContentPane().add(register);

        // 10.添加背景图片
        JLabel background = new JLabel(new ImageIcon(loginImagePath + "\\background.png"));
        background.setBounds(0, 0, 470, 390);
        this.getContentPane().add(background);
    }

    private void initFrame() {
        // 设置界面的宽高
        this.setSize(488, 430);
        // 设置界面的标题
        this.setTitle("拼图 登录");
        // 设置界面置顶
        this.setAlwaysOnTop(true);
        // 设置界面居中
        this.setLocationRelativeTo(null);
        // 设置界面关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 设置取消默认居中显示布局
        this.setLayout(null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("鼠标单击");
        if (e.getSource() == login) {
            System.out.println("点击了登录按钮");
            // 获取用户的输入:用户名/密码/验证码
            String usernameInput = username.getText();
            String passwordInput = password.getText();
            String codeInput = code.getText();
            // 创建一个用户对象
            User user = new User(usernameInput, passwordInput);
            System.out.println("用户输入的用户名为: " + usernameInput);
            System.out.println("用户输入的密码为: " + passwordInput);
            // 先比较验证码
            if (codeInput.length() == 0) {
                showJDialog("验证码不能为空");
            } else if (!codeInput.equalsIgnoreCase(rightCode.getText())) {
                showJDialog("验证码输入错误");
            } else if (usernameInput.length() == 0 || passwordInput.length() == 0) {
                showJDialog("用户名或密码为空");
            } else if (contains(user)) {
                System.out.println("用户名和密码正确可以开始玩游戏了");
                // 关闭当前登录界面
                this.setVisible(false);
                // 打开游戏的主界面
                // 需要把当前登录的用户名传递给游戏界面
                new GameJFrame(usernameInput);
            } else {
                showJDialog("用户名或密码错误");
            }
        } else if (e.getSource() == register) {
            System.out.println("点击了注册按钮");
            this.setVisible(false);// 关闭当前界面
            new RegisterJFrame(allUsers);
        } else if (e.getSource() == rightCode) {
            System.out.println("点击了验证码按钮");
            rightCode.setText(CodeUtil.getCode());
        }
    }

    private boolean contains(User user) {
        // 判断用户在集合中是否存在
        for (int i = 0; i < allUsers.size(); i++) {
            User rightUser = allUsers.get(i);
            if ((user.getName().equals(rightUser.getName())) &&
                    (user.getPassword().equalsIgnoreCase(rightUser.getPassword()))) {
                // 有相同的代表存在，返回true，后面的不需要再比
                return true;
            }
        }
        // 循环结束之后还没有找到就表示不存在
        return false;
    }

    private void showJDialog(String content) {
        // 创建弹窗对象
        JDialog jDialog = new JDialog();
        // 给弹框设置大小
        jDialog.setSize(200, 150);
        // 让弹框置顶
        jDialog.setAlwaysOnTop(true);
        // 让弹窗居中
        jDialog.setLocationRelativeTo(null);
        // 弹框不关闭则无法操作下面的界面
        jDialog.setModal(true);
        // 创建JLabel对象管理文字并添加到弹框当中
        JLabel warning = new JLabel(content);// 创建一个管理弹框内容的容器JLabel
        warning.setBounds(0, 0, 200, 150);// 设置位置和宽高
        jDialog.getContentPane().add(warning);// 把弹框内容添加到弹框当中
        // 让弹框显示出来
        jDialog.setVisible(true);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("鼠标按下不松");
        if (e.getSource() == login) {
            login.setIcon(new ImageIcon(loginImagePath + "\\登录按下.png"));
        } else if (e.getSource() == register) {
            register.setIcon(new ImageIcon(loginImagePath + "\\注册按下.png"));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("鼠标松开");
        if (e.getSource() == login) {
            login.setIcon(new ImageIcon(loginImagePath + "\\登录按钮.png"));
        } else if (e.getSource() == register) {
            register.setIcon(new ImageIcon(loginImagePath + "\\注册按钮.png"));
        }
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
