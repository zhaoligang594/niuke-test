package com.breakpoint.thread;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

/**
 * @author :breakpoint/赵立刚
 * create on 2020/07/19
 */
public class MyThread extends Thread {

    public MyThread(@NotNull String name) {
        super(name);
    }

    @Override
    public void run() {
        ///
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
