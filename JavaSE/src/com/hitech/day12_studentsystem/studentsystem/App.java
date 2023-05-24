package com.hitech.day12_studentsystem.studentsystem;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        ArrayList<User> list = new ArrayList<>();
        while (true) {
            System.out.println("==================欢迎来到学生管理系统==================");
            System.out.println("请选择操作: 1->登录 2->注册 3->忘记密码 q->退出");
            Scanner sc = new Scanner(System.in);
            String choice = sc.next();
            switch (choice) {
                case "1" -> login(list);
                case "2" -> register(list);
                case "3" -> forgetPassword(list);
                case "q" -> {
                    System.out.println("谢谢使用,再见");
                    System.exit(0);
                }
                default -> System.out.println("没有这个选项");
            }
        }
    }

    public static void login(ArrayList<User> list) {
        // 1.创建scanner用于键盘录入
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            // 判断用户名
            System.out.println("请输入用户名:");
            String username = sc.next();
            if (!contains(list, username)) {
                System.out.println("用户名" + username + "未注册,请先注册");
                return;
            }
            // 判断验证码和密码是否正确
            System.out.println("请输入密码");
            String password = sc.next();

            // 判断验证码是否正确
            while (true) {
                String rightCode = getCode();
                System.out.println("当前正确的验证码为: " + rightCode);
                System.out.println("请输入验证码:");
                String code = sc.next();
                if (code.equalsIgnoreCase(rightCode)) {
                    System.out.println("验证码正确");
                    break;
                } else {
                    System.out.println("验证码错误");
                }
            }

            // 验证用户名和密码是否正确
            // 集合中是否包含用户名和密码
            // 定义一个方法验证用户名和密码是否正确
            // 封装思想的应用：
            // 我们可以把一些零散的数据，封装成一个对象
            // 以后传递参数的时候，只要传递一个整体就可以了，不需要管这些零散的数据。
            User userInfo = new User(username, password, null, null);
            if (checkUserInfo(list, userInfo)) {
                System.out.println("登录成功,可以开始使用学生管理系统了");
                StudentSystem.startStudentSystem();
                break;
            } else {
                System.out.println("登录失败,用户名或密码错误");
                if (i == 2) {
                    System.out.println("当前用户" + username + "被锁定,请联系管理员");
                    return;
                } else {
                    System.out.println("用户名或密码错误,还剩下" + (2 - i) + "次机会");
                }
            }
        }
    }

    public static void register(ArrayList<User> list) {
        // 1.创建scanner用于键盘录入
        Scanner sc = new Scanner(System.in);

        // 2.键盘录入用户名并校验
        // 一个循环干一件事情
        String username;
        while (true) {
            System.out.println("请输入要注册的用户名: ");
            username = sc.next();
            // 校验输入的用户名格式是否正确
            if (!checkUsername(username)) {
                System.out.println("用户名格式不满足条件,请重新输入:");
                continue;
            }
            // 判断用户名是否唯一(先验证格式,再验证是否唯一)
            if (!contains(list, username)) {
                System.out.println("用户名" + username + "可用");
                break;
            } else {
                System.out.println("用户名" + username + "已存在,请重新输入:");
            }
        }

        // 3.键盘录入密码:密码需要输入2次,2次一致才能注册
        String password;
        while (true) {
            System.out.println("请输入要注册的密码:");
            password = sc.next();
            System.out.println("请再次输入要注册的密码:");
            String againPassword = sc.next();
            if (password.equals(againPassword)) {
                System.out.println("两次输入的密码一致,请继续录入其他数据:");
                break;
            } else {
                System.out.println("两次输入的密码不一致,请重新输入:");
            }
        }

        // 4.键盘录入身份证号码,并校验
        String personID;
        while (true) {
            System.out.println("请输入身份证号码:");
            personID = sc.next();
            if (checkPersonID(personID)) {
                System.out.println("身份证号码满足要求");
                break;
            } else {
                System.out.println("身份证号码格式有误,请重新输入:");
            }
        }

        // 5.键盘录入手机号码,并校验
        String phoneNumber;
        while (true) {
            System.out.println("请输入手机号码:");
            phoneNumber = sc.next();
            if (checkPhoneNumber(phoneNumber)) {
                System.out.println("手机号码满足要求");
                break;
            } else {
                System.out.println("手机号码格式有误,请重新输入:");
            }
        }

        // 6.根据键盘录入的信息创建用户对象并存到集合中去
        User u = new User(username, password, personID, phoneNumber);
        list.add(u);
        System.out.println("用户注册成功");

        // 7.遍历集合
        printList(list);
    }


    public static void forgetPassword(ArrayList<User> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = sc.next();
        if (!contains(list, username)) {
            System.out.println("当前用户" + username + "未注册,请先注册");
            return;
        }
        // 键盘录入身份证号码和手机号码
        System.out.println("请输入身份证号码:");
        String personID = sc.next();
        System.out.println("请输入手机号码");
        String phoneNumber = sc.next();

        // 通过用户名在集合中获取对应的索引
        int index = getIndex(list, username);
        User user = list.get(index);
        // 比较身份证号码和手机号码
        if (!(user.getPersonID().equalsIgnoreCase(personID) &&
                user.getPhoneNumber().equals(phoneNumber))) {
            System.out.println("身份证或手机号码输入有误,不能修改密码");
            return;
        }

        // 代码执行到这里,表示所有的数据已经验证成功,直接修改即可
        String password;
        while (true) {
            System.out.println("请输入新的密码:");
            password = sc.next();
            System.out.println("请再次输入新的密码:");
            String againPasword = sc.next();
            if (password.equals(againPasword)) {
                System.out.println("两次密码输入一致");
                break;
            } else {
                System.out.println("两次密码输入不一致,请重新输入");
            }
        }
        user.setPassword(password);
        System.out.println("密码修改成功");
    }

    public static boolean checkUserInfo(ArrayList<User> list, User userInfo) {
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            if (user.getUsername().equals(userInfo.getUsername()) &&
                    user.getPassword().equals(userInfo.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public static String getCode() {
        // 创建集合存储52个大小写字母
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add((char) ('a' + i));
            list.add((char) ('A' + i));
        }

        // 创建StringBuilder容器存储集合中随机获取到的字母
        StringBuilder sb = new StringBuilder();
        // 随机获取4个字母
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            int randomIndex = r.nextInt(list.size());
            char c = list.get(randomIndex);
            sb.append(c);
        }

        // 随机获取一位数字并放到sb中
        int randomNumber = r.nextInt(10);
        sb.append(randomNumber);

        // 如果要修改字符串中的内容,先把字符串变成字符数组,在数组中修改,然后再创建一个新的字符串
        char[] arr = sb.toString().toCharArray();
        // 拿最后一个索引指向的元素和随机索引指向的元素进行交换
        int randomIndex = r.nextInt(arr.length);
        char temp = arr[randomIndex];
        arr[randomIndex] = arr[arr.length - 1];
        arr[arr.length - 1] = temp;
        return new String(arr);
    }

    public static void printList(ArrayList<User> list) {
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            System.out.println(user.getUsername() + ", " + user.getPassword() + ", " +
                    user.getPersonID() + ", " + user.getPhoneNumber());
        }
    }

    private static boolean checkPhoneNumber(String phoneNumber) {
        // 判断手机号号长度是否满足要求(11)位
        if (phoneNumber.length() != 11) {
            return false;
        }
        // 判断身手机号是否为零开头
        if (phoneNumber.charAt(0) == '0') {
            return false;
        }
        // 手机号必须都为数字
        for (int i = 0; i < phoneNumber.length(); i++) {
            char c = phoneNumber.charAt(i);
            if (!(c >= '0' && c <= '9')) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkPersonID(String personID) {
        // 判断身份证号长度是否满足要求(18)位
        if (personID.length() != 18) {
            return false;
        }
        // 判断身份证号是否为零开头
        if (personID.charAt(0) == '0') {
            return false;
        }
        // 前17位必须为数字
        for (int i = 0; i < personID.length() - 1; i++) {
            char c = personID.charAt(i);
            if (!(c >= '0' && c <= '9')) {
                return false;
            }
        }
        // 最后一位可以是数字也可以是大写X或小写x
        char lastChar = personID.charAt(personID.length() - 1);
        if ((lastChar >= '0' && lastChar <= '9') || (lastChar == 'X') || (lastChar == 'x')) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean checkUsername(String username) {
        // 判断用户名长度是否满足要求(3~15)位
        if (username.length() < 3 || username.length() > 15) {
            return false;
        }
        // 判断输入的用户名是否是字母加数字的组合,且不能是纯数字
        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'))) {
                return false;
            }
        }
        int count = 0;// count:计算字母个数,如果大于0就表示用户名不是纯数字
        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                count++;
                break;
            }
        }
        return count > 0;
    }

    public static boolean contains(ArrayList<User> list, String username) {
        return getIndex(list, username) >= 0;
    }

    public static int getIndex(ArrayList<User> list, String username) {
        for (int i = 0; i < list.size(); i++) {
            String newUsername = list.get(i).getUsername();
            if (newUsername.equals(username)) {
                return i;
            }
        }
        return -1;
    }
}
