package com.breakpoint.shijie;

import java.lang.reflect.Field;

/**
 * @author breakpoint/赵先生
 * 2020/11/12
 */
public class TestC {
    public static void main(String[] args) throws Exception {
        TestD testD = new TestD();
        Class<TestD> testDClass = TestD.class;
        Field[] declaredFields = testDClass.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field.isAccessible());
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            System.out.println(field.get(testD));
        }
    }
}
