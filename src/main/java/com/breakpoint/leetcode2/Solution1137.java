package com.breakpoint.leetcode2;

/**
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/08
 */
public class Solution1137 {

    public int tribonacci(int n) {
        if (0 == n) return 0;
        if (1 == n) return 1;
        if (2 == n) return 2;
        int a = 1, b = 2, c = 0;
        while (n > 2) {
            c = a + b;
            a = b;
            b = c;
            n--;
        }
        return c;
    }
}
