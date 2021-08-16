package com.breakpoint.leetcode;

/**
 * https://leetcode-cn.com/problems/unique-paths/submissions/
 * 不同路径
 *
 * @author breakpoint/赵先生
 * 2020/12/09
 */
public class Solution62 {

    // 不同的路径数量
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[0][1] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }
}
