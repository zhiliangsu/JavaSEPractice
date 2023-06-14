package com.hitech.day33_socketnet.a03udpdemo2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class SendMessageDemo {
    public static void main(String[] args) throws IOException {

        // 1.创建socket对象(udp)
        DatagramSocket ds = new DatagramSocket();
        // 2.创建packet对象(数据包)
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("请输入你想要说的话: ");
            String message = sc.nextLine();
            InetAddress address = InetAddress.getByName("255.255.255.255");
            DatagramPacket dp = new DatagramPacket(message.getBytes(), message.length(), address, 10086);
            // 3.发送数据
            ds.send(dp);
            if ("886".equals(message)) {
                break;
            }
        }
        // 4.释放资源(关闭socket)
        ds.close();
    }
}
