package com.breakpoint.test;

import java.util.concurrent.CountDownLatch;

/**
 * @author breakpoint/zlg
 * 2020/08/27
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws Exception {
        CountDownLatch cdl = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            new Thread(new MyRunnable(cdl)).start();
            cdl.countDown();
        }


    }

    private static class MyRunnable implements Runnable {
        private CountDownLatch cdl;

        public MyRunnable(CountDownLatch cdl) {
            this.cdl = cdl;
        }

        @Override
        public void run() {

            try {
                // 线程在这里进行等待 直到  cdl.countDown();==0的时候
                cdl.await();
                System.out.println("进入休眠");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("do work !!!!!!");

        }
    }
}
