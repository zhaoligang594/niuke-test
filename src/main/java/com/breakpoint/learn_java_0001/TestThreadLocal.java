package com.breakpoint.learn_java_0001;

/**
 * ThreadLocal
 *
 * @author : breakpoint
 * create date : 2022/01/08
 * 欢迎关注 《两个菜鸟程序猿》
 */
public class TestThreadLocal {
    public static void main(String[] args) {
        ThreadLocal<Object> threadLocal = new ThreadLocal<>();
        Object o = new Object();
        System.out.println(o);
        threadLocal.set(o);
        threadLocal.set(null);
        Object o1 = threadLocal.get();
        System.out.println(o1);
    }
}
