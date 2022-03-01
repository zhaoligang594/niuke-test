package com.breakpoint.learn;


import java.util.concurrent.TimeUnit;

class MyDeadLockRunnable implements Runnable {
    String lockA;
    String lockB;

    public MyDeadLockRunnable(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "已经获取到了锁" + lockA + "尝试获取锁" + lockB);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "获取到锁B");
            }
        }
    }
}

/**
 * 死锁的一种实现
 * 他们之间都想获取其他的资源，导致的互相等待的局面
 *
 * @author : breakpoint
 * create date : 2022/02/22
 * 欢迎关注公众号 《代码废柴》
 */
public class DeadLockDemo {

    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new MyDeadLockRunnable(lockA, lockB), "AAAA").start();
        new Thread(new MyDeadLockRunnable(lockB, lockA), "BBBB").start();
    }
}
