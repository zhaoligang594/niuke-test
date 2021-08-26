package com.breakpoint.leetcode2;

/**
 * https://leetcode-cn.com/problems/number-of-subarrays-with-bounded-maximum/solution/qu-jian-zi-shu-zu-ge-shu-by-leetcode/
 *
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/22
 */
public class Solution795 {

    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        return count(A, R) - count(A, L - 1);
    }

    public int count(int[] A, int bound) {
        int ans = 0, cur = 0;
        for (int x : A) {
            cur = x <= bound ? cur + 1 : 0;
            ans += cur;
        }
        return ans;
    }
}
