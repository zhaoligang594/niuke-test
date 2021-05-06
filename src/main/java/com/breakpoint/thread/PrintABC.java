package com.breakpoint.thread;

/**
 * @author 赵立刚 <zhaoligang@kuaishou.com>
 * Created on 2021-03-15
 */
public class PrintABC {

    // 主函数
    public static void main(String[] args) {
        Monitor monitor = new Monitor();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                monitor.printA();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                monitor.printB();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                monitor.printC();
            }
        }).start();


    }

    // 定义monitor 来求解
    public static class Monitor {
        private static volatile int tag = 0;

        public void printA() {
            synchronized (this) {
                while (tag != 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        //e.printStackTrace();
                    }
                }
                System.out.print("A");
                tag = 1;
                notifyAll();
            }
        }

        public void printB() {
            synchronized (this) {
                while (tag != 1) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        //e.printStackTrace();
                    }
                }
                System.out.print("B");
                tag = 2;
                notifyAll();
            }
        }

        public void printC() {
            synchronized (this) {
                while (tag != 2) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        //e.printStackTrace();
                    }
                }
                System.out.print("C");
                tag = 0;
                notifyAll();
            }
        }
    }
}
