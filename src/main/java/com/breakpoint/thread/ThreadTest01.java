package com.breakpoint.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author :breakpoint/赵立刚
 * @date : 2020/07/14
 */
public class ThreadTest01 {
    /*
            分别打印 ABCD 循环五次
     */
    public static void main(String[] args) throws Exception {
        final MyDemo myDemo = new MyDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    myDemo.loopA(i);
                }
            }
        }, "A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    myDemo.loopB(i);
                }
            }
        }, "B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    myDemo.loopC(i);
                }
            }
        }, "C").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    myDemo.loopD(i);
                }
            }
        }, "D").start();
        TimeUnit.SECONDS.sleep(2);
    }
}

class MyDemo {
    private volatile int stamp = 1;
    private ReentrantLock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();
    Condition conditionD = lock.newCondition();
    public void loopA(int i) {
        lock.lock();
        try {
            if (stamp != 1) {
                conditionA.await();
            }
            System.out.print(Thread.currentThread().getName()+"\t");
            stamp = 2;
            conditionB.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public void loopB(int i) {
        lock.lock();
        try {
            if (stamp != 2) {
                conditionB.await();
            }
            System.out.print(Thread.currentThread().getName()+"\t");
            stamp = 3;
            conditionC.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }


    public void loopC(int i) {
        lock.lock();
        try {
            if (stamp != 3) {
                conditionC.await();
            }
            System.out.print(Thread.currentThread().getName()+"\t");

            stamp = 4;
            conditionD.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public void loopD(int i) {
        lock.lock();
        try {
            if (stamp != 4) {
                conditionD.await();
            }
            System.out.print(Thread.currentThread().getName()+"\t");
            stamp = 1;
            conditionA.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }
}