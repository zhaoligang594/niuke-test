package com.breakpoint.shijie;

/**
 * @author breakpoint/赵先生
 * 2020/10/30
 */
public class TestA {

    static {
        System.out.println("A1");
    }

    {
        System.out.println("A2");
    }

    public TestA() {

        System.out.println("A3");
    }
}
