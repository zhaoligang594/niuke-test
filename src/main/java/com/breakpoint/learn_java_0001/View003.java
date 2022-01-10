package com.breakpoint.learn_java_0001;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : breakpoint
 * create date : 2022/01/08
 * 欢迎关注 《两个菜鸟程序猿》
 */
public class View003 {

    public static void main(String[] args) {

        add(res, 1, 2);
        System.out.println(res.get(0));
    }

    static List<Integer> res = null;

    private static void add(List<Integer> res, int a, int b) {
        res = new ArrayList<>();
        ClassLoader
        res.add(a + b);
    }
}
