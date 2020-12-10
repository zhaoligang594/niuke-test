package com.breakpoint.test;

/**
 * 测试包装类等等
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/08/20
 */
public class Test01 {

    /*
            所有的包装类: 在 -128～127 之间的数 是可以直接的进行比较的 其他的数比较 要用 equals
     */

    public static void main(String[] args) {
        System.out.println(Void.TYPE==void.class);
        Integer a = 128;
        Integer b = 128;
        System.out.println(a == b);
        Long c = -129L;
        Long d = -129L;
        System.out.println(c == d);
    }
}
