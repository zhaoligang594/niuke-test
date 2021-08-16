package com.breakpoint.leetcode2;

/**
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/14
 */
public class Solution509 {

    public static void main(String[] args) {

    }

    // 采用滚动数组的方式
    public int fib(int n) {
        if (n == 0) return 0;
        if (1 == n || 2 == n) return 1;
        int a = 1, b = 1, c = 0;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
