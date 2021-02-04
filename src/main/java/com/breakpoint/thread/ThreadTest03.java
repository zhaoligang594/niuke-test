package com.breakpoint.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author :breakpoint/赵立刚
 * @date : 2020/07/19
 */
public class ThreadTest03 {


    static class Methods {
        Object object = new Object();
        private volatile int stamp = 1;
        public void run01() {
            synchronized (object) {
                if (stamp == 1) {
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(Thread.currentThread().getName());
            }
        }
        public void run02() {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object) {
                object.notify();
                System.out.println(Thread.currentThread().getName());
            }
        }

    }

//    public static void main(String[] args) throws Exception {
//
//        Methods methods = new Methods();
//
//
//        Thread thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                methods.run01();
//            }
//        }, "run01");
//
//        Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                methods.run02();
//            }
//        }, "run02");
//
//        thread1.start();
//        thread2.start();
//
//
//        thread1.join();
//        thread2.join();
//
//
//    }

    static class MyClass extends Object {

    }

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        Class<? extends MyClass> aClass = myClass.getClass();
        System.out.println(aClass.getName());
        System.out.println(aClass.getSuperclass().getName());
    }


}
