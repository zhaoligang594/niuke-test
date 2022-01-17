package com.breakpoint.learn;

/**
 * @author : breakpoint
 * create date : 2022/01/15
 * 欢迎关注公众号 《代码废柴》
 */
public class SynchronizedLearn {

    /*
            synchronized的作用
             内原子性 存可见性 禁止指令重新排序

            static method
            method
            synchronized(){
                code ...
            }
     */

    volatile int a = 0;

    public static void main(String[] args) {
        int a = 0;

    }


//    public static synchronized void add() {
//    }
//
//    public synchronized void sub() {
//    }

//    public void mid() {
//        synchronized (this) {
//            System.out.println(111);
//        }
//    }

}
