package com.breakpoint.learn;

/**
 * @author breakpoint/赵先生
 * 2020/11/24
 */
@TestAnnotation
public class TestA {

    public static void main(String[] args) {
        TestAnnotation annotation = TestA.class.getAnnotation(TestAnnotation.class);
        System.out.println(annotation);
    }
}
