package com.breakpoint.learn_java_0001;

import java.util.Objects;

/**
 * @author : breakpoint
 * create date : 2022/01/08
 * 欢迎关注 《两个菜鸟程序猿》
 */
public class View001 {
    public static void main(String[] args) {
        // == 和 equals
        MyTest a = new MyTest(1);
        MyTest b = new MyTest(1);
        System.out.println(a.equals(b));
    }

    static class MyTest {
        int a;

        public MyTest(int a) {
            this.a = a;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MyTest myTest = (MyTest) o;
            return a == myTest.a;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a);
        }
    }
}
