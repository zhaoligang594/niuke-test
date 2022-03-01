package com.breakpoint.learn_java_0001;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * ThreadLocal
 *
 * @author : breakpoint
 * create date : 2022/01/08
 * 欢迎关注 《两个菜鸟程序猿》
 */
public class TestThreadLocal {
    public static void main(String[] args) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        final ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
            @Override
            protected Integer initialValue() {
                System.out.println(Thread.currentThread().getName() + "调用了这个方法");
                return atomicInteger.getAndIncrement();
            }
        };

        new Thread(() -> {
            threadLocal.remove();
            System.out.println(threadLocal.get());
            threadLocal.remove();
            System.out.println(threadLocal.get());
        }).start();
    }
}
