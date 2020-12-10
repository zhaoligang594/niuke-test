package com.breakpoint.leetcode;

/**
 * @author breakpoint/赵先生
 * 2020/11/03
 */
public class Solution941 {

    public static void main(String[] args) {

    }

    public boolean validMountainArray(int[] A) {
        if (A.length > 3) {
            int tag = 0;
            int[] dp = new int[A.length];
            for (int i = 1; i < A.length; i++) {
                if (A[i] == A[i - 1]) return false;
                dp[i] = A[i] - A[i - 1] > 0 ? 1 : -1;
                if (i > 1) {
                    if (dp[i] != dp[i - 1]) tag++;
                }
            }
            // 只有一个转折点 而且 刚开始是上升的 状态
            return tag == 1 && dp[1] == 1;
        }
        return false;
    }
}
