package com.hitech.day33_socketnet.a01InetAddressdemo;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class MyInetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
        /*
        static InetAddress getByName(String host)  确定主机名称的IP地址。主机名称可以是机器名称，也可以是IP地址
        String getHostName()                        获取此IP地址的主机名
        String getHostAddress()                     返回文本显示中的IP地址字符串
        */

        //获取InetAddress的对象
        InetAddress[] address = InetAddress.getAllByName("szl");
        System.out.println(Arrays.toString(address));
        for (InetAddress inetAddress : address) {
            System.out.println(inetAddress.getHostName()+"/"+inetAddress.getHostAddress());
        }
    }
}
