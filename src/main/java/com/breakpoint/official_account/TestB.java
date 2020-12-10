package com.breakpoint.official_account;

/**
 * @author breakpoint/赵先生
 * 2020/10/30
 */
public class TestB extends TestA {

    static {
        System.out.println("我是子类静态代码块：TestB");
    }

    {
        System.out.println("我是子类构造代码块: TestB");
    }

    public TestB() {
        System.out.println("我是子类构造的方法：TestB");
    }

    public static void main(String[] args) {
        new TestB();
    }
}
