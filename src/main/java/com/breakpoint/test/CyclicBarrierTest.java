package com.breakpoint.test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier:他是一个循环操作的 没到0 的时候，就会进行统一的执行。
 *
 * @author breakpoint/zlg
 * 2020/08/27
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(10, new Runnable() {
            @Override
            public void run() {

                System.out.println(Thread.currentThread().getName() + "我执行了！！！！");
            }
        });

        for (int i = 0; i < 8; i++) {
            new Thread(new MyRunnable(cb)).start();
        }


    }

    private static class MyRunnable implements Runnable {

        private CyclicBarrier cb;

        public MyRunnable(CyclicBarrier cb) {
            this.cb = cb;
        }

        @Override
        public void run() {
            try {
                cb.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "哈哈哈～～～～～～");
        }
    }


}
