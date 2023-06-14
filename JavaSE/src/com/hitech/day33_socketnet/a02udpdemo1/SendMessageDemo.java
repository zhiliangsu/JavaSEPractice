package com.hitech.day33_socketnet.a02udpdemo1;

import java.io.IOException;
import java.net.*;

public class SendMessageDemo {
    public static void main(String[] args) throws IOException {

        //1.创建socket对象(udp)
        DatagramSocket ds = new DatagramSocket();
        //2.创建packet对象(数据包)
        String message = "HelloWorld";
        InetAddress localhost = InetAddress.getByName("localhost");
        DatagramPacket dp = new DatagramPacket(message.getBytes(), message.length(), localhost, 10086);
        //3.发送数据
        ds.send(dp);
        //4.释放资源(关闭socket)
        ds.close();
    }
}
