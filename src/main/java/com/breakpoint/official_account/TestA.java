package com.breakpoint.official_account;

/**
 * @author breakpoint/赵先生
 * 2020/10/30
 */
public class TestA {

    static {
        System.out.println("我是父类静态代码块：TestA");
    }

    {
        System.out.println("我是父类构造代码块: TestA");
    }

    public TestA() {
        System.out.println("我是父类构造的方法：TestA");
    }
}
