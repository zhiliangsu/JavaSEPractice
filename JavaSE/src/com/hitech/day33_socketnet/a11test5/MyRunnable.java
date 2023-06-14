package com.hitech.day33_socketnet.a11test5;

import java.io.*;
import java.net.Socket;
import java.util.UUID;

public class MyRunnable implements Runnable {
    Socket socket;

    public MyRunnable(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // 3.读取数据并保存到本地文件中
            String name = UUID.randomUUID().toString().replace("-", "");
            BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
            BufferedOutputStream bos = new BufferedOutputStream(
                    new FileOutputStream("JavaSE\\src\\com\\hitech\\day33_socketnet\\a00serverdir\\" + name + ".jpg"));
            byte[] bytes = new byte[1024];
            int len;
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
            bos.close();

            // 4.回写数据
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write("上传成功");
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 5.释放资源
            try {
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
