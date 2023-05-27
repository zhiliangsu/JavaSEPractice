package com.hitech.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    // 与游戏主界面相关的逻辑写在这里
    // 创建一个二维数组：用来管理数据
    // 加载图片的时候，会根据二维数组中的数据进行加载
    int[][] data = new int[4][4];

    // 定义变量用于记录空白方块的位置
    int x = 0;
    int y = 0;
    // 定义变量记录图片路径
    String path = "Projects\\puzzlegame\\image";
    String iconPath = path + "\\animal\\animal3\\";

    // 定义用于判断胜利的数组win
    int[][] win = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };
    // 定义变量统计步数
    int step = 0;
    String username;

    // 定义random对象用于生成随机数
    Random r = new Random();

    // 创建菜单选项下的功能条目
    JMenuItem girlItem = new JMenuItem("美女");
    JMenuItem animalItem = new JMenuItem("动物");
    JMenuItem sportItem = new JMenuItem("运动");
    JMenuItem replayItem = new JMenuItem("重新游戏");
    JMenuItem reLoginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");
    JMenuItem accountItem = new JMenuItem("公众号");

    public GameJFrame() {
        this(null);
    }

    public GameJFrame(String username) {
        this.username = username;

        // 初始化界面
        initJFrame();

        // 初始化菜单
        initJMenuBar();

        // 初始化数据(打乱图片顺序)
        initData();

        // 初始化图片
        initImage();

        // 设置界面显示, 建议写在最后
        this.setVisible(true);
    }

    private void initData() {
        // 1.创建一个一维数组
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        // 2.遍历数组,把数组中的元素顺序打乱
        Random r = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            int index = r.nextInt(tempArr.length);
            int temp = tempArr[index];
            tempArr[index] = tempArr[i];
            tempArr[i] = temp;
        }

        // 3.遍历一维数组,把数组中的数据添加到二维数组中
        // 解法一: 遍历一维数组
        for (int i = 0; i < tempArr.length; i++) {
            // 记录数组打乱后, 空白方块在二维数组中的位置
            if (tempArr[i] == 0) {
                x = i / 4;
                y = i % 4;
            }
            data[i / 4][i % 4] = tempArr[i];
        }
    }

    private void initImage() {
        // 重新初始化前清空原本已经出现的所有图片
        this.getContentPane().removeAll();

        if (victory()) {
            // 显示胜利的图标
            JLabel winJLabel = new JLabel(new ImageIcon(path + "\\win.png"));
            winJLabel.setBounds(203, 283, 197, 73);
            this.getContentPane().add(winJLabel);
        }

        // 加载当前用户显示
        JLabel accountJLabel = new JLabel("用户: " + this.username);
        accountJLabel.setBounds(50, 10, 150, 20);
        this.getContentPane().add(accountJLabel);
        // 加载计步窗口
        JLabel stepCountJLabel = new JLabel("步数: " + step);
        stepCountJLabel.setBounds(50, 30, 150, 20);
        this.getContentPane().add(stepCountJLabel);

        // 细节：
        // 先加载的图片在上方，后加载的图片塞在下面。
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                // 创建一个ImageIcon对象, 并把ImageIcon对象添加到JLabel对象中
                JLabel jLabel = new JLabel(new ImageIcon(iconPath + data[i][j] + ".jpg"));
                // 指定图片位置
                jLabel.setBounds(105 * j + 83, 105 * i + 134, 105, 105);
                // 给图片添加边框
                // 0:表示让图片凸起来
                // 1：表示让图片凹下去
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                // 把管理容器JLabel对象添加到当前界面
                this.getContentPane().add(jLabel);
            }
        }

        // 添加背景图片, 创建一个ImageIcon对象, 并把ImageIcon对象添加到JLabel对象中
        JLabel background = new JLabel(new ImageIcon(path + "\\background.png"));
        // 指定图片位置
        background.setBounds(40, 40, 508, 560);
        // 把背景图片添加到当前界面
        this.getContentPane().add(background);

        // 刷新界面
        this.getContentPane().repaint();
    }

    private void initJMenuBar() {
        // 创建菜单栏
        JMenuBar jMenuBar = new JMenuBar();
        // 创建菜单选项列表
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutUsJMenu = new JMenu("关于我们");
        JMenu changeImage = new JMenu("更换图片");// 创建更换图片

        // 把功能条目添加到菜单选项中
        // 把美女，动物，运动添加到更换图片当中
        changeImage.add(girlItem);
        changeImage.add(animalItem);
        changeImage.add(sportItem);
        // 把更换图片，重新游戏，重新登录，关闭游戏添加到功能当中
        functionJMenu.add(changeImage);
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);
        // 把公众号添加到关于我们当中
        aboutUsJMenu.add(accountItem);

        // 把菜单选项添加到菜单栏中
        // 把功能，关于我们添加到JMenuBar当中
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutUsJMenu);

        // 功能条目绑定监听事件
        girlItem.addActionListener(this);
        animalItem.addActionListener(this);
        sportItem.addActionListener(this);
        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);

        // 给整个界面设置菜单
        this.setJMenuBar(jMenuBar);
    }

    private void initJFrame() {
        // 设置界面的宽高
        this.setSize(603, 680);
        // 设置界面的标题
        this.setTitle("拼图单机版 v1.0");
        // 设置界面置顶
        this.setAlwaysOnTop(true);
        // 设置界面居中
        this.setLocationRelativeTo(null);
        // 设置界面关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 设置取消默认居中显示布局
        this.setLayout(null);
        // 设置界面添加键盘监听
        this.addKeyListener(this);
    }

    private boolean victory() {
        // 遍历data二维数组,并与win数组进行比较
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] != win[i][j]) {
                    // 如果有一个元素不相等,返回false
                    return false;
                }
            }
        }
        // 遍历结束,所有元素都相等才放回true
        return true;
    }

    private void replay() {
        // 1.计步器清零
        step = 0;
        // 2.重新打乱数字
        initData();
        // 3.重新加载图片
        initImage();
    }

    private void showDialog() {
        // 创建弹窗对象
        JDialog jDialog = new JDialog();
        // 创建一个管理图片的容器JLabel
        JLabel jLabel = new JLabel(new ImageIcon(path + "\\about.png"));
        // 设置位置和宽高
        jLabel.setBounds(0, 0, 258, 258);
        // 把图片添加到弹框当中
        jDialog.getContentPane().add(jLabel);
        // 给弹框设置大小
        jDialog.setSize(344, 344);
        // 让弹框置顶
        jDialog.setAlwaysOnTop(true);
        // 让弹窗居中
        jDialog.setLocationRelativeTo(null);
        // 弹框不关闭则无法操作下面的界面
        jDialog.setModal(true);
        // 让弹框显示出来
        jDialog.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    // 按下不放时触发
    @Override
    public void keyPressed(KeyEvent e) {
        // 判断游戏是否胜利,如果胜利,直接结束此方法,不能再执行下面的代码了
        if (victory()) {
            return;
        }
        int code = e.getKeyCode();
        if (code == 65) {
            // 清空当前界面所有的图片
            this.getContentPane().removeAll();

            // 创建JLabel容器加载完整的图片
            JLabel allJLabel = new JLabel(new ImageIcon(path + "all.jpg"));
            allJLabel.setBounds(83, 134, 420, 420);
            this.getContentPane().add(allJLabel);

            // 加载背景图片
            JLabel background = new JLabel(new ImageIcon(path + "\\background.png"));
            // 指定图片位置
            background.setBounds(40, 40, 508, 560);
            // 把背景图片添加到当前界面
            this.getContentPane().add(background);

            // 刷新界面
            this.getContentPane().repaint();
        }
    }

    // 松开按键时触发
    @Override
    public void keyReleased(KeyEvent e) {
        // 判断游戏是否胜利,如果胜利,直接结束此方法,不能再执行下面的代码了
        if (victory()) {
            return;
        }

        int code = e.getKeyCode();
        // 对上，下，左，右进行判断
        // 左：37 上：38 右：39 下：40
        if (code == 37) {
            System.out.println("向左移动");
            if (y == 3) {
                return;
            }
            // 逻辑：
            // 把空白方块右方的数字往左移动
            data[x][y] = data[x][y + 1];
            data[x][y + 1] = 0;
            y++;
            // 每移动一次，计数器就自增一次。
            step++;
            // 调用方法按照最新的数字加载图片
            initImage();
        } else if (code == 38) {
            System.out.println("向上移动");
            if (x == 3) {
                return;
            }
            // 逻辑：
            // 把空白方块下方的数字往上移动
            // x，y  表示空白方块
            // x + 1， y 表示空白方块下方的数字
            // 把空白方块下方的数字赋值给空白方块
            data[x][y] = data[x + 1][y];
            data[x + 1][y] = 0;
            x++;
            // 每移动一次，计数器就自增一次。
            step++;
            // 调用方法按照最新的数字加载图片
            initImage();
        } else if (code == 39) {
            System.out.println("向右移动");
            if (y == 0) {
                return;
            }
            // 逻辑：
            // 把空白方块左方的数字往右移动
            data[x][y] = data[x][y - 1];
            data[x][y - 1] = 0;
            y--;
            // 每移动一次，计数器就自增一次。
            step++;
            // 调用方法按照最新的数字加载图片
            initImage();
        } else if (code == 40) {
            System.out.println("向下移动");
            if (x == 0) {
                return;
            }
            // 逻辑：
            // 把空白方块上方的数字往下移动
            data[x][y] = data[x - 1][y];
            data[x - 1][y] = 0;
            x--;
            // 每移动一次，计数器就自增一次。
            step++;
            // 调用方法按照最新的数字加载图片
            initImage();
        } else if (code == 65) {
            // 松开A键时重新初始化图片
            initImage();
        } else if (code == 87) {
            // 按下W键并松开立即胜利
            data = new int[][]{
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 0}
            };
            initImage();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == replayItem) {
            System.out.println("重新游戏");
            replay();
        } else if (obj == reLoginItem) {
            System.out.println("重新登录");
            // 1.关闭当前的游戏界面
            this.setVisible(false);
            // 2.创建登录界面对象
            new LoginJFrame();
        } else if (obj == closeItem) {
            System.out.println("关闭游戏");
            System.exit(0);
        } else if (obj == accountItem) {
            System.out.println("公众号");
            showDialog();
        } else if (obj == girlItem) {
            System.out.println("更换美女图片");
            // 在13组美女图片中随机更换一组
            int randomNumber = r.nextInt(13) + 1;
            iconPath = path + "\\girl\\girl" + randomNumber + "\\";
            replay();
        } else if (obj == animalItem) {
            System.out.println("更换动物图片");
            // 在8组动物图片中随机更换一组
            int randomNumber = r.nextInt(8) + 1;
            iconPath = path + "\\animal\\animal" + randomNumber + "\\";
            replay();
        } else if (obj == sportItem) {
            System.out.println("更换运动图片");
            // 在10组运动图片中随机更换一组
            int randomNumber = r.nextInt(10) + 1;
            iconPath = path + "\\sport\\sport" + randomNumber + "\\";
            replay();
        }
    }
}
