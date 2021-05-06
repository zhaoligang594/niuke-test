package com.breakpoint.thread;


/**
 * 线程礼让的操作
 *
 * @author 赵立刚 <zhaoligang@kuaishou.com>
 * Created on 2021-03-08
 */
public class YeldTest {

    private static final Object lock = new Object();

    public static void main(String[] args) {
        ThreadDemo demo = new ThreadDemo();
        Thread thread = new Thread(demo, "花花");
        Thread thread1 = new Thread(demo, "草草");
        thread.start();
        thread1.start();
        String str = "abc";
        char data[] = {'a', 'b', 'c'};
        String str2 = new String(data);
        System.out.println(str == str2);
        int i = 0;
        long l = System.currentTimeMillis();
        while (i != 1000000000) {
            i++;
        }
        System.out.println(System.currentTimeMillis() - l);
    }

    static class ThreadDemo implements Runnable {
        @Override
        public void run() {
            //synchronized (lock){
            System.out.println("1. 执行的是    " + Thread.currentThread().getName());
            //Thread.yield();
            System.out.println("2. 执行的是    " + Thread.currentThread().getName());
            //}
        }
    }
}
