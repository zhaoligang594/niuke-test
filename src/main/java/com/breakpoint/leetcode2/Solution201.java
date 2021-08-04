package com.breakpoint.leetcode2;

import com.breakpoint.annotation.Success;


@Success
public class Solution201 {

    //https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/solution/shu-zi-fan-wei-an-wei-yu-by-leetcode-solution/

    public static void main(String[] args) {
        //2147483646
        //2147483647
        int i = new Solution201().rangeBitwiseAnd(2147483646, 2147483647);
    }

    public int rangeBitwiseAnd(int left, int right) {
        for (int i = 0; i < 31; i++) {
            int k = 1 << i;
            if (k < right && k - 1 >= left) {
                return 0;
            }
        }
        int res = left;
        for (int i = left; i <= right && i < Integer.MAX_VALUE; i++) {
            res &= i;
        }
        return res;
    }
}
