package com.breakpoint.learn;

/**
 * @author : breakpoint
 * create date : 2022/02/23
 * 欢迎关注公众号 《代码废柴》
 */
public class StackOverFlowDemo {

    public static void main(String[] args) {
        stackoverflow(0);
    }

    private static void stackoverflow(int i) {
        System.out.println(i);
        stackoverflow(i + 1);
    }
}
