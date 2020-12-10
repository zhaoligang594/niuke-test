package com.breakpoint.test;

/**
 * @author breakpoint/zlg
 * 2020/08/27
 */
public class TestNotify {
    public static void main(String[] args) {
        TestNotify testNotify = new TestNotify();
        synchronized (testNotify) {
            testNotify.notify();
        }

    }

    public String concatString(String s1, String s2, String s3) { return s1 + s2 + s3;
    }
}
