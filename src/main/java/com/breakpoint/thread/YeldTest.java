package com.breakpoint.thread;


/**
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
