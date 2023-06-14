package com.hitech.day33_socketnet.a02udpdemo1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ReceiveMessageDemo {
    public static void main(String[] args) throws IOException {
        // 1.创建socket对象
        DatagramSocket ds = new DatagramSocket(10086);
        // 2.创建packet对象
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
        // 3.接收数据
        ds.receive(dp);
        // 4.解析数据包
        byte[] data = dp.getData();
        int len = dp.getLength();
        InetAddress address = dp.getAddress();
        int port = dp.getPort();
        System.out.println("接收到数据:" + new String(bytes, 0, len));
        System.out.println("该数据是从:" + address + "这台电脑中的" + port + "这个端口发出的");
        // 5.释放资源
        ds.close();

    }
}
