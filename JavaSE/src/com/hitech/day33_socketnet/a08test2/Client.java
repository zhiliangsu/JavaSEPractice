package com.hitech.day33_socketnet.a08test2;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        // 客户端：发送一条数据，接收服务端反馈的消息并打印
        // 服务器：接收数据并打印，再给客户端反馈消息

        Socket socket = new Socket("127.0.0.1", 10000);

        // 客户端发送消息
        OutputStream os = socket.getOutputStream();
        String str = "见到你很高兴!";
        os.write(str.getBytes());
        // 写出一个结束标记
        socket.shutdownOutput();

        // 客户端接收消息
        InputStreamReader isr = new InputStreamReader(socket.getInputStream());
        int b;
        while ((b = isr.read()) != -1) {
            System.out.print((char) b);
        }

        socket.close();
    }
}
