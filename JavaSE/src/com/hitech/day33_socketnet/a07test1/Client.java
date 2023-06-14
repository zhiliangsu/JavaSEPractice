package com.hitech.day33_socketnet.a07test1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        //客户端：多次发送数据
        //服务器：接收多次接收数据，并打印


        // 1.创建socket对象
        Socket socket = new Socket("127.0.0.1", 10000);

        // 2.获取输出流
        OutputStream os = socket.getOutputStream();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入要发送的信息: ");
            String message = sc.nextLine();
            if ("q".equals(message)) {
                break;
            }
            // 3.写出数据
            os.write(message.getBytes());
            os.write("\r\n".getBytes());
        }
        // 4.释放资源
        socket.close();
    }
}
