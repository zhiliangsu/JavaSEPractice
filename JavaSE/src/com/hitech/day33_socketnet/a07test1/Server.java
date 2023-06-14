package com.hitech.day33_socketnet.a07test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        //客户端：多次发送数据
        //服务器：接收多次接收数据，并打印

        // 1.创建socket对象
        ServerSocket ss = new ServerSocket(10000);

        // 2.监听客户端的链接
        Socket socket = ss.accept();

        // 3.从连接通道中获取输入流读取数据
        // InputStream is = socket.getInputStream();
        // InputStreamReader isr = new InputStreamReader(is);
        // BufferedReader br = new BufferedReader(isr);
        InputStreamReader isr = new InputStreamReader(socket.getInputStream());

        int b;
        while ((b = isr.read()) != -1) {
            System.out.print((char) b);
        }

        // 4.释放资源
        socket.close();
        ss.close();
    }
}
