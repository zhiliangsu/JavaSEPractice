package com.hitech.day31_thread1.a03threadcase3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
         *   多线程的第三种实现方式：
         *       特点：可以获取到多线程运行的结果
         *
         *       1. 创建一个类MyCallable实现Callable接口
         *       2. 重写call （是有返回值的，表示多线程运行的结果）
         *
         *       3. 创建MyCallable的对象（表示多线程要执行的任务）
         *       4. 创建FutureTask的对象（作用管理多线程运行的结果）
         *       5. 创建Thread类的对象，并启动（表示线程）
         * */
        MyCallable mc = new MyCallable();
        FutureTask<Integer> ft = new FutureTask<>(mc);
        Thread t = new Thread(ft);
        t.start();
        System.out.println(ft.get());
    }
}
