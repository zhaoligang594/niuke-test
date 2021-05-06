package com.breakpoint.type;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

/**
 * @author 赵立刚 <zhaoligang@kuaishou.com>
 * Created on 2021-03-18
 */
public class TypeTest {

    public static void main(String[] args) {
        EnumTest a = EnumTest.A;
        MyType<String> myType = new MyType<String>();
        Field[] declaredFields = myType.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field.getType());
            Type genericType = field.getGenericType();
            System.out.println(field.getGenericType().getTypeName());
        }
    }

    static class MyType<T> {
        private T data;
    }
}
