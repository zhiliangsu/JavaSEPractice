package com.hitech.day33_socketnet.a03udpdemo2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ReceiveMessageDemo {
    public static void main(String[] args) throws IOException {
        // 1.创建socket对象
        DatagramSocket ds = new DatagramSocket(10086);
        // 2.创建packet对象
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);

        while (true) {
            // 3.接收数据
            ds.receive(dp);
            // 4.解析数据包
            byte[] data = dp.getData();
            int len = dp.getLength();
            String ip = dp.getAddress().getHostAddress();
            String name = dp.getAddress().getHostName();
            System.out.println("ip为：" + ip + ",主机名为：" + name + "的人，发送了数据：" + new String(data,0,len));
        }
    }
}
