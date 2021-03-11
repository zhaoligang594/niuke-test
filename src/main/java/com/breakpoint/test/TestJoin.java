package com.breakpoint.test;

/**
 * @author 赵立刚 <zhaoligang@kuaishou.com>
 * Created on 2021-03-02
 */
public class TestJoin {

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable("A", null, 2000));
        thread.start();
        Thread threadB = new Thread(new MyRunnable("B", thread, 500));
        threadB.start();
//        try {
//            thread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    static class MyRunnable implements Runnable {

        private final String name;

        private final Thread thread;

        private final long times;

        public MyRunnable(String name, Thread thread, long times) {
            this.name = name;
            this.thread = thread;
            this.times = times;
        }

        @Override
        public void run() {
            try {
                if (thread != null) thread.join();
                Thread.sleep(times);
                System.out.println(name + "我执行了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
