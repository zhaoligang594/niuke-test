package com.breakpoint.test;

/**
 * @author :breakpoint/赵立刚
 * @date : 2020/08/21
 */
public class Test03 {


    public static void main(String[] args) throws Exception {
        System.out.println(Math.round(-11.59999999));
        Class<?> aClass = Test03.class.getClassLoader().loadClass("com.breakpoint.test.Test01");
        Class<?> aClass1 = Thread.currentThread().getContextClassLoader().loadClass("com.breakpoint.test.Test01");
        System.out.println(aClass == aClass1);
        ATest aTest = new ATest();
        //aTest = null;
        while (true) {
            Object o = new Object();
        }
    }


    private static class ATest {
        @Override
        protected void finalize() throws Throwable {
            System.out.println("我执行了～～～");
            System.out.println(Thread.currentThread().getName());
        }
    }

    private static class MyThread extends Thread{
        @Override
        public void run() {
            super.run();
        }
    }
}
