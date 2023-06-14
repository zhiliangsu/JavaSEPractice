package com.hitech.day33_socketnet.a08test2;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        //客户端：发送一条数据，接收服务端反馈的消息并打印
        //服务器：接收数据并打印，再给客户端反馈消息

        ServerSocket ss = new ServerSocket(10000);

        //服务端接收消息
        Socket socket = ss.accept();
        InputStreamReader isr = new InputStreamReader(socket.getInputStream());
        int b;
        //细节：
        //read方法会从连接通道中读取数据
        //但是，需要有一个结束标记，此处的循环才会停止
        //否则，程序就会一直停在read方法这里，等待读取下面的数据
        while ((b = isr.read()) != -1) {
            System.out.print((char) b);
        }

        //服务端发送消息
        OutputStream os = socket.getOutputStream();
        String str = "有多高兴?";
        os.write(str.getBytes());

        socket.close();
        ss.close();
    }
}
