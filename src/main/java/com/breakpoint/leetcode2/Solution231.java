package com.breakpoint.leetcode2;

/**
 * 2的幂
 * https://leetcode-cn.com/problems/power-of-two/submissions/
 *
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/26
 */
public class Solution231 {

    public boolean isPowerOfTwo(int n) {
        int tag = 1;
        while (0 != n && (n & tag) == 0) {
            n = n >> 1;
        }
        return n == 1;
    }
}
