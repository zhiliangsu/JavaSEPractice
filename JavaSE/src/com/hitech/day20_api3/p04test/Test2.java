package com.hitech.day20_api3.p04test;

public class Test2 {
    public static void main(String[] args) {
        /*
            自己实现parseInt方法的效果，将字符串形式的数据转成整数。
            要求:
            字符串中只能是数字不能有其他字符
            最少一位，最多10位
            0不能开头
        */
        // 1.定义一个用于测试结果的字符串
        String str = "123456789";
        // 2.利用正则表达式校验字符串
        // 习惯:会先把异常的数据进行过滤,剩下来就是正常的数据
        if (!str.matches("[1-9]\\d{0,9}")) {
            // 错误的数据
            System.out.println("数据格式有误");
        } else {
            // 正确的数据
            System.out.println("数据格式正确");
            // 3.定义一个变量表示最终的结果
            int num = 0;
            // 4.遍历字符串得到里面的每一个字符
            for (int i = 0; i < str.length(); i++) {
                // 把每一位字符与字符'0'相减得到数字放到num当中
                int c = str.charAt(i) - '0';
                num = num * 10 + c;
            }
            System.out.println(num);
            System.out.println(num + 1);
        }

    }
}
