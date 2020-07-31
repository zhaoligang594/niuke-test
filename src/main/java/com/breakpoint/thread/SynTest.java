package com.breakpoint.thread;

/**
 * @author :breakpoint/赵立刚
 * @date : 2020/07/19
 */
public class SynTest {

    public static void main(String[] args) {
        // 可重入 锁
        SynTest.method();
        // SynTest.class  stamp=0  stamp=1

    }

    public static synchronized void method() {
        method2();
    }

    public static synchronized void method2() {
        System.out.println("method2");
    }
}
