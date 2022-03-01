package com.breakpoint.learn;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author : breakpoint
 * create date : 2022/01/21
 * 欢迎关注公众号 《代码废柴》
 */
public class SpinLockDemo {


    class SpinLock {
        AtomicReference<Thread> atomicReference = new AtomicReference<>();

        public void lock() {
            Thread thread = Thread.currentThread();
            while (!atomicReference.compareAndSet(null, thread)) {

            }
        }

        public void unLock() {
            Thread thread = Thread.currentThread();
            while (atomicReference.compareAndSet(null, thread)) {

            }
        }

    }
}
