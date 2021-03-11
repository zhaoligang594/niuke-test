package com.breakpoint.test;

/**
 * @author 赵立刚 <zhaoligang@kuaishou.com>
 * Created on 2021-03-02
 */
public class CloneableTest {

    public static void main(String[] args) throws Exception {
        A a = new A();
        Object clone = a.clone();
    }


    static class A  implements Cloneable{
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}
