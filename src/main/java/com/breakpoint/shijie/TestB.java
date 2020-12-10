package com.breakpoint.shijie;

/**
 * @author breakpoint/赵先生
 * 2020/10/30
 */
public class TestB extends TestA {
    static {
        System.out.println("B1");
    }

    {
        System.out.println("B2");
    }

    public TestB() {

        System.out.println("B3");
    }

    public int TestB() {

        return 0;
    }

    public static void main(String[] args) {
        TestB testB = new TestB();
        System.out.println(testB.TestB());
    }
}
