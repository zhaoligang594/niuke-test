package com.breakpoint.learn;

/**
 * @author breakpoint/赵先生
 * 2020/11/24
 */
public class TestB extends TestA {
    public static void main(String[] args) {
        TestAnnotation annotation = TestB.class.getAnnotation(TestAnnotation.class);
        System.out.println(annotation);
    }
}
