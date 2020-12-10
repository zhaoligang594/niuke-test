package com.breakpoint.test;

/**
 * @author breakpoint/zlg
 * 2020/08/27
 */
public class SynchronizedTest {

    public static void main(String[] args) {
        System.out.println("哈哈哈");
        a();
    }

    public static synchronized void a() {
        System.out.println("你好呀！！！");
    }
}
