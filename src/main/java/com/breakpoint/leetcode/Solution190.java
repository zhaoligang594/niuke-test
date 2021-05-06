package com.breakpoint.leetcode;

/**
 * 颠倒二进制位数
 * https://leetcode-cn.com/problems/reverse-bits/
 *
 * @author 赵立刚 <zhaoligang@kuaishou.com>
 * Created on 2021-03-22
 */
public class Solution190 {

    public static void main(String[] args) {
        /*
            返回数据
         */
    }

    public int reverseBits(int n) {
        int res = 0;
        int k = 32;
        // 循环 31 次
        while (k > 1) {
            res = res | (n & 1);
            res = res << 1;
            n = n >>> 1;
            k--;
        }
        // 保留最后一次的位数
        res = res | (n & 1);
        return res;
    }
}
