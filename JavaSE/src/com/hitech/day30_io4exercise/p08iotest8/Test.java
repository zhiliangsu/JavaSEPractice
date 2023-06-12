package com.hitech.day30_io4exercise.p08iotest8;

import java.io.*;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        /*
        需求：写一个登陆小案例（添加锁定账号功能）

        步骤：
            将正确的用户名和密码手动保存在本地的userinfo.txt文件中。
            保存格式为:username=zhangsan&password=123&count=0
            让用户键盘录入用户名和密码
            比较用户录入的和正确的用户名密码是否一致
            如果一致则打印登陆成功
            如果不一致则打印登陆失败，连续输错三次被锁定

        */

        // 1.读取数据
        String src = "JavaSE\\src\\com\\hitech\\day30_io4exercise\\p08iotest8\\userinfo.txt";
        BufferedReader br = new BufferedReader(new FileReader(src));
        String line = br.readLine();
        br.close();
        String[] userinfo = line.split("&");
        String[] arr1 = userinfo[0].split("=");
        String[] arr2 = userinfo[1].split("=");
        String[] arr3 = userinfo[2].split("=");

        String rightUsername = arr1[1];
        String rightPassword = arr2[1];
        int count = Integer.parseInt(arr3[1]);

        // 2.键盘录入
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名: ");
        String username = sc.nextLine();
        System.out.println("请输入密码: ");
        String password = sc.nextLine();

        // 3.比较
        if (rightUsername.equals(username) && rightPassword.equals(password) && count < 3) {
            System.out.println("登陆成功");
            writeFile(src, "username=" + username + "&password=" + password + "&count=0");
        } else {
            count++;
            if (count < 3) {
                System.out.println("登陆失败,还剩下" + (3 - count) + "次机会");
            } else {
                System.out.println("用户账户被锁定");
            }
            writeFile(src, "username=" + rightUsername + "&password=" + password + "&count=" + count);
        }
    }

    public static void writeFile(String pathFile, String str) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(pathFile));
        bw.write(str);
        bw.close();
    }
}
