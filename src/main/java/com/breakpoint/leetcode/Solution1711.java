package com.breakpoint.leetcode;

/**
 * https://leetcode-cn.com/problems/count-good-meals/
 */
public class Solution1711 {

    public static void main(String[] args) {

    }

    public int countPairs(int[] deliciousness) {

        return 0;
    }


    private boolean isBigFood(int i) {
        while (i > 1 && (i & 1) == 0) {
            i = i >> 1;
        }
        return i == 1;
    }
}
