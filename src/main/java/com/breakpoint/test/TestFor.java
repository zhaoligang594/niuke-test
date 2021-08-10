package com.breakpoint.test;

/**
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/10
 */
public class TestFor {

    public static void main(String[] args) {
        long startA = System.nanoTime();
        for (int i = 0; i < 1_000_000_000;) {
            //System.out.print(i + "  ");
            i++;

        }
        long endA = System.nanoTime();
        System.out.println("消耗时间" + (endA - startA));
        System.out.println();
        long startB = System.nanoTime();
        System.out.println("================");
        for (int i = 0; i < 1_000_000_000;) {
            //System.out.print(i + "  ");
            ++i;
        }
        long endB = System.nanoTime();
        System.out.println("消耗时间" + (endB - startB));
    }
}
