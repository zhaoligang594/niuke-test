package com.breakpoint.thread;

/**
 * @author :breakpoint/赵立刚
 * @date : 2020/07/19
 */
public class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
