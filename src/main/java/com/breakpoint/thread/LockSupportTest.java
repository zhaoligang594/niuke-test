package com.breakpoint.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2021-03-23
 */
public class LockSupportTest {

    static final Object object = new Object();

    public static void main(String[] args) {

        System.out.println(String.format("%010d", 2147483647+1));

        Thread thread = new Thread(() -> {
            System.out.println("我执行了1");
            LockSupport.park(object);
            System.out.println("我执行了2");
        });

        // 启动线程
        thread.start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我只行了3");
            LockSupport.unpark(thread);
        }).start();
    }
}
