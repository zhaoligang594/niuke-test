package com.breakpoint.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author :breakpoint/赵立刚
 * @date : 2020/07/19
 */
public class ThreadTest02 {


    public static void main(String[] args) throws Exception {
        System.out.println(Thread.currentThread().getName());

        // one
        MyThread myThread = new MyThread("one");
        myThread.setDaemon(true);
        myThread.start();

        myThread.join();

        // tow
        Thread tow = new Thread(new MyRunnable(), "tow");
        tow.start();
        tow.join();

        // three 匿名
        Thread three = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }, "three");
        three.start();
        three.join();



        // 扩展 线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(()->{
            System.out.println(Thread.currentThread().getName());
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        executorService.shutdown();


    }


}
