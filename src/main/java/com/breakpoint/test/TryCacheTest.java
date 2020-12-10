package com.breakpoint.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author breakpoint/赵先生
 * 2020/11/29
 */
public class TryCacheTest {

    public static void main(String[] args) {
        System.out.println(testTryCatch());
    }

    public static int testTryCatch() {
        int result = 0;
        try {
            result += 2;
            return result;
        } catch (Exception e) {
            return result + 1;
        } finally {
            result += 4;
            //return result;
        }
    }


}
