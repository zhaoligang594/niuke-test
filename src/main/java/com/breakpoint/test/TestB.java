package com.breakpoint.test;

import java.lang.reflect.Field;

/**
 * @author breakpoint/赵先生
 * 2020/11/04
 */
public class TestB extends TestA {

    private String testB;

    public static void main(String[] args) {
        Class<TestB> clazz = TestB.class;
        Class<? super TestB> superclass = clazz.getSuperclass();
        Field[] declaredFields1 = superclass.getDeclaredFields();
        System.out.println(declaredFields1.length);
        Field[] declaredFields = clazz.getDeclaredFields();
        System.out.println(declaredFields.length);
    }
}
