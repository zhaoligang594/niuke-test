package com.breakpoint.leetcode;

import com.breakpoint.annotation.Success;

/**
 * @author 赵立刚 <zhaoligang@kuaishou.com>
 * Created on 2021-03-22
 */
@Success
public class Solution191 {
    public static void main(String[] args) {

    }

    // 求解 1 的 个数
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                res++;
            }
            n = n >>> 1;
        }
        return res;
    }
}
