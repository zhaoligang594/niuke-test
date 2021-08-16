package com.breakpoint.leetcode;

/**
 * @author 赵立刚 <zhaoligang@kuaishou.com>
 * Created on 2021-01-29
 */
public class Solution63 {

    public static void main(String[] args) {

    }

    // 也是采用的动态规划的操作
    // 如何的求解这个问题
    // 写出状态的转移方程
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        dp[0][1] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                // 判断是否是阻碍物的信息
                if (obstacleGrid[i - 1][j - 1] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
